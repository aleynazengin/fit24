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
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class hosgeldinEkrani extends Fragment {
    Button egzersizegit,idealsayfasinagit,diyetegit,butonkalori;
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
        final KaloriDao kaloriDao = database.kaloriDao();

        egzersizegit=view.findViewById(R.id.buttonegzersiz);
        idealsayfasinagit=view.findViewById(R.id.buttonideal);
        diyetegit=view.findViewById(R.id.buttondiyet);
        butonkalori=view.findViewById(R.id.buttonkalori);
        autotext=view.findViewById(R.id.autoCompleteTextView);

        List<String> arrList = new ArrayList<String>();
        List<Kalori> kaloriler = kaloriDao.getSorgu(autotext.getText().toString());
        for (int x = 0; x < kaloriler.size(); x++){

            arrList.add(kaloriler.get(x).YemekAdi+"\n");

        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(requireContext(),
                android.R.layout.simple_dropdown_item_1line, arrList);


        autotext.setAdapter(adapter);
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
                navController.navigate(R.id.action_hosgeldinEkrani_to_diyetListe);

            }
        });
        butonkalori.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_hosgeldinEkrani_to_kalorilisteEkran);
            }
        });
    }
}
