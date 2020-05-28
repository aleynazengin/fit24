package com.example.fit24;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class kalorilisteEkran extends Fragment {
    private KaloriViewModel mKaloriViewModel;
    public static final int NEW_KALORI_ACTIVITY_REQUEST_CODE = 1;
    public kalorilisteEkran() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=  inflater.inflate(R.layout.fragment_kaloriliste_ekran, container, false);

        AppDatabase database = ((FitApplication)getActivity().getApplication()).getAppDatabase();

        final UserDao userDao = database.userDao();
        StringBuilder builder = new StringBuilder();

        //List<User> users = userDao.getUsers();
        //for (int x = 0; x < users.size(); x++){
         //   builder.append("Ad: ").append(users.get(x).Username+"\n");
         //   builder.append("Soyad: ").append(users.get(x).Surname+"\n");
       // }
        //TextView text= (TextView)view.findViewById(R.id.textViewbilgiler);
       // text.setText(builder);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerview);
        final KaloriListAdapter adapter = new KaloriListAdapter(getActivity());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mKaloriViewModel = new ViewModelProvider(getActivity()).get(KaloriViewModel.class);
        mKaloriViewModel.getAllKalori().observe(getActivity(), new Observer<List<Kalori>>() {
            @Override
            public void onChanged(@Nullable final List<Kalori> kaloris) {
                for (Kalori kalori : kaloris) {
                    System.out.println(String.format("%s - %d", kalori.YemekAdi, kalori.Kalorisi));
                }
                // Update the cached copy of the words in the adapter.
                adapter.setWords(kaloris);
            }
        });

     return view;
    }



}
