package com.example.fit24;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class hosgeldinEkrani extends Fragment {
    Button egzersizegit,idealsayfasinagit,diyetegit;
    AutoCompleteTextView autotext;
    private KaloriViewModel mKaloriViewModel;
    public static final int NEW_KALORI_ACTIVITY_REQUEST_CODE = 1;

    public hosgeldinEkrani() {

        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_hosgeldin_ekrani, container, false);
        AppDatabase database = ((FitApplication)getActivity().getApplication()).getAppDatabase();
        egzersizegit=view.findViewById(R.id.buttonegzersiz);
        idealsayfasinagit=view.findViewById(R.id.buttonideal);
        diyetegit=view.findViewById(R.id.buttondiyet);
        autotext=view.findViewById(R.id.autoCompleteTextView);
        final KaloriListAdapter adapter = new KaloriListAdapter(getActivity());
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

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final NavController navController = Navigation.findNavController(view);
        egzersizegit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_hosgeldinEkrani_to_egzersizListe);
            }
        });
        idealsayfasinagit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_hosgeldinEkrani_to_idealkiloEkran);
            }
        });
        diyetegit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_hosgeldinEkrani_to_kalorilisteEkran);
                //navController.navigate(R.id.action_hosgeldinEkrani_to_diyetListe);
                // kaloriyi görmek için buna link verdim normalde üstteki çalışacak
            }
        });
    }
}
