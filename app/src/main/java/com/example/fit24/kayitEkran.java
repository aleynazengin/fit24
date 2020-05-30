package com.example.fit24;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;


/**
 * A simple {@link Fragment} subclass.
 */
public class kayitEkran extends Fragment {
    Button kayitol;
    ViewModel userViewModel;


    public kayitEkran() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_kayit_ekran, container, false);
        userViewModel = ViewModelProviders.of(this).get(ViewModel.class);
        kayitol=view.findViewById(R.id.buttonkayitol);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final NavController navController = Navigation.findNavController(view);
        kayitol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText adı = view.findViewById(R.id.editTextadı);
                EditText soyadı = view.findViewById(R.id.editTextsoyadı);
                EditText kad = view.findViewById(R.id.editTextkad);
                EditText eposta = view.findViewById(R.id.editTexteposta);
                EditText sifre = view.findViewById(R.id.editTextsifresi);
                User users = new User();
                users.setName(adı.getText().toString());
                users.setSurname(soyadı.getText().toString());
                users.setAge(0);
                users.setEmail(eposta.getText().toString());
                users.setUsername(kad.getText().toString());
                users.setPassword(sifre.getText().toString());
                users.setGender(0);
                users.setGoal(0);
                users.setReactivity(0);
                users.setWeight(0);
                users.setHeight(0);
                userViewModel.insertUsers(users);
                Snackbar.make(view,"Kayıt başarılı",Snackbar.LENGTH_LONG).setAction("Action",null).show();


                navController.navigate(R.id.action_kayitEkran_to_cinsiyetEkran);
            }
        });
    }

}
