package com.example.a622j;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignInActivity extends AppCompatActivity {

     SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign);

        EditText email1 = findViewById(R.id.email);
        EditText name = findViewById(R.id.name);
        EditText pas = findViewById(R.id.pas);
        EditText cpas = findViewById(R.id.cpass);
        Button save = findViewById(R.id.register);
        TextView cancel = findViewById(R.id.cancel);

        sharedPreferences = getSharedPreferences("userInfo", 0);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String emailValue = email1.getText().toString();
                String passwordValue = pas.getText().toString();
                String nameValue = name.getText().toString();
                String cpasValue = cpas.getText().toString();

                if (emailValue.length() > 1 && passwordValue.length() > 1 && nameValue.length() > 1 && cpasValue.length() > 1){
                    if (passwordValue.equals(cpasValue)) {
                        SharedPreferences.Editor editor = sharedPreferences.edit();

                        editor.putString("emailValue", emailValue);
                        editor.putString("passwordValue", passwordValue);
                        editor.putString("nameValue", nameValue);
                        editor.putString("cpasValue", cpasValue);
                        editor.apply();

                        Toast.makeText(SignInActivity.this, "Successfully Registered", Toast.LENGTH_SHORT).show();
                        finish();
                    }else{
                        Toast.makeText(SignInActivity.this, "Invalid confirm password", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(SignInActivity.this, "Form the application fully, please", Toast.LENGTH_SHORT).show();
                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignInActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
