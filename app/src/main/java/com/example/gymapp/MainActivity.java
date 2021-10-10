package com.example.gymapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {
    private Button allactivitybtn , allplanbtn , aboutbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Utils.initlizeAll();

        allactivitybtn = (Button) findViewById(R.id.allactivitybtn);
        allplanbtn = (Button) findViewById(R.id.allplanbtn);
        aboutbtn = (Button) findViewById(R.id.aboutbtn);


        aboutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickingAbout();
            }
        });

        setOnclickLishner();

    }
    private void onClickingAbout(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("About");
        builder.setMessage("Fitness App\nDeveloped by Kishan Kumar\nContact me For more\nWant to see my Work\nThen Click Yes");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Intent intent = new Intent(MainActivity.this,webView.class);
                intent.putExtra("Url" , "https://github.com/KishanUtkarsh");
                startActivity(intent);
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setCancelable(false);
        builder.create().show();
    }

    private void setOnclickLishner(){
        allactivitybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , AllTrainingActivity.class);
                startActivity(intent);
            }
        });
    }
}