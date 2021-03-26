package com.hvscode.iperf3test;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.AsyncTask;
import android.system.ErrnoException;
import android.system.Os;
import android.util.Log;
import android.widget.Button;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

public class InitialConfigurator extends AsyncTask<Context, Integer, Boolean> {

    private static final String TAG = InitialConfigurator.class.getName();

    private String iperfPath;
    private String iperfBinaryName;
    private Context context;
    private Button buttonRun;
    private AssetManager manager;
    private String iperfAbsolutePath;

    public InitialConfigurator(Context context, Button buttonRun){
        this.context = context;
        this.buttonRun = buttonRun;

    }

    public boolean existsIperfBinary() {
        Log.d(TAG, "Checking binary in path: " + this.iperfAbsolutePath);
        return Files.exists(Paths.get(this.iperfAbsolutePath));

    }


    public void makeIperfBinary() throws IOException {

        if (!existsIperfBinary()) {
            InputStream inputStream = manager.open(this.iperfBinaryName);

            byte[] buffer = new byte[inputStream.available()];
            inputStream.read(buffer);
            File targetFile = new File(this.iperfPath,
                    this.iperfBinaryName
            );

            Log.d(TAG, "Creating binary in path: " + targetFile);

            OutputStream outStream = new FileOutputStream(targetFile);
            outStream.write(buffer);
            outStream.flush();
            outStream.close();

            inputStream.close();

            makeBinaryExecutable();
        }


    }

    public void init() throws ErrnoException {
        this.manager = context.getAssets();
        this.iperfPath = context.getApplicationContext().getFilesDir().getAbsolutePath();
        Os.setenv("TEMP", this.iperfPath, true);
        this.iperfBinaryName = context.getResources().getString(R.string.asset_exec_name);
        this.iperfAbsolutePath = iperfPath.concat(File.separator).concat(this.iperfBinaryName);

    }


    public void makeBinaryExecutable() {

        Log.d(TAG, "Making binary executable ");

        String command = this.context.getResources().getString(R.string.command_exec_permissions_prefix);
        command = command.concat(" " + this.iperfAbsolutePath);

        ExecuteShell.execute(command);

    }


    @Override
    protected Boolean doInBackground(Context... objects) {

        try {

            Optional.ofNullable(objects).orElseThrow(() -> new GeneralException("Params cannot be null"));

            if (objects.length < 1) {
                throw new GeneralException("Almost you should define param 1 (context)");
            }

            Context context = (Context) objects[0];

            init();
            makeIperfBinary();


        } catch (ErrnoException | IOException e) {
            Log.e(TAG, "EXCEPTION", e);
        }

        return null;
    }


    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);

    }

    @Override
    protected void onPostExecute(Boolean result) {

        this.buttonRun.setEnabled(true);

    }
}
