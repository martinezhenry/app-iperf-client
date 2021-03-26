package com.hvscode.iperf3test;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();

    private InitialConfigurator initialConfigurator;
    private TestRunner testRunner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        initialConfigurator.execute(this);

        try {

            String pathIperf = this.getApplicationContext().getFilesDir().getAbsolutePath();

            File outputDir = this.getCacheDir(); // context being the Activity pointer
            File outputFile = File.createTempFile("iperfResult", null, outputDir);
            String outputPath = outputFile.getAbsolutePath();

            testRunner.execute(pathIperf, outputPath);


        } catch (Exception e) {
            Log.e(TAG, "EXCEPTION", e);
        }
    }


    public void init() {
        testRunner = new TestRunner();
        initialConfigurator = new InitialConfigurator();

    }
}