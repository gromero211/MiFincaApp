package com.mifincaapp.mifincaapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class Reidentificacion_eliminar extends Fragment {

    public Reidentificacion_eliminar() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reidentificacion_eliminar, container, false);
    }
    public static Reidentificacion_eliminar getInstance(){
        Reidentificacion_eliminar fragment=new Reidentificacion_eliminar();
        return fragment;

    }


}
