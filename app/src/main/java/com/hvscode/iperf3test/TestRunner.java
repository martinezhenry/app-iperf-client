package com.hvscode.iperf3test;

import android.content.res.Resources;
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
import java.util.List;
import java.util.Optional;

public class TestRunner extends AsyncTask<String, Void, IperfResult> {

    private static final String TAG = TestRunner.class.getName();
    private String pathIperf;
    private String outputPath;
    private Button buttonRun;
    private TextView resultView;

    public TestRunner(Button buttonRun, TextView resultView){
        this.buttonRun = buttonRun;
        this.resultView = resultView;

    }

    @Override
    protected void onPreExecute() {
        this.buttonRun.setEnabled(false);
        this.resultView.setText("Running Test");
    }

    @Override
    protected IperfResult doInBackground(String... params) {

        IperfResult iperfResult = null;
        StringBuilder result = new StringBuilder();
        try {

            String command = buildCommand(params);
            ExecuteShell.execute(command);

            //result = new String(Files.readAllBytes(Paths.get(outputPath)));
            List<String> lines = Files.readAllLines(Paths.get(outputPath));

            lines.stream().filter(line -> !line.startsWith("iperf3: error")).forEach(line -> {
                result.append(line);
            });

            Log.d(TAG, result.toString());

            iperfResult = new Gson().fromJson(result.toString(), IperfResult.class);
            Files.deleteIfExists(Paths.get(outputPath));

        } catch (IOException e) {
            Log.e(TAG, "EXCEPTION", e);
        }


        return iperfResult;
    }


    public String buildCommand(String ... params) throws IOException {

        String pathIperf = params[0];
        String outputDir = params[1];

        String host = params[2];
        String buffer = params[3];
        String time = params[4];
        String bitRate = params[5];
        String title = params[6];
        String udpCheck = params[7];
        String udp = "";
        if (Boolean.parseBoolean(udpCheck)){
            udp = " -u ";
        }

        String binaryName = "iperf3";

        File output = new File(outputDir);
        File outputFile = File.createTempFile("iperfResult", null, output);
        this.outputPath = outputFile.getAbsolutePath();
        StringBuilder command = new StringBuilder(pathIperf.concat(File.separator).concat(binaryName));
        // add host
        command.append(" -c "+host);

        // add buffer
        if (!buffer.isEmpty()) {
            command.append(" -b " + buffer);
        }

        // add time
        if (!time.isEmpty()) {
            command.append(" -t " + time);
        }

        // add buffer
        if (!udp.isEmpty()) {
            command.append(udp);
        }

        // add buffer
        if (!bitRate.isEmpty()) {
            command.append(" -l " + bitRate);
        }

        // add title
        if (!title.isEmpty()) {
            command.append(" -T " + title);
        }

        // add output json type
        command.append(" -J ");
        // add output path
        command.append(" --logfile " + outputPath);



       // String command = pathIperf + File.separator + binaryName +" -c "+host+" -b "+buffer+" -t "+time+" -u -l "+bitRate+" -J -T "+title+" --logfile " + outputPath;

        return command.toString();


    }


    @Override
    protected void onPostExecute(IperfResult result) {

        this.buttonRun.setEnabled(true);
        Optional.ofNullable(result).ifPresent(res -> {

            this.resultView.setText(result.toString());

        });

    }
}
