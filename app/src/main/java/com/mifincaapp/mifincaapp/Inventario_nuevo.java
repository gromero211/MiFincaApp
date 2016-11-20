package com.mifincaapp.mifincaapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Inventario_nuevo.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Inventario_nuevo#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Inventario_nuevo extends Fragment {
    public Inventario_nuevo() {

    }

    public static Inventario_nuevo getInstance(){
        Inventario_nuevo fragment=new Inventario_nuevo();
        return fragment;

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_inventario_nuevo,container,false);
        return view;


    }
}
