package com.hvscode.iperf3test;

import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ExecuteShell {

    private static final String TAG = ExecuteShell.class.getName();

    public static String execute(String command) {

        StringBuffer output = new StringBuffer();

        Process p;
        try {
            Log.d(TAG, "Executing command: " + command);
            p = Runtime.getRuntime().exec(command);
            p.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

            String line = "";
            while ((line = reader.readLine()) != null) {
                output.append(line + "\n");
            }

            reader.close();

        } catch (Exception e) {
            Log.e(TAG, "EXCEPTION", e);
        }
        String response = output.toString();
        return response;

    }


}
