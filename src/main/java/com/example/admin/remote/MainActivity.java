package com.example.admin.remote;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText codeText;
    private Button btnRemote, btnSettings;

    private SharedPreferences sPref;

    public static final String CODE_TEXT = "code_text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        codeText = (EditText) findViewById(R.id.codeText);

        btnRemote = (Button) findViewById(R.id.buttonRemote);
        btnSettings = (Button) findViewById(R.id.buttonSettings);

        btnRemote.setOnClickListener(this);
        btnSettings.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonRemote:
                if (!codeText.getText().toString().equals("")) {
                    sPref = getSharedPreferences("Params", MODE_PRIVATE);
                    SharedPreferences.Editor ed = sPref.edit();
                    ed.putString(CODE_TEXT, codeText.getText().toString());
                    ed.apply();
                    Intent intent = new Intent("com.example.admin.WebActivity");
                    startActivity(intent);
                    break;
                } else {
                    Intent intent1 = new Intent("com.example.admin.WebActivity");
                    startActivity(intent1);
                    break;
                }
            case R.id.buttonSettings:
                Intent intent2 = new Intent("com.example.admin.SettingsActivity");
                startActivity(intent2);
                break;
        }

    }
}