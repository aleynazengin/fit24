package com.gelecek.fit24;

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

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class GirisEkran extends Fragment {
    Button girisyap;
    Boolean durum=false;
    EditText email,sifre;

    public GirisEkran() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_giris_ekran, container, false);
        girisyap=view.findViewById(R.id.buttongiris2);
        email=view.findViewById(R.id.editTextemail);
        sifre=view.findViewById(R.id.editTextsifre);
        return  view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((MainActivity)getActivity()).showActionBar();

        girisyap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkDataEntered();
                User users = new User();
                checkLogin(users);
                if(durum==true) {

                    final NavController navController = Navigation.findNavController(view);
                    navController.navigate(R.id.action_girisEkran_to_hosgeldinEkrani);
                }
            }
        });

    }
    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }
    void checkDataEntered(){
        if (isEmpty(email)) {
            Toast t = Toast.makeText(getActivity(), "Email boş bırakılamaz!", Toast.LENGTH_SHORT);
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
    void checkLogin(User users)
    {
        AppDatabase database = ((FitApplication)getActivity().getApplication()).getAppDatabase();
        final UserDao userDao = database.userDao();
        List<User> users1 = userDao.getLoginSorgum(email.getText().toString(),sifre.getText().toString());
        if (users1.size()>0){
            User user= userDao.getUser(email.getText().toString(),sifre.getText().toString());
            ((MainActivity)getActivity()).SetLoginUserId(user.Id);
            durum=true;


        }
        else{
            durum=false;
            Toast t = Toast.makeText(getActivity(), "Email veya şifre yanlış", Toast.LENGTH_SHORT);
            t.show();

        }

    }
}
