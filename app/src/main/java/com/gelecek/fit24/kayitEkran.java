package com.gelecek.fit24;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class kayitEkran extends Fragment {
    Button kayitol;
    ViewModel userViewModel;
    EditText adı,soyadı,eposta,sifre;
    Boolean durum=false;
    Boolean durum2=false;


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
        adı = view.findViewById(R.id.editTextadı);
        soyadı = view.findViewById(R.id.editTextsoyadı);
        eposta = view.findViewById(R.id.editTextepostası);
        sifre = view.findViewById(R.id.editTextsifresi);


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((MainActivity)getActivity()).showActionBar();

        kayitol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                checkDataEntered();
                User users = new User();
                checkUnique(users);
                if (durum==true && durum2==true) {

                    users.setName(adı.getText().toString());
                    users.setSurname(soyadı.getText().toString());
                    users.setAge(0);
                    users.setEmail(eposta.getText().toString());
                    users.setPassword(sifre.getText().toString());
                    users.setGender(0);
                    users.setGoal(0);
                    users.setReactivity(0);
                    users.setWeight(0);
                    users.setHeight(0);

                    userViewModel.insertUsers(users);
                    Snackbar.make(view, "Kayıt başarılı", Snackbar.LENGTH_LONG).setAction("Action", null).show();

                    final NavController navController = Navigation.findNavController(view);
                    AppDatabase database = ((FitApplication)getActivity().getApplication()).getAppDatabase();
                    final UserDao userDao = database.userDao();
                    User user= userDao.getSonUser();
                    ((MainActivity)getActivity()).SetLoginUserId(user.Id);
                    navController.navigate(R.id.action_kayitEkran_to_cinsiyetEkran);
                }
            }
        });
    }
    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }
    boolean isEmail(EditText text) {
        CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }
    void checkDataEntered(){
        if (isEmpty(adı)) {
            Toast t = Toast.makeText(getActivity(), "İsim boş bırakılamaz!", Toast.LENGTH_SHORT);
            t.show();

        }
        else if (isEmpty(soyadı)) {
            soyadı.setError("Soyad boş bırakılamaz!");

        }

        else if (isEmpty(sifre)) {
            sifre.setError("Şifre boş bırakılamaz!");

        }
        else if (isEmail(eposta) == false) {
            eposta.setError("Geçerli bir eposta adresi giriniz!");

        }
        else if (sifre.length()<5)
        {

            Toast t = Toast.makeText(getActivity(), "Şifre 6 karakterden az olamaz !", Toast.LENGTH_SHORT);
            t.show();
        }
        else{
            durum=true;
        }


    }
    void checkUnique(User users)
    {
        AppDatabase database = ((FitApplication)getActivity().getApplication()).getAppDatabase();
        final UserDao userDao = database.userDao();
        List<User> users1 = userDao.getSorgum(eposta.getText().toString());
       if (users1.size()>0){
           Toast t = Toast.makeText(getActivity(), "Bu e-posta daha önceden kullanılmış!", Toast.LENGTH_SHORT);
           t.show();
           durum2=false;

       }
       else{
           durum2=true;

       }

    }


}
