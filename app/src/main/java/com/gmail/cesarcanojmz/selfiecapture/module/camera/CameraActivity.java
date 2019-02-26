package com.gmail.cesarcanojmz.selfiecapture.module.camera;

import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.FrameLayout;

import com.gmail.cesarcanojmz.selfiecapture.R;
import com.gmail.cesarcanojmz.selfiecapture.helper.BaseActivity;

public class CameraActivity extends BaseActivity {

    private static final String TAG = CameraActivity.class.getSimpleName();

    private Button b_capturar;
    private FrameLayout fr_camera;
    private Camera mCamera;
    private CameraPreview cameraPreview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        initUI();

        mCamera = getCameraInstance();
        if (mCamera != null) {
            cameraPreview = new CameraPreview(this, mCamera);
            fr_camera.addView(cameraPreview);
        }
    }

    private void initUI() {
        b_capturar = findViewById(R.id.b_capturar);
        fr_camera = findViewById(R.id.camera);
    }

    /** Revisa si existen permisos en manifest */
    private boolean checkCameraHardware(Context context) {
        if (context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)){
            // Si existe una cámara en el dispositivo
            return true;
        } else {
            // si no existe una cámara
            return false;
        }
    }

    public static Camera getCameraInstance(){
        Camera c = null;
        try {
            c = Camera.open(Camera.CameraInfo.CAMERA_FACING_FRONT);
            /*
            Camera.Parameters parameters;
            parameters = c.getParameters();
            parameters.setPreviewSize(200, 300);
            c.setParameters(parameters);
            */
        } catch (Exception e) {
            Log.e(TAG, "failed to open Camera\n" + e.getMessage());
            e.printStackTrace();
        }
        return c;
    }
}
