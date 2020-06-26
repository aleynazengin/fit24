package com.gelecek.fit24;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class idealkiloEkran extends Fragment {
    Button egzersizegit,idealsayfasinagit,diyetegit,btnhesapla;
    EditText editTextboy,editTextkilo;
    RadioGroup radioGroup;
    RadioButton radioButton;
    int boy=0,kilo=0;
    double idealkilo=0,fark=0;
    TextView txtideal,txtfark;
    String value, value2;

    public idealkiloEkran() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view= inflater.inflate(R.layout.fragment_idealkilo_ekran, container, false);
        egzersizegit=view.findViewById(R.id.buttonegzersiz2);
        idealsayfasinagit=view.findViewById(R.id.buttonideal2);
        diyetegit=view.findViewById(R.id.buttondiyet2);
        editTextboy=view.findViewById(R.id.editTextboy);
        editTextkilo=view.findViewById(R.id.editTextkilo);
        btnhesapla=view.findViewById(R.id.buttonhesapla);
        radioGroup = view.findViewById(R.id.rdgrup);
        txtideal=view.findViewById(R.id.textViewideal);
        txtfark = view.findViewById(R.id.textViewfark);

        btnhesapla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                radioButton = radioGroup.findViewById(selectedId);
                value=editTextkilo.getText().toString();
                kilo =Integer.parseInt(value);
                value2=editTextboy.getText().toString();
                boy =Integer.parseInt(value2);

                // find the radiobutton by returned id
                if (selectedId==R.id.radioButtonkadın){
                    idealkilo= 45.5 + (2.3 / 2.54)*(boy - 152.4);
                }
                if (selectedId==R.id.radioButtonerkek){
                    idealkilo=50 + (2.3 / 2.54)*(boy - 152.4);
                }
                int idealkilom=(int)idealkilo;
                txtideal.setText(idealkilom+"");
                fark= idealkilo-kilo;
                int farkım=(int)fark;
                txtfark.setText(""+farkım);

            }
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((MainActivity)getActivity()).showActionBar();
        final NavController navController = Navigation.findNavController(view);
        egzersizegit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_idealkiloEkran_to_egzersizListe);
            }
        });
        idealsayfasinagit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_idealkiloEkran_self);
            }
        });
        diyetegit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_idealkiloEkran_to_diyetListe);
            }
        });
    }
}
