package com.example.fragmentdemo.Fragments;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fragmentdemo.CostumeClasses.Person;
import com.example.fragmentdemo.R;


public class OutputFragment extends Fragment {


    public OutputFragment() {
        // Required empty public constructor
    }

    @RequiresApi(api = Build.VERSION_CODES.TIRAMISU)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_output, container, false);

        TextView tvName = view.findViewById(R.id.tvName);
        TextView tvAge = view.findViewById(R.id.tvAge);


        Bundle bundle = this.getArguments();
        if (bundle != null) {
            Person person = bundle.getParcelable("Person"); // Key
            tvName.setText(person.getPersonName());
            tvAge.setText(person.getPersonAge());

        }






        return view;
    }
}