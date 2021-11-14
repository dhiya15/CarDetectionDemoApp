package org.tensorflow.lite.examples.detection;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String PERMISSION_CAMERA = Manifest.permission.CAMERA;
    private static final String PERMISSION_STORAGE2 = Manifest.permission.READ_EXTERNAL_STORAGE;
    private static final String PERMISSION_STORAGE3 = Manifest.permission.WRITE_EXTERNAL_STORAGE;
    private static final String PERMISSION_PHONE = Manifest.permission.READ_PHONE_STATE;

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            requestPermissions(new String[] {
                    PERMISSION_CAMERA,
                    PERMISSION_STORAGE2,
                    PERMISSION_STORAGE3,
                    PERMISSION_PHONE
            }, 2);

            Log.d("Camera", checkSelfPermission(PERMISSION_CAMERA)+"");
            Log.d("Storage2", checkSelfPermission(PERMISSION_STORAGE2)+"");
            Log.d("Storage3", checkSelfPermission(PERMISSION_STORAGE3)+"");
            Log.d("Phone", checkSelfPermission(PERMISSION_PHONE)+"");

            if((checkSelfPermission(PERMISSION_CAMERA) == PackageManager.PERMISSION_GRANTED)
            && (checkSelfPermission(PERMISSION_STORAGE2) == PackageManager.PERMISSION_GRANTED)
            && (checkSelfPermission(PERMISSION_STORAGE3) == PackageManager.PERMISSION_GRANTED)
            && (checkSelfPermission(PERMISSION_PHONE) == PackageManager.PERMISSION_GRANTED)){

                Intent intent = new Intent(this, DetectorActivity.class);
                startActivity(intent);

            }else{
                textView.setText("Allow all permissions and restart the app !");
                Toast.makeText(this, "Permissions are required !", Toast.LENGTH_LONG).show();
                requestPermissions(new String[] {
                        PERMISSION_CAMERA,
                        PERMISSION_STORAGE2,
                        PERMISSION_STORAGE3,
                        PERMISSION_PHONE
                }, 2);
            }

        }


    }

}