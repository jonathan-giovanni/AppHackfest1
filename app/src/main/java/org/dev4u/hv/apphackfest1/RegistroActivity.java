package org.dev4u.hv.apphackfest1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import controlador.SharedPrefManager;

public class RegistroActivity extends AppCompatActivity {


    EditText txtNombre,txtEmail,txtPass1,txtPass2,txtTel;
    Button btnRegistrar;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        progressBar     = (ProgressBar) findViewById(R.id.progressBarRegistro);
        txtNombre       = (EditText)    findViewById(R.id.txtNombreRegistro);
        txtEmail        = (EditText)    findViewById(R.id.txtCorreoRegistro);
        txtPass1        = (EditText)    findViewById(R.id.txtPass1Registro);
        txtPass2        = (EditText)    findViewById(R.id.txtPass2Registro);
        txtTel          = (EditText)    findViewById(R.id.txtTelRegistro);

        btnRegistrar    = (Button)      findViewById(R.id.btnRegistrar);


        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrar();
            }
        });

        //if(SharedPrefManager.getInstance(this).isLoggedIn()){
        //    finish();
        //    startActivity(new Intent());
        //}

    }
    private void registrar(){
        if(esValido()){
            Toast.makeText(this,"Datos validos",Toast.LENGTH_SHORT).show();
        }
    }
    private boolean esValido(){
        if(txtNombre.getText().toString().isEmpty()     |
                txtEmail.getText().toString().isEmpty() |
                txtTel.getText().toString().isEmpty()   |
                txtPass1.getText().toString().isEmpty() |
                txtPass2.getText().toString().isEmpty()){
            Toast.makeText(this,"Falta completar registro",Toast.LENGTH_SHORT).show();
            return false;
        }else{
            if(txtPass1.getText().toString().equals(txtPass2.getText().toString())){
                return true;
            }else{
                Toast.makeText(this,"No coinciden las contraseñas",Toast.LENGTH_SHORT).show();
                return false;
            }
        }
    }
}
