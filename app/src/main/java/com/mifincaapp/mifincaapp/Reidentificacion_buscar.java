package com.mifincaapp.mifincaapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class Reidentificacion_buscar extends Fragment {

    public Reidentificacion_buscar() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reidentificacion_buscar, container, false);
    }

    public static Reidentificacion_buscar getInstance(){
        Reidentificacion_buscar fragment=new Reidentificacion_buscar();
        return fragment;

    }
}
