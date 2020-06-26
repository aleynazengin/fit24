package com.gelecek.fit24;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class hosgeldinEkrani extends Fragment {
    Button egzersizegit,idealsayfasinagit,diyetegit,butonkalori,btnekle;
    AutoCompleteTextView autotext;
    TextView txttoplam,txthedef;
    private KaloriViewModel mKaloriViewModel;
    public static final int NEW_KALORI_ACTIVITY_REQUEST_CODE = 1;
    boolean durum=false;
    int gunluk_kalori;
    String secilenYemek="";
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
        btnekle=view.findViewById(R.id.buttonekle);
        egzersizegit=view.findViewById(R.id.buttonegzersiz);
        idealsayfasinagit=view.findViewById(R.id.buttonideal);
        diyetegit=view.findViewById(R.id.buttondiyet);
        butonkalori=view.findViewById(R.id.buttonkalori);
        autotext=view.findViewById(R.id.autoCompleteTextView);
        txthedef = view.findViewById(R.id.textViewhedef);
        txttoplam=view.findViewById(R.id.textViewtoplam);

        List<String> arrList = new ArrayList<String>();
        List<Kalori> kaloriler = kaloriDao.getSorgu(autotext.getText().toString());
        for (int x = 0; x < kaloriler.size(); x++){

            arrList.add(kaloriler.get(x).YemekAdi);

        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(requireContext(),
                android.R.layout.simple_dropdown_item_1line, arrList);


        autotext.setAdapter(adapter);
        autotext.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                secilenYemek= ((TextView)view).getText().toString();
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((MainActivity)getActivity()).showActionBar();
        final NavController navController = Navigation.findNavController(view);
        btnekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppDatabase database = ((FitApplication)getActivity().getApplication()).getAppDatabase();
                final KaloriDao kaloriDao = database.kaloriDao();
                final TuketimDao tuketimDao = database.tuketimDao();
                checkDataEntered();
                if(durum==true) {
                    Kalori gelenkalori = kaloriDao.getKalorim(secilenYemek);
                    Date date = new Date();
                    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                    String strDate = formatter.format(date);

                    Tuketim tuketim= new Tuketim();
                    tuketim.setUserId(2);
                    tuketim.setKaloriId(gelenkalori.KaloriId);
                    tuketim.setKalorisi(gelenkalori.Kalorisi);
                    tuketim.setTarih(strDate);
                    tuketim.setOgun(1);
                    tuketim.setKaloriYemekAdi(gelenkalori.YemekAdi);
                    tuketimDao.insertTuketimler(tuketim);

                    gunluk_kalori+=gelenkalori.Kalorisi;
                    txttoplam.setText(gunluk_kalori+"");
                    Toast t = Toast.makeText(getActivity(), "Başarılı!", Toast.LENGTH_SHORT);
                    t.show();
                }

            }
        });
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
    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    void checkDataEntered(){
        if (isEmpty(autotext)) {
            Toast t = Toast.makeText(getActivity(), "Önce yemek seçiniz!", Toast.LENGTH_SHORT);
            t.show();
        }
        else{
            durum=true;
        }
    }

}
