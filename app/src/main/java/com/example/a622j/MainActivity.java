package com.example.a622j;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    void initViews() {
        EditText email1 = findViewById(R.id.email);
        EditText pas = findViewById(R.id.pas);
        Button save = findViewById(R.id.LogIn);
        TextView textView = findViewById(R.id.signIn);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailValue = email1.getText().toString();
                String passwordValue = pas.getText().toString();

                String registeredEmail = sharedPreferences.getString("emailValue", "");
                String registeredPassword = sharedPreferences.getString("pasValue", "");

                if (emailValue.equals(registeredEmail) && passwordValue.equals(registeredPassword)){
                    Intent intent = new Intent(MainActivity.this, LastActivity.class );
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }

            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SignInActivity.class);
                startActivity(intent);
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LastActivity.class);
                startActivity(intent);
            }
        });
    }

}