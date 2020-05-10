package com.npci.virtualqr;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.le.AdvertiseCallback;
import android.bluetooth.le.AdvertiseSettings;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
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

public class MainActivity extends AppCompatActivity {

    Beacon myiBeacon;

    BluetoothAdapter bluetoothAdapter;

    public void broadcast(View view){

        // // Github link for this project https://github.com/adriancretu/beacons-android
      //  new EddystoneURL("https://github.com").start();
//        Log.i("info","Button clicked ");
//
//        EditText mobileno = findViewById(R.id.mobileno);
//        String mobile = mobileno.getText().toString();
//
//        String uid = "f7826da6-4fa2-4e98-8024-bc5b71e0893e";
        //String addtouid = "9";
//        if(mobile.equals("8459953212")){
//
//            Log.i("info","mobile no. matched");
//            Toast.makeText(this,"matched to 212",Toast.LENGTH_SHORT).show();
//            addtouid = "1";
//
//        }else{
//            Toast.makeText(this,"NO match Found",Toast.LENGTH_SHORT).show();
//
//        }


        // uuid is generated from converting uid to byte[] ;
       // uid += addtouid;
//        byte[] uuid = uid.getBytes();
//
//        Log.i("info","uid is " + uid);
//        Log.i("info", "uuid is "+ uuid.toString());
//
//        int major = 30;
//        int minor = 50;
//
//        new iBeacon(uuid, major, minor).start();
//
//
//        Log.i("info", Beacons.getActive().toString());

    }

    public void create_ibeacon(View view){

        Beacon beacon = new Beacon.Builder()
                .setId1("22222254-cf6d-4a0f-adf2-f4911ba9ffa6")
                .setId2("1")
                .setId3("2")
                .setManufacturer(0x004c)
                .setTxPower(-59)
                .build();
        BeaconParser beaconParser = new BeaconParser()
                .setBeaconLayout("m:2-3=0215,i:4-19,i:20-21,i:22-23,p:24-24");

        BeaconTransmitter beaconTransmitter = new BeaconTransmitter(getApplicationContext(), beaconParser);
        beaconTransmitter.startAdvertising(beacon);

        TextView uuids = findViewById(R.id.uuids);
        uuids.append("22222254-cf6d-4a0f-adf2-f4911ba9ffa6");


    }


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        if(!bluetoothAdapter.enable()){
            bluetoothAdapter.enable();
        }


    }




}
