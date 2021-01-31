package com.example.checkapartment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.checkapartment.databinding.FragmentSecondBinding;
import com.example.checkapartment.presenter.Presentador;

public class SecondFragment extends Fragment {
    private Presentador presentador;
    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState, int valueEstado, int sumavalueUnidad, int puntajeObtenido) {
        super.onViewCreated(view, savedInstanceState);
        binding = FragmentSecondBinding.inflate(getLayoutInflater());


        binding.checkGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                //presentador.verficadorValor(s.toString());
                int index = binding.radioGroup.indexOfChild(binding.radioGroup.findViewById(checkedId));


                int valueUnidad = 0;
                switch(checkedId){
                    case 1:
                        valueUnidad = +  10;
                        break;
                    case 2:
                        valueUnidad = + 20;
                        break;
                    case 3:
                        valueUnidad =  + 30;
                        break;
                    case 4:
                        valueUnidad =  + 40;
                        break;
                }
            int sumavalueUnidad = valueUnidad;
            }
        });
        binding.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int index = binding.radioGroup.indexOfChild(binding.radioGroup.findViewById(checkedId));


                int valueEstado = 0;
                switch(checkedId){
                    case 1:
                       valueEstado = 3;
                        break;
                    case 2:
                        valueEstado = 2;
                        break;
                    case 3:
                        valueEstado = 1;
                        break;
                }
                int puntajeObtenido = sumavalueUnidad * valueEstado;
            }
        });

        binding.txVPoints.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
           public void onTextChanged(CharSequence s, int start, int before, int count){
             presentador.verificadorValor(Integer.parseInt((String) s));

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
     binding.txVPoints.setText("Puntaje Obtenido " + puntajeObtenido);




     binding.BtEnviar.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto","correo@gmail.com", null));
             emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Puntaje obtenido ");
             //startActivity(Intent.createChooser(emailIntent,  getActivity().getString(R.string.)));
         }
     });
    }
    }



