package com.j6idot.theliteeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        File rootaccess = new File("/bin/su");
        if (rootaccess.exists()) {
            try {
                Process p = Runtime.getRuntime().exec("su -c touch /data/data/com.j6idot.theliteeapp/TheChosenOne");
                RootAccessLol();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        showToast();

        Button askforsu = findViewById(R.id.askforsus);
        askforsu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Process p = Runtime.getRuntime().exec("su");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                RootAccessLol();
                TheMainPage();
            }
        });
    }

    private void showToast() {
        Context context = getApplicationContext();
        CharSequence text = "Yes! The su file has been found in /bin/su.";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    private void TheMainPage() {
        Intent TheFuck;
        TheFuck = new Intent(this, TheMainPage.class);
        startActivity(TheFuck);
    }

    @SuppressLint("SdCardPath")
    private void RootAccessLol() {
        File rootaccesslol = new File("/data/data/com.j6idot.theliteeapp/TheChosenOne");
        if (rootaccesslol.exists()) {
            TheMainPage();
            try
            {
                Thread.sleep(600);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
            try {
                Process p = Runtime.getRuntime().exec("su -c rm -rf /data/data/com.j6idot.theliteeapp/TheChosenOne");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
