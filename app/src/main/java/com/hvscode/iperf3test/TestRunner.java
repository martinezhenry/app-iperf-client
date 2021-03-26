package com.hvscode.iperf3test;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.hvscode.iperf3test.model.IperfResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestRunner extends AsyncTask<String, Void, IperfResult> {

    private static final String TAG = TestRunner.class.getName();
    private String pathIperf;
    private String outputDir;
    private Button buttonRun;
    private TextView resultView;

    public TestRunner(Button buttonRun, TextView resultView){
        this.buttonRun = buttonRun;
        this.resultView = resultView;

    }

    @Override
    protected void onPreExecute() {
        this.buttonRun.setEnabled(false);
    }

    @Override
    protected IperfResult doInBackground(String... params) {

        this.pathIperf = params[0];
        this.outputDir = params[1];

        IperfResult iperfResult = null;
        String result = null;
        try {
            File output = new File(outputDir);
            File outputFile = File.createTempFile("iperfResult", null, output);
            String outputPath = outputFile.getAbsolutePath();
            String command = pathIperf + "/iperf3 -c 192.168.1.108 -b 1G -t 6 -u -l 63k -J -T IDdelaprueba --logfile " + outputPath;
            ExecuteShell.execute(command);

            result = new String(Files.readAllBytes(Paths.get(outputPath)));
            iperfResult = new Gson().fromJson(result, IperfResult.class);

        } catch (IOException e) {
            Log.e(TAG, "EXCEPTION", e);
        }


        return iperfResult;
    }


    @Override
    protected void onPostExecute(IperfResult result) {

        this.buttonRun.setEnabled(true);


        this.resultView.setText(result.toString());

    }
}
