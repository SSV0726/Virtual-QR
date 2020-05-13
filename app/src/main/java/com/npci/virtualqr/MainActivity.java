package com.npci.virtualqr;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.le.AdvertiseCallback;
import android.bluetooth.le.AdvertiseSettings;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.altbeacon.beacon.BeaconManager;
import org.altbeacon.beacon.BeaconParser;
import org.altbeacon.beacon.BeaconTransmitter;

import java.util.Arrays;
import java.util.Collection;

import org.altbeacon.beacon.Beacon;
import org.altbeacon.beacon.Region;
import org.altbeacon.beacon.utils.UrlBeaconUrlCompressor;

import pl.droidsonroids.gif.GifImageView;

public class MainActivity extends AppCompatActivity {

    Beacon myiBeacon;
    String uuid;
    BluetoothAdapter bluetoothAdapter;
    BeaconTransmitter beaconTransmitter;
    int count=1;
    public void startBroadcasting(View view){

        Beacon beacon = new Beacon.Builder()
                .setId1(uuid)
                .setId2("20")
                .setId3("1500")
                .setManufacturer(0x004c)
                .setTxPower(-59)
                .build();
        BeaconParser beaconParser = new BeaconParser()
                .setBeaconLayout("m:2-3=0215,i:4-19,i:20-21,i:22-23,p:24-24");
        beaconTransmitter = new BeaconTransmitter(getApplicationContext(), beaconParser);

        if(count==1) {
            count = 0;

            Button button = findViewById(R.id.startBroadcasting);
            button.setText("Stop Broadcasting");

            ImageView redbutton = findViewById(R.id.redButton);
            redbutton.setVisibility(View.INVISIBLE);

            GifImageView gif = findViewById(R.id.broadcastingGif);
            gif.setVisibility(View.VISIBLE);

            beaconTransmitter.startAdvertising(beacon);
            Log.i("info", "boradcast started ");
        }else{

            count=1;
            stopBroadcasting();

        }
    }

    public void stopBroadcasting(){
        // stop broadcasting code
        Button button = findViewById(R.id.startBroadcasting);
        button.setText("Start Broadcasting");

        ImageView redbutton = findViewById(R.id.redButton);
        redbutton.setVisibility(View.VISIBLE);

        GifImageView gif = findViewById(R.id.broadcastingGif);
        gif.setVisibility(View.INVISIBLE);

        beaconTransmitter.stopAdvertising();
        Log.i("info", "boradcast stopped ");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        stopBroadcasting();
        finish();
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("info","MainActivity Reached ");

        ImageView redbutton = findViewById(R.id.redButton);
        redbutton.setVisibility(View.VISIBLE);

        GifImageView gif = findViewById(R.id.broadcastingGif);
        gif.setVisibility(View.INVISIBLE);

        Intent intent = getIntent();
        uuid = intent.getStringExtra("uuid");
        String name = intent.getStringExtra("name");

        TextView merchantName = findViewById(R.id.merchantName);
        merchantName.setText(name);

        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if(!bluetoothAdapter.enable()){
            bluetoothAdapter.enable();
        }


    }




}
