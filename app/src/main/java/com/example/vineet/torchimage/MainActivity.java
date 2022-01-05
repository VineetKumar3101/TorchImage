package com.example.vineet.torchimage;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
ImageButton ib;
    CameraManager cm;
    private boolean torch=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ib=(ImageButton)findViewById(R.id.imageButton);
        cm=(CameraManager)getSystemService(CAMERA_SERVICE);
        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String id=cm.getCameraIdList()[0];
                    cm.setTorchMode(id,true);
                    torch=true;
                    ib.setImageResource(R.drawable.on);
                }
                catch (CameraAccessException e)
                {

                }
            }
        });

    }
}
