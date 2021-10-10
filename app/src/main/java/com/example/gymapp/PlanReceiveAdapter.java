package com.example.gymapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class PlanReceiveAdapter extends RecyclerView.Adapter<PlanReceiveAdapter.ViewHolder> {
    private static final String TAG = "PlanRecAdapter";
    private Context context;
    private ArrayList<Plan> plan = new ArrayList<>();

    public PlanReceiveAdapter(Context context){
        this.context = context;
    }
    public PlanReceiveAdapter(){

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.plan_list_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: started");
        holder.nametv.setText(plan.get(position).getTraining().getName());
        Glide.with(context)
                .asBitmap()
                .load(plan.get(position).getTraining().getImageUrl())
                .into(holder.trainingiv);
        holder.sortdesctv.setText(plan.get(position).getTraining().getSrtdesc());
        holder.timetv.setText(String.valueOf(plan.get(position).getMinute()));
        if(plan.get(position).isAccomplished()){
            holder.emptyiv.setVisibility(View.GONE);
            holder.fillediv.setVisibility(View.VISIBLE);
        }else{
            holder.emptyiv.setVisibility(View.VISIBLE);
            holder.fillediv.setVisibility(View.GONE);
        }

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO navigate to plan activity
            }
        });

    }

    @Override
    public int getItemCount() {
        return plan.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private CardView cardView;
        private TextView nametv , timetv , sortdesctv;
        private ImageView fillediv , emptyiv , trainingiv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            initWigets();
        }

        private void initWigets(){
            cardView = itemView.findViewById(R.id.plancardview);
            nametv = itemView.findViewById(R.id.nametv1);
            timetv = itemView.findViewById(R.id.txttimeamount);
            sortdesctv = itemView.findViewById(R.id.sortdestv);
            fillediv = itemView.findViewById(R.id.filledcheckbox);
            emptyiv = itemView.findViewById(R.id.emptycheckboxbtn);
            trainingiv = itemView.findViewById(R.id.imageview1);

        }
    }
}
