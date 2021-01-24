package com.example.checkapartment.presenter;

import com.example.checkapartment.model.ContadorPuntos;

public class Presentador {

    private IViewPresenter viewPresenter;
    private ContadorPuntos model;

    public Presentador(IViewPresenter viewPresenter) {
        this.viewPresenter = viewPresenter;
        this.model = new ContadorPuntos();
    }

    public void verificadorValor(int puntajeObtenido){
        if (model.señaletica(puntajeObtenido).equals("RED")){
            viewPresenter.verificadorValor("#FFFFF", "RED");
        }else{
            viewPresenter.verificadorValor("##008f39", "GREEN");
        }
    }
}