package com.gelecek.fit24;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;


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
    int selectedId=0;
    String value, value2;
    boolean durum=false;

    public idealkiloEkran() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view= inflater.inflate(R.layout.fragment_idealkilo_ekran, container, false);

        editTextboy=view.findViewById(R.id.editTextboy);
        editTextkilo=view.findViewById(R.id.editTextkilo);
        btnhesapla=view.findViewById(R.id.buttonhesapla);
        radioGroup = view.findViewById(R.id.rdgrup);
        txtideal=view.findViewById(R.id.textViewideal);
        txtfark = view.findViewById(R.id.textViewfark);

        final BottomNavigationView bottomNavigationView = view.findViewById(R.id.bottom_navigation);

        NavigationUI.setupWithNavController(bottomNavigationView, Navigation.findNavController(requireActivity(),R.id.fragment));


        btnhesapla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedId = radioGroup.getCheckedRadioButtonId(); //radio gruptan check edilen radiobuttonun idsini al
                radioButton = radioGroup.findViewById(selectedId); // idye göre radiobuttonu bul
                checkDataEntered();
                if(durum==true) {

                    value = editTextkilo.getText().toString();
                    kilo = Integer.parseInt(value);
                    value2 = editTextboy.getText().toString();
                    boy = Integer.parseInt(value2);

                    // find the radiobutton by returned id
                    if (selectedId == R.id.radioButtonkadın) { // kadın ise
                        idealkilo = 45.5 + (2.3 / 2.54) * (boy - 152.4);
                    }
                    if (selectedId == R.id.radioButtonerkek) { //erkek ise
                        idealkilo = 50 + (2.3 / 2.54) * (boy - 152.4);
                    }
                    int idealkilom = (int) idealkilo; //double gelen değeri inte çevir

                    txtideal.setText(idealkilom + "");
                    fark = idealkilom - kilo;
                    int farkım = (int) fark;

                    farkım= Math.abs(farkım); //Fark her zaman mutlak değer olarak gözüksün
                    txtfark.setText("" + farkım);
                }
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((MainActivity)getActivity()).showActionBar();
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("İdeal Kilo Hesaplama");

        final NavController navController = Navigation.findNavController(view);

    }
    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    void checkDataEntered(){
        if (isEmpty(editTextboy)) {
            Toast t = Toast.makeText(getActivity(), "Boyunuzu yazınız!", Toast.LENGTH_SHORT);
            t.show();
        }
        else if (isEmpty(editTextkilo)) {
            Toast t = Toast.makeText(getActivity(), "Kilonuzu yazınız!", Toast.LENGTH_SHORT);
            t.show();
        }
        else if (selectedId==-1) {
            Toast t = Toast.makeText(getActivity(), "Cinsiyet seçiniz!", Toast.LENGTH_SHORT);
            t.show();
        }

        else{
            durum=true;
        }
    }
}
