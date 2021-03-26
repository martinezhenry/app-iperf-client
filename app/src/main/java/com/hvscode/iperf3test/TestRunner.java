package com.hvscode.iperf3test;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.hvscode.iperf3test.model.IperfResult;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestRunner extends AsyncTask<String, Void, IperfResult> {

    private static final String TAG = TestRunner.class.getName();
    private String pathIperf;
    private String outputPath;


    @Override
    protected IperfResult doInBackground(String... params) {

        this.pathIperf = params[0];
        this.outputPath = params[1];
        String command = pathIperf + "/iperf3 -c 192.168.1.108 -b 1G -t 6 -u -l 63k -J -T IDdelaprueba --logfile " + outputPath;
        ExecuteShell.execute(command);

        IperfResult iperfResult = null;
        String result = null;
        try {
            result = new String(Files.readAllBytes(Paths.get(outputPath)));
            iperfResult = new Gson().fromJson(result, IperfResult.class);

        } catch (IOException e) {
            Log.e(TAG, "EXCEPTION", e);
        }


        return iperfResult;
    }
}
