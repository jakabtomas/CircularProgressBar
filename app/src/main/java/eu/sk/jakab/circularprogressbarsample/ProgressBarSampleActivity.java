package eu.sk.jakab.circularprogressbarsample;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.Random;

import eu.sk.jakab.circularprogressbarlib.CircleProgressBar;
import eu.sk.jakab.circularprogressbarlib.CircleProgressBarWithText;

/**
 * Created by jakab on 7/10/2019.
 */
public class ProgressBarSampleActivity extends AppCompatActivity {
    CircleProgressBar circleProgressBar;
    CircleProgressBarWithText circleProgressBarWithText;
    Button btnRandom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);

        circleProgressBar = findViewById(R.id.progress_circular);
        circleProgressBarWithText = findViewById(R.id.progress_circular_with_text);
        btnRandom = findViewById(R.id.btn_random);

        //circleProgressBar dynamic setup
        /*circleProgressBar.setStrokeWidth(10);
        circleProgressBar.setColor(Color.GREEN);
        circleProgressBar.setMax(100);
        circleProgressBar.setMin(0);
        circleProgressBar.setProgress(55);
        circleProgressBar.setProgressWithAnimation(20);*/

        btnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random rnd = new Random();
                circleProgressBar.setProgressWithAnimation(rnd.nextFloat()*circleProgressBar.getMax());
                circleProgressBarWithText.setProgressWithAnimation(rnd.nextFloat()*circleProgressBarWithText.getMax());
                int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
                circleProgressBarWithText.setTitleColor(color);
                circleProgressBarWithText.setSubtitleColor(color);
            }
        });
    }
}
