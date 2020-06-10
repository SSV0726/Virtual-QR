package com.npci.virtualqr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class splashscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        ImageView rings = findViewById(R.id.broadcastingGif);
        Glide.with(this).asGif().load(R.drawable.final_logo).into(rings);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent login = new Intent(getApplicationContext(),login.class);
                startActivity(login);
                finish();

            }
        },2000);
    }
}
