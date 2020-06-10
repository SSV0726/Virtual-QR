package com.npci.virtualqr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {

    public  void openSignUpActivity(View view){
        Intent geoFence = new Intent(getApplicationContext(),geoFence.class);
        startActivity(geoFence);

    }

    public void authenticityCheck(View view){

        EditText usernameEditText = findViewById(R.id.username);
        EditText passwordEditText = findViewById(R.id.password);

        String username = usernameEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        Log.i("info","username :-" + username + "    password " + password);

        String[] userArray = { "Sudama","panipuri","cafeteria","icecream","chatpakori"};
        String[] uuid = { "c1f3d67d-d6ad-4d5e-82df-000000000001","c1f3d67d-d6ad-4d5e-82df-000000000002","c1f3d67d-d6ad-4d5e-82df-000000000003","c1f3d67d-d6ad-4d5e-82df-000000000004","c1f3d67d-d6ad-4d5e-82df-000000000005"};

        int mathced=-1;
        for(int i=0;i<5;i++){
            if(username.toLowerCase().equals(userArray[i].toLowerCase()) && password.equals("1234") ){
                mathced = i;
            }
        }

        if(mathced!=-1){
            Toast.makeText(this,"Successfully Logged-In",Toast.LENGTH_SHORT).show();
            Intent main = new Intent(getApplicationContext(),MainActivity.class);
            main.putExtra("uuid",uuid[mathced].toString());
            main.putExtra("name",userArray[mathced].toString());
            Log.i("info","successfully putted data into the intent for next activity ");
            startActivity(main);
            finish();


        }else{
            Toast.makeText(this,"Wrong Details ",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



    }
}
