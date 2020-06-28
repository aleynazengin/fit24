package com.gelecek.fit24;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

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

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;


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
    int UserId=2;
    String secilenYemek="";
    TabLayout tabLayout;
    int ogun=1;
    int yas=0,boy=0,kilo=0,reactivity=0,gender=0;
    double bmh=0,af=0,gunluk=0,goal=0;
    int tuketimId=0;

    public hosgeldinEkrani() {

        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_hosgeldin_ekrani, container, false);

        BottomNavigationView bottomNavigationView = view.findViewById(R.id.bottom_navigation);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.diyetListe, R.id.egzersizListe, R.id.hosgeldinEkrani,R.id.idealkiloEkran,R.id.ayarlarFragment,R.id.fragment_diyet_liste)
                .build();

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
        tabLayout=view.findViewById(R.id.tablayout);
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
        //Günlük kalori ihtiyacı hesaplama
        UserId = ((MainActivity)getActivity()).getLoginUserId();
        AppDatabase database = ((FitApplication)getActivity().getApplication()).getAppDatabase();
        final UserDao userDao = database.userDao();
        User user= userDao.getLoginUser(UserId);
        yas= user.Age;
        kilo=user.Weight;
        boy=user.Height;
        reactivity=user.Reactivity;
        gender=user.Gender;
        goal=user.Goal;

      switch (reactivity){
          case 1: af=1.2;
              break;
          case 2: af=1.55;
              break;
          case 3: af=1.725;
              break;
          default:break;
      }
        if (gender==1) //erkek
        {
            bmh = 655 + 9.6 *(kilo) + 1.8*(boy) - 4.7*(yas);

        }
        if (gender==2){ //kadın
            bmh = 66 + 13.7 *(kilo) + 5*(boy) - 6.8*(yas);
        }
        gunluk= bmh*af;
        if (goal==1){ //kilo ver
            gunluk-=297;
        }
        if (goal==3){ //kilo al
            gunluk+=297;
        }
        int gun= (int) gunluk;
        txthedef.setText(gun+"");

        final NavController navController = Navigation.findNavController(view);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0) {
                    ogun=1;
                }
                if (tab.getPosition() == 1) {
                    ogun=2;
                }
                if (tab.getPosition() == 2) {
                    ogun=3;
                }
                if (tab.getPosition() == 3) {
                    ogun=4;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
        btnekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppDatabase database = ((FitApplication)getActivity().getApplication()).getAppDatabase();
                final KaloriDao kaloriDao = database.kaloriDao();
                final TuketimDao tuketimDao = database.tuketimDao();
                Tuketim tuketimgelen= tuketimDao.getSonTuketim();
                if (tuketimgelen!=null){
                tuketimId= tuketimgelen.TuketimId;
                }
                tuketimId++;
                checkDataEntered();
                if(durum==true) {
                    Kalori gelenkalori = kaloriDao.getKalorim(secilenYemek);
                    Date date = new Date();
                    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                    String strDate = formatter.format(date);

                    Tuketim tuketim= new Tuketim();
                    tuketim.setTuketimId(tuketimId);
                    tuketim.setUserId(UserId);
                    tuketim.setKaloriId(gelenkalori.KaloriId);
                    tuketim.setKalorisi(gelenkalori.Kalorisi);
                    tuketim.setTarih(strDate);
                    tuketim.setOgun(ogun);
                    tuketim.setKaloriYemekAdi(gelenkalori.YemekAdi);
                    tuketimDao.insertTuketimler(tuketim);
                    autotext.setText("");
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
            Toast t = Toast.makeText(getActivity(), "Lütfen yemek seçiniz!", Toast.LENGTH_SHORT);
            t.show();
        }

        else{
            durum=true;
        }
    }

}
