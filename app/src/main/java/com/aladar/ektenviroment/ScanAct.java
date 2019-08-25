package com.aladar.ektenviroment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class ScanAct extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    ZXingScannerView scannerView;
    String Urlfinal;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        scannerView = new ZXingScannerView(this);
        setContentView(scannerView);


    }

    @Override
    public void handleResult(Result result) {
        Urlfinal =result.getText();
        ScanFragment.urlTV.setText(result.getText());
        onBackPressed();
        scannerView.stopCamera();
    }

    @Override
    protected void onResume(){
        super.onResume();

        scannerView.setResultHandler(this);
        scannerView.startCamera();

    }


    @Override
    protected void onPause(){
        super.onPause();
        scannerView.stopCamera();
    }
}
