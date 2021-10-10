package com.example.gymapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

public class AllTrainingActivity extends AppCompatActivity {
    private static final String TAG = "AllTrainingActivity";
    private RecyclerView recyclerView;
    private TrainingRecViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_training);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        adapter = new TrainingRecViewAdapter(this);

        Log.d(TAG, "onCreate: Util"+Utils.getAlltrainings().size());

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter.setTrainings(Utils.getAlltrainings());








    }
}