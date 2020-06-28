package com.gelecek.fit24;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class bilgiEkranim extends Fragment {
    Button btndevamet;
    ViewModel userViewModel;
    int boy=0;
    int kilo=0,yas=0;
    EditText age;
    String value;
    Boolean durum=false;

    public bilgiEkranim() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bilgi_ekranim, container, false);
        userViewModel = ViewModelProviders.of(this).get(ViewModel.class);
        btndevamet= view.findViewById(R.id.buttondevamet);
        age=view.findViewById(R.id.editTextyas);
        Spinner spinner1=view.findViewById(R.id.spinner);
        Spinner spinner2=view.findViewById(R.id.spinner2);
        final String[] heightvalue={"140 cm","141 cm","142 cm","143 cm","144 cm","145 cm","146 cm","147 cm",
                "148 cm","149 cm","150 cm","151 cm","152 cm","153 cm","154 cm","155 cm","156 cm","157 cm","158cm",
                "159 cm","160 cm","161 cm","162 cm","163 cm","164 cm","165 cm","166 cm","167 cm","168cm",
                "169 cm","170 cm","171 cm","172 cm","173 cm","174 cm","175 cm","176 cm","177 cm","178cm",
                "179 cm","180 cm","181 cm","182 cm","183 cm","184 cm","185 cm","186 cm","187 cm","188 cm","189 cm","200 cm", "210 cm"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_dropdown_item,heightvalue);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String uzunluk= heightvalue[position];
                String uzunlukNoCm= uzunluk.replace(" cm","");
                boy= Integer.parseInt(uzunlukNoCm);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

       final String[]weightvalue={"36kg","37kg","38kg","39kg","40kg","41kg","42kg","43kg","44kg","45kg","46kg",
                "47kg","48kg","49kg","50kg","51kg","52kg","53kg","54kg","55kg","56kg",
                "57kg","58kg","59kg","60kg","61kg","62kg","63kg","64kg","65kg","66kg",
                "67kg","68kg","69kg","70kg","71kg","72kg","73kg","74kg","75kg","76kg",
                "77kg","78kg","79kg","80kg","81kg","82kg","83kg","84kg","85kg","86kg",
                "87kg","88kg","89kg","90kg","91kg","92kg","93kg","94kg","95kg","96kg",
                "97kg","98kg","99kg","100kg","101kg","102kg","103kg","104kg","105kg","106kg",
                "107kg","108kg","109kg","110kg","111kg","112kg","113kg","114kg","115kg","116kg","117kg","118kg","119kg","120kg"

        };
         ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_dropdown_item,weightvalue);
         adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String agirlik= weightvalue[position];
                String agirlikNoKg= agirlik.replace("kg","");
                kilo= Integer.parseInt(agirlikNoKg);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((MainActivity)getActivity()).showActionBar();
        final NavController navController = Navigation.findNavController(view);


        btndevamet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkDataEntered();
                if(durum==true) {

                    value = age.getText().toString();
                    yas = Integer.parseInt(value);
                    AppDatabase database = ((FitApplication) getActivity().getApplication()).getAppDatabase();
                    final UserDao userDao = database.userDao();
                    User user = userDao.getSonUser();
                    updateClicked(user);
                    navController.navigate(R.id.action_bilgiEkranim_to_spordereceEkran);
                }
            }
        });
    }
    public void updateClicked(User user) {
        user.setHeight(boy);
        user.setWeight(kilo);
        user.setAge(yas);
        userViewModel.updateUser(user);

    }
    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }
    void checkDataEntered() {
        if (isEmpty(age)) {
            Toast t = Toast.makeText(getActivity(), "Lütfen yaşınızı giriniz!", Toast.LENGTH_SHORT);
            t.show();

        }
        else{
            durum=true;
        }
    }
}
