package com.example.checkapartment.model;

public class ContadorPuntos {

    public boolean verificadorvalor(int puntajeObtenido) {

        return puntajeObtenido < 130;
    }


    public String señaletica(int puntajeObtenido) {


        if (verificadorvalor(puntajeObtenido)) {
            return "RED";
        } else {
                return "GREEN";
            }

        }
    }



