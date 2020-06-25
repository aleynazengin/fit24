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
import android.widget.Button;
import android.widget.RadioButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class spordereceEkran extends Fragment {
    Button bndevam;
    ViewModel userViewModel;
    RadioButton az,orta,çok;
    int sporDerece=0;
    public spordereceEkran() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_sporderece_ekran, container, false);

        bndevam=view.findViewById(R.id.buttondevam3);
        az=view.findViewById(R.id.radioButton);
        orta=view.findViewById(R.id.radioButton2);
        çok=view.findViewById(R.id.radioButton3);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((MainActivity)getActivity()).showActionBar();
        final NavController navController = Navigation.findNavController(view);

        az.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sporDerece=1;
            }
        });
        orta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sporDerece=2;
            }
        });
        çok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sporDerece=3;
            }
        });

        bndevam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppDatabase database = ((FitApplication)getActivity().getApplication()).getAppDatabase();
                final UserDao userDao = database.userDao();
                User user= userDao.getSonUser();
                updateClicked(user);
                navController.navigate(R.id.action_spordereceEkran_to_hedefEkran);

            }
        });
    }
    public void updateClicked(User user) {
        user.setReactivity(sporDerece);
        userViewModel.updateUser(user);

    }
}

