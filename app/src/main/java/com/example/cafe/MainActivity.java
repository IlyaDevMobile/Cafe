package com.example.cafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextpassword;
    private Button buttonActivityPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         initViews();
        buttonActivityPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editTextName.getText().toString().trim();
                String pas = editTextpassword.getText().toString().trim();



                if(username.isEmpty()|| pas.isEmpty()){
                    Toast.makeText(
                            MainActivity.this,
                            (R.string.error_empty),
                            Toast.LENGTH_SHORT
                    ).show();

                }
                else
                {
                   Launchnextscreen(username);
                }


            }
        });


    }
    private void Launchnextscreen(String username){
        Intent intent = new Intent(MainActivity.this, MakeOdredActivity.class);
        intent.putExtra("username", username);
        startActivity(intent);

    }


    private void initViews(){
        editTextName = findViewById(R.id.editTextName);
        editTextpassword = findViewById(R.id.editTextpassword);
        buttonActivityPassword = findViewById(R.id.buttonActivityPassword);
    }
}