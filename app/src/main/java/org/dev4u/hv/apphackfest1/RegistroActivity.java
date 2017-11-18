package org.dev4u.hv.apphackfest1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import conexion.ConfigConexion;
import conexion.VolleyRP;

public class RegistroActivity extends AppCompatActivity {


    EditText txtNombre,txtEmail,txtPass1,txtPass2,txtTel;
    Button btnRegistrar;
    ProgressBar progressBar;
    private VolleyRP volley;
    private RequestQueue mRequest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        //conexion bd

        volley = VolleyRP.getInstance(this);
        mRequest = volley.getRequestQueue();
        //controles

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
            registrarWebService(
                    getStringET(txtEmail).trim(),
                    getStringET(txtNombre).trim(),
                    getStringET(txtPass1).trim(),
                    getStringET(txtTel).trim());

        }
    }

    private void registrarWebService(String correo,String nombre, String contraseña, String tel){


        HashMap<String, String> hashMapToken = new HashMap<>();
        hashMapToken.put("id_user", correo);
        hashMapToken.put("nombre", nombre);
        hashMapToken.put("pass", contraseña);
        hashMapToken.put("telefono", tel);


        JsonObjectRequest solicitud = new JsonObjectRequest(Request.Method.POST, ConfigConexion.RegistroUser, new JSONObject(hashMapToken), new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject datos) {
                try {
                    String estado = datos.getString("resultado");
                    if (estado.equalsIgnoreCase("El usuario se registró correctamente")) {
                        Toast.makeText(RegistroActivity.this, estado, Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(RegistroActivity.this, estado, Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    Toast.makeText(RegistroActivity.this, "No se pudo registrar :(", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(RegistroActivity.this, "No se pudo registrar :(", Toast.LENGTH_SHORT).show();
            }
        });
        VolleyRP.addToQueue(solicitud, mRequest, this, volley);
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
    private String getStringET(EditText e){
        return e.getText().toString();
    }
}
