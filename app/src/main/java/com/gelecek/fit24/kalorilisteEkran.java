package com.gelecek.fit24;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class kalorilisteEkran extends Fragment {
    private KaloriViewModel mKaloriViewModel;

    Button egzersizegit,idealsayfasinagit,diyetegit,butonkalori;

    public static final int NEW_KALORI_ACTIVITY_REQUEST_CODE = 1;
    public kalorilisteEkran() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=  inflater.inflate(R.layout.fragment_kaloriliste_ekran, container, false);

        AppDatabase database = ((FitApplication)getActivity().getApplication()).getAppDatabase();



        RecyclerView recyclerView = view.findViewById(R.id.recyclerview);
        final KaloriListAdapter adapter = new KaloriListAdapter(getActivity());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mKaloriViewModel = new ViewModelProvider(getActivity()).get(KaloriViewModel.class);
        mKaloriViewModel.getAllKalori().observe(getActivity(), new Observer<List<Kalori>>() {
            @Override
            public void onChanged(@Nullable final List<Kalori> kaloris) {
                for (Kalori kalori : kaloris) {
                    System.out.println(String.format("%s - %d", kalori.YemekAdi, kalori.Kalorisi));
                }
                // Update the cached copy of the words in the adapter.
                adapter.setWords(kaloris);
            }
        });

     return view;
    }


    }





