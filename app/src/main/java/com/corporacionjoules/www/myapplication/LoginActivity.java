package com.corporacionjoules.www.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;

import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        FacebookSdk.getApplicationContext();
        FacebookSdk.setApplicationId(getResources().getString(R.string.facebook_app_id));

        CallbackManager callbackManager = CallbackManager.Factory.create();
        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

                GraphRequest request = GraphRequest.newMeRequest(
                        loginResult.getAccessToken(),
                        new GraphRequest.GraphJSONObjectCallback() {
                            @Override
                            public void onCompleted(JSONObject jsonObject, GraphResponse response) {
                                // Getting FB User Data
                                Bundle facebookData = getFacebookData(jsonObject);
                                String id =facebookData.getString("idFacebook");
                                String nombre = facebookData.getString("first_name");
                                String email= facebookData.getString("email");

                                runOnUiThread(new Runnable() {
                                    public void run() {

                                    }
                                });
                            }
                        });

                Bundle parameters = new Bundle();
                parameters.putString("fields", "id,first_name,last_name,email,gender");
                request.setParameters(parameters);
                request.executeAsync();
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });


    }

    private Bundle getFacebookData(JSONObject object) {
        Bundle bundle = new Bundle();

        try {
            String id = object.getString("id");
            URL profile_pic;
            try {
                profile_pic = new URL("https://graph.facebook.com/" + id + "/picture?type=large");
                Log.i("profile_pic", profile_pic + "");
                bundle.putString("profile_pic", profile_pic.toString());
            } catch (MalformedURLException e) {
                e.printStackTrace();
                return null;
            }

            bundle.putString("idFacebook", id);
            if (object.has("first_name"))
                bundle.putString("first_name", object.getString("first_name"));
            if (object.has("last_name"))
                bundle.putString("last_name", object.getString("last_name"));
            if (object.has("email"))
                bundle.putString("email", object.getString("email"));
            if (object.has("gender"))
                bundle.putString("gender", object.getString("gender"));


          /*  prefUtil.saveFacebookUserInfo(object.getString("first_name"),
                    object.getString("last_name"),object.getString("email"),
                    object.getString("gender"), profile_pic.toString());*/

        } catch (Exception e) {
            //Log.d(TAG, "BUNDLE Exception : "+e.toString());
        }

        return bundle;
    }


    public void cargarMenuPrincipal(){
        Intent i = new Intent(LoginActivity.this, MainActivity.class);
        finish();  //Kill the activity from which you will go to next activity
        startActivity(i);
    }
    //Muestra el dialogo para que el usuario se registre
    public void registerDialog(View view){

        LayoutInflater inflater =  LayoutInflater.from(this);
        View inflateView = inflater.inflate(R.layout.register_user, null);

        final EditText nombre         = (EditText) inflateView.findViewById(R.id.et_nombre_registro);
        final EditText email          = (EditText) inflateView.findViewById(R.id.et_email_registro);
        final EditText pass           = (EditText) inflateView.findViewById(R.id.et_pass_registro);
        final EditText repetirpass    = (EditText) inflateView.findViewById(R.id.et_repetirpass_registro);

        final TextInputLayout til_nombre      = (TextInputLayout) inflateView.findViewById(R.id.til_nombre_registro);
        final TextInputLayout til_email       = (TextInputLayout) inflateView.findViewById(R.id.til_email_registro);
        final TextInputLayout til_pass        = (TextInputLayout) inflateView.findViewById(R.id.til_pass_registro);
        final TextInputLayout til_repetirpass = (TextInputLayout) inflateView.findViewById(R.id.til_repetirpass_registro);

        til_nombre      .setErrorEnabled(true);
        til_email       .setErrorEnabled(true);
        til_pass        .setErrorEnabled(true);
        til_repetirpass .setErrorEnabled(true);
        til_pass        .setPasswordVisibilityToggleEnabled(true);
        til_repetirpass .setPasswordVisibilityToggleEnabled(true);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder .setView(inflateView)
                .setPositiveButton(R.string.entrar, null)
                .setNegativeButton(R.string.cancelar,null);

        AlertDialog alertDialog = builder.create();
        alertDialog.setCancelable(false);
        alertDialog.setIcon(R.drawable.ic_launcher_icon);
        alertDialog.setOnShowListener(new DialogInterface.OnShowListener() {
                                          @Override
                                          public void onShow(DialogInterface dialog) {
                                              Button button = ((AlertDialog) dialog).getButton(AlertDialog.BUTTON_POSITIVE);
                                              button.setOnClickListener(new View.OnClickListener() {
                                                  @Override
                                                  public void onClick(View v) {
                                                      String nombreUsuario        = nombre.getText().toString();
                                                      String emailUsuario         = email.getText().toString();
                                                      String passwordUsuario      = pass.getText().toString();
                                                      String repPasswordUsuario   = repetirpass.getText().toString();

                                                      til_nombre.setError("");
                                                      til_email.setError("");
                                                      til_pass.setError("");
                                                      til_repetirpass.setError("");

                                                      if(nombreUsuario.isEmpty()){
                                                          til_nombre.setError(getString(R.string.campo_requerido));
                                                      }
                                                      else if(emailUsuario.isEmpty()){
                                                          til_email.setError(getString(R.string.campo_requerido));
                                                      }
                                                      else if(passwordUsuario.isEmpty()){
                                                          til_pass.setError(getString(R.string.campo_requerido));
                                                      }
                                                      else if(repPasswordUsuario.isEmpty()){
                                                          til_repetirpass.setError(getString(R.string.campo_requerido));
                                                      }
                                                      else if (!(passwordUsuario.equals(repPasswordUsuario))){
                                                          til_repetirpass.setError(getString(R.string.diferente_pass));
                                                      }
                                                      else {
                                                          //TODO:Registrar al usuario

                                                          //Llamar a la actividad que contiene el menu
                                                          cargarMenuPrincipal();
                                                      }
                                                  }
                                              });
                                          }
                                      });

        alertDialog.show();
    }

    //Muestra el dialogo para que el usuario inicie sesion
    public void loginDialog(View view){
        LayoutInflater inflater =  LayoutInflater.from(this);
        View inflateView = inflater.inflate(R.layout.login_user, null);

        final EditText email          = (EditText) inflateView.findViewById(R.id.email);
        final EditText pass           = (EditText) inflateView.findViewById(R.id.password);

        final TextInputLayout til_email       = (TextInputLayout) inflateView.findViewById(R.id.til_login_email);
        final TextInputLayout til_pass        = (TextInputLayout) inflateView.findViewById(R.id.til_login_pass);

        til_email       .setErrorEnabled(true);
        til_pass        .setErrorEnabled(true);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder .setView(inflateView)
                .setPositiveButton(R.string.entrar, null)
                .setNegativeButton(R.string.cancelar,null);

        AlertDialog alertDialog = builder.create();
        alertDialog.setCancelable(false);
        alertDialog.setIcon(R.drawable.ic_launcher_icon);
        alertDialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {
                Button button = ((AlertDialog) dialog).getButton(AlertDialog.BUTTON_POSITIVE);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String emailUsuario         = email.getText().toString();
                        String passwordUsuario      = pass.getText().toString();

                        til_email   .setError("");
                        til_pass    .setError("");

                        if(emailUsuario.isEmpty()){
                            til_email.setError(getString(R.string.campo_requerido));
                        }
                        if(passwordUsuario.isEmpty()){
                            til_pass.setError(getString(R.string.campo_requerido));
                        }
                        else {
                            //TODO:Registrar al usuario

                            //Llamar a la actividad que contiene el menu
                            cargarMenuPrincipal();
                        }

                    }
                });
            }
        });
        alertDialog.show();
    }
}
