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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;


/**
 * A simple {@link Fragment} subclass.
 */
public class bilgiEkranim extends Fragment {
    Button btndevamet;
    ViewModel userViewModel;
    int boy=0;
    int kilo=0;

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
        Spinner spinner1=view.findViewById(R.id.spinner);
        Spinner spinner2=view.findViewById(R.id.spinner2);
        String[]value={"140 cm","141 cm","142 cm","143 cm","144 cm","145 cm","146 cm","147 cm",
                "148 cm","149 cm","150 cm","151 cm","152 cm","153 cm","154 cm","155 cm","156 cm","157 cm","158cm",
                "159 cm","160 cm","161 cm","162 cm","163 cm","164 cm","165 cm","166 cm","167 cm","168cm",
                "169 cm","170 cm","171 cm","172 cm","173 cm","174 cm","175 cm","176 cm","177 cm","178cm",
                "179 cm","180 cm","181 cm","182 cm","183 cm","184 cm","185 cm","186 cm","187 cm","188cm","189cm","200cm", "210cm"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_dropdown_item,value);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);

        String[]value2={"36 kg","37kg","38kg","39kg","40kg","41kg","42kg","43kg","44kg","45kg","46kg",
                "47kg","48kg","49kg","50kg","51kg","52kg","53kg","54kg","55kg","56kg",
                "57kg","58kg","59kg","60kg","61kg","62kg","63kg","64kg","65kg","66kg",
                "67kg","68kg","69kg","70kg","71kg","72kg","73kg","74kg","75kg","76kg",
                "77kg","78kg","79kg","80kg","81kg","82kg","83kg","84kg","85kg","86kg",
                "87kg","88kg","89kg","90kg","91kg","92kg","93kg","94kg","95kg","96kg",
                "97kg","98kg","99kg","100kg","101kg","102kg","103kg","104kg","105kg","106kg",
                "107kg","108kg","109kg","110kg","111kg","112kg","113kg","114kg","115kg","116kg","117kg","118kg","119kg","120kg"

        };
         ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_dropdown_item,value2);
         adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final NavController navController = Navigation.findNavController(view);
        btndevamet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_bilgiEkranim_to_spordereceEkran);

            }
        });
    }
}
