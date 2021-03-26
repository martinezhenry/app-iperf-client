package com.hvscode.iperf3test;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();

    private InitialConfigurator initialConfigurator;
    private TestRunner testRunner;
    private String iperfPath;
    private String outputPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            init();
            initialConfigurator.execute(this);

        } catch (Exception e) {
            Log.e(TAG, "EXCEPTION", e);
        }
    }


    public void init() throws IOException {
        validation();
        Button buttonRun = findViewById(R.id.btnRun);
        TextView resultView = findViewById(R.id.txtResult);
        testRunner = new TestRunner(buttonRun, resultView);
        initialConfigurator = new InitialConfigurator(this, buttonRun);
        this.iperfPath = this.getApplicationContext().getFilesDir().getAbsolutePath();

        File outputDir = this.getCacheDir(); // context being the Activity pointer

        this.outputPath = outputDir.getAbsolutePath();


    }


    public void validation(){

        EditText txtHost = findViewById(R.id.txtHost);

        txtHost.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) {
                if (txtHost.getText().length() == 0) {
                    txtHost.setError( "Host is required!" );
                }
            }
        });


    }


    public void runTest(View view) throws IOException {
        Log.d(TAG, "onClick");
        hideKeyBoard(view);
        TextView resultView = findViewById(R.id.txtResult);
        EditText hostText =  findViewById(R.id.txtHost);
        EditText bufferText =  findViewById(R.id.txtBuffer);
        EditText bitRateText =  findViewById(R.id.txtBitRate);
        EditText titleText =  findViewById(R.id.txtTitle);
        EditText timeText =  findViewById(R.id.txtTime);
        CheckBox udpCheckbox = findViewById(R.id.checkUDP);

        String host = hostText.getText().toString();
        String buffer = bufferText.getText().toString();
        String bitRate = bitRateText.getText().toString();
        String title = titleText.getText().toString();
        String time = timeText.getText().toString();
        String udp = Boolean.toString(udpCheckbox.isChecked());

        testRunner = new TestRunner((Button) view, resultView);
        testRunner.execute(iperfPath, outputPath, host, buffer, time, bitRate, title, udp);

    }

    private void hideKeyBoard(View v) {
        InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(v.getApplicationWindowToken(),0);
    }

}