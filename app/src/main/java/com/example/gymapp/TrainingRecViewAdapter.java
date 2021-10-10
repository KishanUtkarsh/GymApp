package com.example.gymapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
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

public class TrainingRecViewAdapter extends RecyclerView.Adapter<TrainingRecViewAdapter.ViewHolder> {

    private static final String TAG = "TrainingRecViewAdapter";
    private Context context;
    private ArrayList<GymTraining> trainings = new ArrayList<>();
    public TrainingRecViewAdapter(Context context) {
        this.context = context;
    }
    public TrainingRecViewAdapter(){

    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.training_list_item , parent , false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Log.d(TAG, "onBindViewHolder: Started" + position);
        holder.trainingnametv.setText(trainings.get(position).getName());
        holder.sortdestv.setText(trainings.get(position).getSrtdesc());
        Glide.with(context).asBitmap().load(trainings.get(position).getImageUrl()).into(holder.trainingImageview);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO : intent to the description page
                Intent intent = new Intent(context , TrainingActivity.class);
                intent.putExtra("training" , trainings.get(position));
                context.startActivity(intent);
            }
        });



    }


    @Override
    public int getItemCount() {
        return trainings.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private CardView cardView;
        private TextView trainingnametv , sortdestv;
        private ImageView trainingImageview;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.trainingcardview);
            trainingnametv = (TextView) itemView.findViewById(R.id.trainingNametv);
            sortdestv = (TextView) itemView.findViewById(R.id.sortdestv);
            trainingImageview = (ImageView) itemView.findViewById(R.id.trainingimageview);

        }
    }

    public void setTrainings(ArrayList<GymTraining> trainings) {
        this.trainings = trainings;
        notifyDataSetChanged();
    }
}
