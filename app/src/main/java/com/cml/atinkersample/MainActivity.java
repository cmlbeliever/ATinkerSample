package com.cml.atinkersample;

import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.tencent.tinker.lib.tinker.TinkerInstaller;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MyTag";

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            Toast.makeText(getApplication(), "====" + TAG + "," + msg.what, Toast.LENGTH_LONG).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handler.sendEmptyMessage(100);
    }

    public void applyPath(View view) {

        File baseFolder = Environment.getExternalStorageDirectory();
//        if (!baseFolder.exists()) {
//            baseFolder.mkdirs();
//            Toast.makeText(getApplication(), "baseFolder file not exist!!!", Toast.LENGTH_LONG).show();
//        }
        File patchFile = new File(baseFolder, "patch_signed_7zip.apk");
        if (!patchFile.exists()) {
            Toast.makeText(getApplication(), "patch file not exist!!!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplication(), "patch file  exist!!!", Toast.LENGTH_LONG).show();
            TinkerInstaller.onReceiveUpgradePatch(this, patchFile.getAbsolutePath());
        }
    }
}
