package com.corporacionjoules.www.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
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
