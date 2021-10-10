package com.example.gymapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class PlanActivity extends AppCompatActivity {

    private static final String TAG ="PlanActivity" ;
    private NestedScrollView nestedScrollView;
    private TextView monedit , tueedit , wededit ,thruedit , friedit ,satedit ,sunedit;
    private RecyclerView monrec , tuerec ,wedrec , thrurec ,frirec , satrec ,sunrec;
    private Button btnAddToPlan;
    private RelativeLayout notAddedPlan;

    private PlanReceiveAdapter monAdapter , tueAdapter , wedAdapter , thrAdapter , friAdapter , satAdapter ,sunAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);
        initwidgets();
        initAdapters();
        initRecView();


        if(Utils.getUsersPlans().size()>0){
            notAddedPlan.setVisibility(View.GONE);
            nestedScrollView.setVisibility(View.VISIBLE);
        }else{
            notAddedPlan.setVisibility(View.VISIBLE);
            nestedScrollView.setVisibility(View.GONE);
        }



    }

    private void initwidgets(){

        nestedScrollView = findViewById(R.id.nestedscrolableview);

        monedit = findViewById(R.id.mondayedittv);
        tueedit = findViewById(R.id.tuesdayedittv);
        wededit = findViewById(R.id.wednesdayedittv);
        thruedit = findViewById(R.id.thrusdayedittv);
        friedit = findViewById(R.id.fridayedittv);
        satedit = findViewById(R.id.saturdayedittv);
        sunedit = findViewById(R.id.sundayedittv);

        monrec = findViewById(R.id.mondayrv);
        tuerec = findViewById(R.id.tuesdayrv);
        wedrec = findViewById(R.id.wednesdayrv);
        thrurec = findViewById(R.id.thrusdayrv);
        frirec = findViewById(R.id.fridayrv);
        satrec = findViewById(R.id.saturdayrv);
        sunrec = findViewById(R.id.sundayrv);

        btnAddToPlan = findViewById(R.id.addtomyplanbtn);
        notAddedPlan = findViewById(R.id.notAddedPlanrl);

    }
    private void initAdapters(){
        Log.d(TAG, "initAdapters: started");
        monAdapter = new PlanReceiveAdapter(this);
        tueAdapter = new PlanReceiveAdapter(this);
        wedAdapter = new PlanReceiveAdapter(this);
        thrAdapter = new PlanReceiveAdapter(this);
        friAdapter = new PlanReceiveAdapter(this);
        satAdapter = new PlanReceiveAdapter(this);
        sunAdapter = new PlanReceiveAdapter(this);

    }
    private void initRecView(){
        Log.d(TAG, "initRecView: started");

        monrec.setAdapter(monAdapter);
        monrec.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));

        tuerec.setAdapter(tueAdapter);
        tuerec.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));

        wedrec.setAdapter(wedAdapter);
        wedrec.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));

        thrurec.setAdapter(thrAdapter);
        thrurec.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));

        frirec.setAdapter(friAdapter);
        frirec.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));

        satrec.setAdapter(satAdapter);
        satrec.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));

        sunrec.setAdapter(sunAdapter);
        sunrec.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));

    }
}