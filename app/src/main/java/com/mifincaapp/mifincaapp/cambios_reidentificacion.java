package com.mifincaapp.mifincaapp;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class cambios_reidentificacion extends Fragment {

    public cambios_reidentificacion() {

    }

    public static cambios_reidentificacion getInstance(){
        cambios_reidentificacion fragment=new cambios_reidentificacion();
        return fragment;

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_control_peso_registrar,container,false);
        return view;

    }
}
