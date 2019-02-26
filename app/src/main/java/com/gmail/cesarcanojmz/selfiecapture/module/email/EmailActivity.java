package com.gmail.cesarcanojmz.selfiecapture.module.email;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.gmail.cesarcanojmz.selfiecapture.R;
import com.gmail.cesarcanojmz.selfiecapture.module.camera.CameraActivity;
import com.gmail.cesarcanojmz.selfiecapture.helper.BaseActivity;

public class EmailActivity extends BaseActivity implements Contract.View {
    private TextView tv_email;
    private Contract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
        presenter = new Presenter();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.attachView(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.detachView();
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void loading() {
        showProgressDialog();
    }

    @Override
    public void loaded() {
        hideProgressDialog();
    }

    private void initUI() {
        tv_email = findViewById(R.id.tv_aceptar);
    }

    @Override
    public void message(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public void aceptar(View view) {
        presenter.validarEmail(tv_email.getText().toString());
    }

    @Override
    public void validationSuccess() {
        Intent intent = new Intent(this.getContext(), CameraActivity.class);
        startActivity(intent);
        this.finish();
    }

    @Override
    public void validationError() {
        // Borra contenido de email
        tv_email.setText("");
    }
}
