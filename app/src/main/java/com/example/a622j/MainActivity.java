package com.example.a622j;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    void initViews() {
        EditText email1 = findViewById(R.id.email);
        EditText name = findViewById(R.id.name);
        EditText pas = findViewById(R.id.pas);
        EditText cpas = findViewById(R.id.cpass);
        Button save = findViewById(R.id.save);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = email1.getText().toString();
                PrefsManager.getInstance(MainActivity.this).saveData("key", email);
                String data = PrefsManager.getInstance(MainActivity.this).getData("key");
                saveEmail(data);

                String name1 = name.getText().toString();
                PrefsManager.getInstance(MainActivity.this).saveData("key", name1);
                String data1 = PrefsManager.getInstance(MainActivity.this).getData("key");
                saveEmail(data1);

                String pas1 = pas.getText().toString();
                PrefsManager.getInstance(MainActivity.this).saveData("key", pas1);
                String data2 = PrefsManager.getInstance(MainActivity.this).getData("key");
                saveEmail(data2);

                String cpas1 = cpas.getText().toString();
                PrefsManager.getInstance(MainActivity.this).saveData("key", cpas1);
                String data3 = PrefsManager.getInstance(MainActivity.this).getData("key");
                saveEmail(data3);

            }
        });
    }

    void saveEmail(String email) {
        SharedPreferences prefs = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("email", email);
        editor.apply();
    }
}