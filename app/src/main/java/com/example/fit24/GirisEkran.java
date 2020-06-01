package com.example.fit24;

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
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class GirisEkran extends Fragment {
    Button girisyap;
    Boolean durum=false;
    EditText kadı,sifre;

    public GirisEkran() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_giris_ekran, container, false);
        girisyap=view.findViewById(R.id.buttongiris2);
        kadı=view.findViewById(R.id.editTextkad);
        sifre=view.findViewById(R.id.editTextsifre);
        return  view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        girisyap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkDataEntered();
                if(durum==true) {
                    final NavController navController = Navigation.findNavController(view);
                    girisyap.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            navController.navigate(R.id.action_girisEkran_to_hosgeldinEkrani);
                        }
                    });
                }
            }
        });

    }
    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }
    void checkDataEntered(){
        if (isEmpty(kadı)) {
            Toast t = Toast.makeText(getActivity(), "Kullanıcı adı boş bırakılamaz!", Toast.LENGTH_SHORT);
            t.show();
        }
        else if (isEmpty(sifre)) {
            Toast t = Toast.makeText(getActivity(), "Şifre boş bırakılamaz!", Toast.LENGTH_SHORT);
            t.show();
        }
        else{
            durum=true;
        }
    }
}
