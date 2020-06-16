package com.gelecek.fit24;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class splashEkran extends Fragment {
    private ImageView logo;
    private TextView dogru,spor,form;
    private static int splashTimeout= 5000;
    public splashEkran() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_splash_ekran, container, false);
        logo=view.findViewById(R.id.imageViewlogo);
        dogru=view.findViewById(R.id.textViewdogru);
        form=view.findViewById(R.id.textViewform);
        spor=view.findViewById(R.id.textViewspor);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final NavController navController = Navigation.findNavController(view);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                navController.navigate(R.id.action_anaekranagit);

            }
        },splashTimeout);
        Animation myanim= AnimationUtils.loadAnimation(getActivity(),R.anim.mysplashanimation);
        logo.startAnimation(myanim);
        dogru.startAnimation(myanim);
        form.startAnimation(myanim);
        spor.startAnimation(myanim);

    }
}
