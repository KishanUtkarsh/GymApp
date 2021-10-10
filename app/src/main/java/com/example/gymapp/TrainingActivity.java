package com.example.gymapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class TrainingActivity extends AppCompatActivity {
    private TextView nametv , longdestv;
    private ImageView imageView;
    private Button addtolistbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);

        initwigets();
        Intent intent = getIntent();
        try {
            GymTraining incommingtraining = intent.getParcelableExtra("training");
            nametv.setText(incommingtraining.getName());
            longdestv.setText(incommingtraining.getLongdesc());
            Glide.with(this).asBitmap().load(incommingtraining.getImageUrl()).into(imageView);

            addtolistbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //TODO show a dialog
                }
            });
        }catch (NullPointerException e){
            e.getMessage();
        }

    }
    private void initwigets(){
        nametv = (TextView) findViewById(R.id.nametv);
        longdestv = (TextView) findViewById(R.id.longtv);
        addtolistbtn = (Button) findViewById(R.id.addtomyplanbtn);
        imageView = (ImageView) findViewById(R.id.imageview);
    }
}