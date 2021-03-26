package com.hvscode.iperf3test;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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
        Button buttonRun = (Button) findViewById(R.id.btnRun);
        TextView resultView = (TextView) findViewById(R.id.txtResult);
        testRunner = new TestRunner(buttonRun, resultView);
        initialConfigurator = new InitialConfigurator(this, buttonRun);
        this.iperfPath = this.getApplicationContext().getFilesDir().getAbsolutePath();

        File outputDir = this.getCacheDir(); // context being the Activity pointer

        this.outputPath = outputDir.getAbsolutePath();


    }


    public void runTest(View view){
        Log.d(TAG, "onClick");
        testRunner.execute(iperfPath, outputPath);


    }

}