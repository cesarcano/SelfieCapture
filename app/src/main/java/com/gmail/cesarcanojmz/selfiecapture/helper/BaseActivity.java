package com.gmail.cesarcanojmz.selfiecapture.helper;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    ProgressDialog progressDialog;

    public void showProgressDialog() {
        // [1] Iniciar progressdialog
        if (progressDialog == null) {
          progressDialog = new ProgressDialog(this);
          progressDialog.setIndeterminate(true);
          progressDialog.setCancelable(false);
        }
        progressDialog.show();
    }

    public void hideProgressDialog() {
        if (progressDialog.isShowing() && progressDialog != null) {
            progressDialog.dismiss();
        }
    }

}
