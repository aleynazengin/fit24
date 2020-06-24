package com.gelecek.fit24;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class egzersizListe extends Fragment {
    Button egzersizegit, idealsayfasinagit, diyetegit,butonkalori;
    private EgzersizViewModel mEgzersizViewModel;
    TextView aciklama;

    public static final int NEW_EGZERSIZ_ACTIVITY_REQUEST_CODE = 1;

    public egzersizListe() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_egzersiz_liste, container, false);
        egzersizegit = view.findViewById(R.id.buttonegzersiz);
        idealsayfasinagit = view.findViewById(R.id.buttonideal);
        diyetegit = view.findViewById(R.id.buttondiyet);
        butonkalori=view.findViewById(R.id.buttonkalori);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerview3);
        final EgzersizListAdapter adapter = new EgzersizListAdapter(getActivity());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        mEgzersizViewModel = new ViewModelProvider(getActivity()).get(EgzersizViewModel.class);
        mEgzersizViewModel.getmAllEgzersiz().observe(getActivity(), new Observer<List<Egzersiz>>() {
            @Override
            public void onChanged(@Nullable final List<Egzersiz> egzersizs) {
                for (Egzersiz egzersiz : egzersizs) {
                    System.out.println(String.format("%s - %s", egzersiz.EgzersizImage,egzersiz.EgzersizAdi));
                }
                // Update the cached copy of the words in the adapter.
                adapter.setWords(egzersizs);
            }
        });
        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((MainActivity)getActivity()).showActionBar();

    }

}


