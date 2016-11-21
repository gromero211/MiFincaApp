package com.mifincaapp.mifincaapp;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class cambiosBajas extends Fragment {

    public cambiosBajas() {

    }

    public static cambiosBajas getInstance(){
        cambiosBajas fragment=new cambiosBajas();
        return fragment;

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_cambios_bajas,container,false);
        return view;

    }
}
