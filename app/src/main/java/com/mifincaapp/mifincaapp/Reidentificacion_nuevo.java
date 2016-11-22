package com.mifincaapp.mifincaapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class Reidentificacion_nuevo extends Fragment {


    public Reidentificacion_nuevo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reidentificacion_nuevo, container, false);
    }
    public static Reidentificacion_nuevo getInstance(){
        Reidentificacion_nuevo fragment=new Reidentificacion_nuevo();
        return fragment;

    }

}
