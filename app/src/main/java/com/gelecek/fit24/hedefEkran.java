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
import android.widget.CheckBox;


/**
 * A simple {@link Fragment} subclass.
 */
public class hedefEkran extends Fragment {
    Button bitir;
    CheckBox ver,form,al;
    int goal=0;
    ViewModel userViewModel;

    public hedefEkran() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_hedef_ekran, container, false);
        userViewModel = ViewModelProviders.of(this).get(ViewModel.class);
        bitir=view.findViewById(R.id.buttonbitir);
        ver=view.findViewById(R.id.checkBox);
        form=view.findViewById(R.id.checkBox2);
        al=view.findViewById(R.id.checkBox3);
        return  view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((MainActivity)getActivity()).showActionBar();
        final NavController navController = Navigation.findNavController(view);
        ver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            goal=1;
            }
        });
        form.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goal=2;
            }
        });
        al.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goal=3;
            }
        });
        bitir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppDatabase database = ((FitApplication)getActivity().getApplication()).getAppDatabase();
                final UserDao userDao = database.userDao();
                User user= userDao.getSonUser();
                updateClicked(user);
                navController.navigate(R.id.action_hedefEkran_to_hosgeldinEkrani);

            }
        });
    }
    public void updateClicked(User users) {
        users.setGoal(goal);
        userViewModel.updateUser(users);

    }
}

