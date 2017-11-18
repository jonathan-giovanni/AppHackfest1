package org.dev4u.hv.apphackfest1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONObject;

import java.util.Map;

import conexion.ConfigConexion;
import conexion.VolleySingleton;
import controlador.SharedPrefManager;

public class LoginActivity extends AppCompatActivity {

    private Button btnLogin;
    private EditText txtUser,txtPass;
    private TextView lblRegistrar;
    private static Map stringJSONObjectMap;


    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //init controls

        progressBar = (ProgressBar) findViewById(R.id.progressBarLogin);
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

        if(SharedPrefManager.getInstance(this).isLoggedIn()){
            finish();
            startActivity(new Intent(this,PrincipalActivity.class));
        }
    }
    //test jonathan
    private void logearse(){

        final String user = txtUser.getText().toString();
        final String pass = txtPass.getText().toString();
        if(user.isEmpty() | pass.isEmpty()){
            Toast.makeText(this,"Faltan datos",Toast.LENGTH_SHORT).show();
            return;
        }



    }


    private void registrar(){
        startActivity(new Intent(this,RegistroActivity.class));
    }
}
