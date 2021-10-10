package com.example.gymapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.ArrayList;

public class AskForDetailDailogBox extends DialogFragment {
    private static final String TAG = "AskForDetailDailogBox";

    private EditText editText;
    private Spinner spinner;
    private Button addbtn , cancelbtn;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View view = getActivity().getLayoutInflater().inflate(R.layout.dialog_ask_for_details,null);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
                .setTitle("Enter Details :")
                .setView(view);
        initWigits(view);

        ArrayList<String> days = new ArrayList<>();
        days.add("SUNDAY");
        days.add("MONDAY");
        days.add("TUESDAY");
        days.add("WEDNESDAY");
        days.add("THURSDAY");
        days.add("FRIDAY");
        days.add("SATURDAY");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item,days);
        spinner.setAdapter(adapter);

        cancelbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO : pass data to parent activity
            }
        });

        return builder.create();
    }
    private void initWigits(View view){
        Log.d(TAG, "initWigits: started");
        editText = view.findViewById(R.id.numberet);
        spinner = view.findViewById(R.id.spinnerday);
        addbtn = view.findViewById(R.id.addbtn);
        cancelbtn = view.findViewById(R.id.cancelbtn);
    }

}
