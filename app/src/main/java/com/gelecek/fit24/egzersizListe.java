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


/**
 * A simple {@link Fragment} subclass.
 */
public class egzersizListe extends Fragment {
    Button egzersizegit,idealsayfasinagit,diyetegit;

    public egzersizListe() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_egzersiz_liste, container, false);
        egzersizegit=view.findViewById(R.id.buttonegzersiz4);
        idealsayfasinagit=view.findViewById(R.id.buttonideal4);
        diyetegit=view.findViewById(R.id.buttondiyet4);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final NavController navController = Navigation.findNavController(view);
        egzersizegit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_egzersizListe_self);
            }
        });
        idealsayfasinagit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_egzersizListe_to_idealkiloEkran);
            }
        });
        diyetegit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_egzersizListe_to_diyetListe);
            }
        });
    }
}
