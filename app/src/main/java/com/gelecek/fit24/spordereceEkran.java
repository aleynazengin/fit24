package com.gelecek.fit24;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class spordereceEkran extends Fragment {
    Button bndevam;
    ViewModel userViewModel;
    RadioButton az,orta,çok;
    RadioGroup radioGroup;
    RadioButton radioButton;
    int sporDerece=0;
    public spordereceEkran() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_sporderece_ekran, container, false);
        userViewModel = ViewModelProviders.of(this).get(ViewModel.class);
        bndevam=view.findViewById(R.id.buttondevam3);
        radioGroup = view.findViewById(R.id.rdSpor);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((MainActivity)getActivity()).showActionBar();
        final NavController navController = Navigation.findNavController(view);
        bndevam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                radioButton = radioGroup.findViewById(selectedId);
                AppDatabase database = ((FitApplication)getActivity().getApplication()).getAppDatabase();
                final UserDao userDao = database.userDao();
                if (selectedId==R.id.radioButtonaz){
                    sporDerece=1;
                }
                if (selectedId==R.id.radioButtonorta){
                    sporDerece=2;
                }
                if (selectedId==R.id.radioButtoncok){
                    sporDerece=3;
                }
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

