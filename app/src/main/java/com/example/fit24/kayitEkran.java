package com.example.fit24;

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
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class kayitEkran extends Fragment {
    private EditText textAd,textSoyad,textMail,textKadi,textSifre,textSifre2;
    private Button kayitol;


    public kayitEkran() {
        // Required empty public constructor
        }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_kayit_ekran, container, false);
        kayitol = view.findViewById(R.id.buttonkayitol);
        AppDatabase database = ((FitApplication)getActivity().getApplication()).getAppDatabase();
        final UserDao userDao = database.userDao();
        textAd=view.findViewById(R.id.textAd);
        textSoyad=view.findViewById(R.id.textSoyad);
        textMail=view.findViewById(R.id.textMail);
        textKadi=view.findViewById(R.id.textKadi);
        textSifre=view.findViewById(R.id.textSifre);
        textSifre2=view.findViewById(R.id.textSifre2);
        kayitol=view.findViewById(R.id.buttonkayitol);

        kayitol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Name=textAd.getText().toString();
                String SurName=textSoyad.getText().toString();
                String Email=textMail.getText().toString();
                String Username= textKadi.getText().toString();
                String Password= textSifre.getText().toString();
                String Password2= textSifre2.getText().toString();
                User addUser = new User();
                addUser.Id=1;
                addUser.Username="Aleyna";
                addUser.Password="1234";
                addUser.Email="aleyna@gmail.com";
                addUser.Name="Aleyna";
                addUser.Surname="Zengin";
                addUser.Height=0;
                addUser.Age=21;
                addUser.Gender=0;
                addUser.Weight=0;
                addUser.Goal=0;
                addUser.Reactivity=0;
                userDao.save(addUser);
                Toast.makeText(getActivity(),"Kullanıcı kaydı başarı ile yapıldı.",Toast.LENGTH_SHORT) .show();

                textAd.setText("");
                textSoyad.setText("");
                textMail.setText("");
                textKadi.setText("");
                textSifre.setText("");

            }
        });
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final NavController navController = Navigation.findNavController(view);
        kayitol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_kayitEkran_to_cinsiyetEkran);
            }
        });
    }
}



