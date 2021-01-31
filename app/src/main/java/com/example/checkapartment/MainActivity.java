package com.example.checkapartment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.fragment.NavHostFragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.checkapartment.databinding.ActivityMainBinding;


/*Trabajo Grupal

Jenifer Luengo
Alexis Leon
Jean Paul  */


public class MainActivity extends AppCompatActivity {

   private  ActivityMainBinding binding;
   int intentos = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.ETxUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        binding.btAcceso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mail = binding.ETxUser.getText().toString();

                String password = binding.ETxPassword.getText().toString();


                if (mail.equals("mail@mail.com")&& password.equals("123Pass")) {
                    passsecond();
                    Toast.makeText(MainActivity.this, "Clave Valida, Bienvenido", Toast.LENGTH_SHORT).show();

                } else {
                    contadorErrores();
                }
            }

        });
    }

    private void passsecond() {
        Intent passsecond = new Intent(MainActivity.this, SecondActivity.class);
        startActivity(passsecond);
    }

    private void contadorErrores(){

        if (intentos == 0){
                Toast.makeText(MainActivity.this, "A exedido el Maximo de intentos", Toast.LENGTH_SHORT).show();
                binding.btAcceso.setEnabled(false);

        }else{
            intentos --;
                Toast.makeText(MainActivity.this, "Clave Incorrecta, Queda(n) "+
                        intentos + " intento(s) ", Toast.LENGTH_SHORT).show();


        }

    }

}