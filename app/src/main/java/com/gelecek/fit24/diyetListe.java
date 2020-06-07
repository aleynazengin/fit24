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
public class diyetListe extends Fragment {
    Button egzersizegit,idealsayfasinagit,diyetegit,diyetgetir;
    private DiyetViewModel mDiyetViewModel;
    TextView aciklama;

    public static final int NEW_DIYET_ACTIVITY_REQUEST_CODE = 1;
    public diyetListe() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_diyet_liste, container, false);
        egzersizegit=view.findViewById(R.id.buttonegzersiz3);
        idealsayfasinagit=view.findViewById(R.id.buttonideal3);
        diyetegit=view.findViewById(R.id.buttondiyet3);
        diyetgetir=view.findViewById(R.id.buttondiyetgetir);
        aciklama=view.findViewById(R.id.textViewdiyetitem);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerview2);
        final DiyetListAdapter adapter = new DiyetListAdapter(getActivity());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mDiyetViewModel = new ViewModelProvider(getActivity()).get(DiyetViewModel.class);
        mDiyetViewModel.getAllDiyet().observe(getActivity(), new Observer<List<Diyet>>() {
            @Override
            public void onChanged(@Nullable final List<Diyet> diyets) {
                for (Diyet diyet : diyets ) {
                    System.out.println(String.format("%s - %s", diyet.DİyetAdi, diyet.DiyetAciklama));
                }
                // Update the cached copy of the words in the adapter.
                adapter.setWords(diyets);
            }
        });
       /* diyetgetir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (aciklama.getVisibility()!=View.VISIBLE){
                    aciklama.setVisibility(View.VISIBLE);
                }
                else{
                    aciklama.setVisibility(View.GONE);
                }

            }
        }); */
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final NavController navController = Navigation.findNavController(view);
        egzersizegit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_diyetListe_to_egzersizListe);
            }
        });
        idealsayfasinagit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_diyetListe_to_idealkiloEkran);
            }
        });
        diyetegit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_diyetListe_self);
            }
        });
    }
}
