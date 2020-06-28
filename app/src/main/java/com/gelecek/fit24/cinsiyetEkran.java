package com.gelecek.fit24;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class cinsiyetEkran extends Fragment {
    Button btngec,btndevam;
    ImageView imgkadın,imgerkek;
    ViewModel userViewModel;
    int cinsiyet=0;

    public cinsiyetEkran() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_cinsiyet_ekran, container, false);
        userViewModel = ViewModelProviders.of(this).get(ViewModel.class);
        btngec=view.findViewById(R.id.buttongec);
        btndevam=view.findViewById(R.id.buttondevam);
        imgerkek=view.findViewById(R.id.imageViewerkek);
        imgkadın=view.findViewById(R.id.imageViewkadın);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((MainActivity)getActivity()).showActionBar();
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Üye Bilgileri");

        final NavController navController = Navigation.findNavController(view);
        imgerkek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgerkek.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.siyah));
                imgkadın.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.background));
                cinsiyet=1;
            }
        });
        imgkadın.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgkadın.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.siyah)); //kadın seçildiyse arkaplan siyah
                imgerkek.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.background));
                cinsiyet=2;
            }
        });
        btngec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_cinsiyetEkran_to_hosgeldinEkrani);
            }
        });
        btndevam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cinsiyet==0)
                {
                    Toast t = Toast.makeText(getActivity(), "Lütfen cinsiyet seçiniz.", Toast.LENGTH_SHORT);
                    t.show();
                }
                else{
                    AppDatabase database = ((FitApplication)getActivity().getApplication()).getAppDatabase();
                    final UserDao userDao = database.userDao();

                    User user= userDao.getSonUser();
                    updateClicked(user);
                    navController.navigate(R.id.action_cinsiyetEkran_to_bilgiEkranim);
                }

            }
        });
    }


    public void updateClicked(User user) {
        user.setGender(cinsiyet);
        userViewModel.updateUser(user);

    }
}
