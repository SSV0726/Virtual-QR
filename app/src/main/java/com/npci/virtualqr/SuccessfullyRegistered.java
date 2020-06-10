package com.npci.virtualqr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SuccessfullyRegistered extends AppCompatActivity {

    public void onClickLogin(View view){
        startActivity(new Intent(this,login.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_successfully_registered);
    }
}