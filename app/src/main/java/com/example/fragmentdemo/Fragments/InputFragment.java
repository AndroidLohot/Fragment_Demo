package com.example.fragmentdemo.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fragmentdemo.CostumeClasses.Person;
import com.example.fragmentdemo.R;

public class InputFragment extends Fragment {


    public InputFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myView = inflater.inflate(R.layout.fragment_input, container, false);

        Button btnSubmit=myView.findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText etName, etAge;

                etName=myView.findViewById(R.id.etPersonName);
                etAge=myView.findViewById(R.id.etPersonAge);
                
                String name = etName.getText().toString().trim();
                String age = etAge.getText().toString().trim();
                
                if (name.isEmpty() == age.isEmpty())
                {
                    OutputFragment outputFragment=new OutputFragment();

                    Bundle passInfo=new Bundle();

                    passInfo.putParcelable("Person", new Person(name, age));

                    outputFragment.setArguments(passInfo);

                    getActivity()
                            .getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragmentContainerView, outputFragment)
                            .addToBackStack(null)
                            .commit();
                }
                else {
                    Toast.makeText(getActivity().getApplication(), "Enter your filed", Toast.LENGTH_SHORT).show();
                    return;

                }



            }
        });

        return myView;
    }
}