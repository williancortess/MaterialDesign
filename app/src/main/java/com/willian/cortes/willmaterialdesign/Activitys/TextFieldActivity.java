package com.willian.cortes.willmaterialdesign;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class TextFieldActivity extends AppCompatActivity {
    private ActionBar actionBar = null;
    private Toolbar toolbar;

    private AppCompatEditText edEmail;
    private AppCompatEditText edSenha;

    private TextInputLayout txEmail;
    private TextInputLayout txSenha;

    private Button btLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_field_view);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle(getResources().getString(R.string.text_field));

        edEmail =  findViewById(R.id.ed_email);
        edSenha  = findViewById(R.id.ed_senha);
        txEmail  = findViewById(R.id.txtEmail);
        txSenha = findViewById(R.id.txtSenha);

        btLogin = findViewById(R.id.btLogin);
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validaLogin();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void validaLogin(){
        if(edEmail.getText().toString().isEmpty()){
            txEmail.setErrorEnabled(true);
            txEmail.setError("Prerencha seu email");
        } else {
            txEmail.setErrorEnabled(false);
        }

        if(edSenha.getText().toString().isEmpty()){
            txSenha.setErrorEnabled(true);
            txSenha.setError("Prerencha sua senha");
        } else {
            txSenha.setErrorEnabled(false);
        }

    }
}
