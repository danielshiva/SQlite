package com.example.j6946657.sqlite;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.media.Image;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class CameraScreen extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;
    ImageView cameraImgView;
    Button cameraBtn;
    Button nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_screen);

        //Camera Reference
        cameraImgView = (ImageView) findViewById(R.id.cameraImgView);
        cameraBtn = (Button) findViewById(R.id.cameraBtn);
        // Next button reference
        nextBtn = (Button) findViewById(R.id.nextBtn);

        // Disable the camera button
        if(!hasCamera())
            cameraBtn.setEnabled(false);

        // Move to Next screen
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CameraScreen.this, SharedPreferenceScreen.class);
                startActivity(i);
            }
        });
    }

    //Checking the camera availability
    private boolean hasCamera(){
        return getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY);
    }

    // Launch camera
    public void cameraOpen(View view){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // take a photo and pass date along with onActivityReenter
        startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
    }

    // Override method for displaying images
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK){
            //get the photo
            Bundle extras = data.getExtras();
            Bitmap photo = (Bitmap) extras.get("data");
            cameraImgView.setImageBitmap(photo);
        }
    }
}
