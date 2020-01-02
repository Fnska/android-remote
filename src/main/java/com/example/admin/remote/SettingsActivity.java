package com.example.admin.remote;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText logText, passText;
    private Button btnLogin;

    private SharedPreferences sPref;

    public static final String LOGIN_TEXT = "login_text";
    public static final String PASSWORD_TEXT = "password_text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        logText = (EditText) findViewById(R.id.loginText);
        passText = (EditText) findViewById(R.id.passwordText);

        btnLogin = (Button) findViewById(R.id.buttonLogin);
        btnLogin.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonLogin:
                saveText();
                Toast.makeText(this, "User saved", Toast.LENGTH_SHORT).show();
                Intent intent3 = new Intent(SettingsActivity.this, MainActivity.class);
                startActivity(intent3);
                break;
        }
    }

    private void saveText() {
        sPref = getSharedPreferences("Params", MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(LOGIN_TEXT, logText.getText().toString());
        ed.putString(PASSWORD_TEXT, passText.getText().toString());
        ed.apply();
    }
}
