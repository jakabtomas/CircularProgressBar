package eu.sk.jakab.circularprogressbarsample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jakab on 7/10/2019.
 */
public class RecyclerViewSampleActivity extends AppCompatActivity implements RecyclerViewAdapter.RecyclerViewAdapterInterface {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        List<Machine> machines = new ArrayList<>();
        machines.add(new Machine("Machine 1"));
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(machines, this);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void openMachine(Machine machine) {
        Toast.makeText(this,"open "+machine.getName(),Toast.LENGTH_SHORT).show();
    }
}
