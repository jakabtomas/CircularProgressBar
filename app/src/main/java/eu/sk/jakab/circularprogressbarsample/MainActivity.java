package eu.sk.jakab.circularprogressbarsample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnProgress, btnRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnProgress = findViewById(R.id.btn_progress);
        btnRecyclerView = findViewById(R.id.btn_recycler);

        btnProgress.setOnClickListener(this);
        btnRecyclerView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.btn_progress:
                intent = new Intent(this, ProgressBarSampleActivity.class);
                break;
            case R.id.btn_recycler:
                intent = new Intent(this, RecyclerViewSampleActivity.class);
                break;
        }
        if (intent != null)
            startActivity(intent);
    }
}
