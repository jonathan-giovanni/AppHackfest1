package org.dev4u.hv.apphackfest1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;

public class MainActivity extends AppCompatActivity {

    private Button btnLogin;
    private EditText txtUser,txtPass;
    private TextView lblRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //init controls
        btnLogin    = (Button) findViewById(R.id.btnLogin);
        txtUser     = (EditText) findViewById(R.id.txtCorreoLogin);
        txtPass     = (EditText) findViewById(R.id.txtPassLogin);
        lblRegistrar= (TextView) findViewById(R.id.lblRegistrar);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logearse();
            }
        });
        lblRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrar();
            }
        });
    }
    //test jonathan
    private void logearse(){

    }
    private void registrar(){
        startActivity(new Intent(this,RegistroActivity.class));
    }
}
