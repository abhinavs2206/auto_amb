package com.example.final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class shaker extends AppCompatActivity implements SensorEventListener {
    private SensorManager sensorManager; // accessing sensor service
    private long lastUpdate, actualTime;
    private static final String TAG = "MainActivity";
    public int shake;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shaker);


        lastUpdate = System.currentTimeMillis();
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        Sensor mySensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        if(mySensor == null)
        {
            Toast.makeText(this, "no accelerometer detected in this device", Toast.LENGTH_SHORT).show();
            finish();
        }
        else{
            sensorManager.registerListener(this, mySensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER)
        {
            float[] values = event.values;
            float x = values[0];
            float y = values[1];
            float z = values[2];

            float EG = SensorManager.GRAVITY_EARTH;
            float dvAccel = (x*x + y*y + z*z)/(EG+EG);
            Log.e(TAG, String.valueOf(x));
            Log.e(TAG, String.valueOf(y));
            Log.e(TAG, String.valueOf(z));

            if(dvAccel>50.5)
            {
                actualTime = System.currentTimeMillis();
                if((actualTime-lastUpdate)>500)
                {
                    lastUpdate = actualTime;
                    shake++;
                    Intent intent = new Intent(getApplicationContext(), user_1.class);
                    startActivity(intent);
                    Log.d(TAG, "shake");
                }
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    protected void onStop() {
        super.onStop();
        sensorManager.unregisterListener(this);
    }
}
