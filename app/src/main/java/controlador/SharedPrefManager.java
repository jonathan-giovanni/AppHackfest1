package controlador;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import org.dev4u.hv.apphackfest1.RegistroActivity;

import modelo.Usuario;

/**
 * Created by admin on 18/11/17.
 */

public class SharedPrefManager {
    private static final String SHARED_NAME = "simplifiedcodingsharedpref";
    private static final String KEY_PASS = "keypass";
    private static final String KEY_TEL = "keytelefono";
    private static final String KEY_USERNAME = "keyusername";
    private static final String KEY_ID = "keyemail";


    private static SharedPrefManager mInstance;
    private static Context mCtx;

    private SharedPrefManager(Context context){
        mCtx = context;
    }
    public static synchronized SharedPrefManager getInstance(Context context){
        if(mInstance == null){
            mInstance = new SharedPrefManager(context);
        }
        return mInstance;
    }

    public void userLogin(Usuario usuario){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_ID,usuario.getId());
        editor.putString(KEY_USERNAME,usuario.getNombre());
        editor.putString(KEY_TEL,usuario.getTelefono());
        editor.putString(KEY_PASS,usuario.getPass());

        editor.apply();

    }

    public boolean isLoggedIn(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USERNAME,null) != null;
    }

    public Usuario getUsuario(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_NAME, Context.MODE_PRIVATE );
        return new Usuario(
                sharedPreferences.getString(KEY_ID, null),
                sharedPreferences.getString(KEY_USERNAME, null),
                sharedPreferences.getString(KEY_PASS, null),
                sharedPreferences.getString(KEY_TEL, null)
        );
    }

    public void logout(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        mCtx.startActivity(new Intent(mCtx, RegistroActivity.class));

    }


}
