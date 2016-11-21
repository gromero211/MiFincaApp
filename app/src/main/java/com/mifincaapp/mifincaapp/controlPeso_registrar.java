package com.mifincaapp.mifincaapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class controlPeso_registrar extends Fragment {

    // TODO: Rename and change types of parameters
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;
    public controlPeso_registrar() {

    }

    public static controlPeso_registrar getInstance(){
        controlPeso_registrar fragment=new controlPeso_registrar();
        return fragment;

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_control_peso_registrar,container,false);
        return view;

    }
}
