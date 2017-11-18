package org.dev4u.hv.apphackfest1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ProgressBar;

import controlador.SharedPrefManager;

public class RegistroActivity extends AppCompatActivity {


    EditText txtNombre,txtEmail,txtPass1,txtPass2,txtTel;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        progressBar     = (ProgressBar) findViewById(R.id.progressBarRegistro);
        if(SharedPrefManager.getInstance(this).isLoggedIn()){
            finish();
            startActivity(new Intent());
        }
    }
}
