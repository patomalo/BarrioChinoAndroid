package com.patomalo.barriochinoandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    private String TAG = Login.class.getSimpleName();

    Button login;
    Button register;
    EditText user;
    EditText pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user = (EditText) findViewById(R.id.user);
        pass = (EditText) findViewById(R.id.password);

        login = (Button) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String u = user.getText().toString();
                String ps = pass.getText().toString();
                if(u.equals("pato") && ps.equals("malo")) {
                    Log.d(TAG, "Passed");
                    Intent inicio = new Intent(Login.this, InicioActivity.class);

                    Bundle send = new Bundle();
                    send.putString("userName", u);
                    inicio.putExtras(send);
                    startActivity(inicio);
                } else {
                    Log.d(TAG, "User: "+ u + " Pass: " + ps);
                }
            }
        });
        register = (Button) findViewById(R.id.register);
        register.setOnClickListener(new testRegister());
    }

    public class testRegister implements View.OnClickListener {

        @Override
        public void onClick(View v ) {
            Log.d(TAG, "Start registration");
            Intent register = new Intent(Login.this, RegisterActivity.class);
            startActivity(register);
        }
    }
}
