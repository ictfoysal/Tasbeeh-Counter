package com.foysaltech.tasbeehcounter;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Vibrator mVibrator;
    ImageButton BTureVibrator, resftz;
    boolean isTureVibrator = true;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView myTextView = (TextView) findViewById(R.id.textAd);

        ImageButton btnVibrate = findViewById(R.id.CounntAdd);
        resftz = findViewById(R.id.restz);
        BTureVibrator = findViewById(R.id.addvibrator);
        // Vibrator 2
        mVibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        btnVibrate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Vibrates 3 : for 100 Milliseconds
                if (isTureVibrator) {
                    mVibrator.vibrate(100);
                }
                count++;
                myTextView.setText("" + count);

            }
        });

        resftz.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (isTureVibrator) {
                    mVibrator.vibrate(100);
                }
                count--;
                if (count < 0) {
                    count = 0;
                }
                myTextView.setText("" + count);
            }
        });

        BTureVibrator.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Vibrates 3 : for 100 Milliseconds
                mVibrator.vibrate(100);
                if (isTureVibrator) {
                    isTureVibrator = false;
                    BTureVibrator.setImageResource(R.drawable.vibrate_off);
                } else {
                    isTureVibrator = true;
                    BTureVibrator.setImageResource(R.drawable.vibrate_on);
                }
            }
        });
    }
}