package com.mifincaapp.mifincaapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link medicamento_guardar.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link medicamento_guardar#newInstance} factory method to
 * create an instance of this fragment.
 */
public class medicamento_guardar extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters

    public medicamento_guardar() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_medicamento_guardar, container, false);
    }
    public static medicamento_guardar getInstance(){
        medicamento_guardar fragment=new medicamento_guardar();
        return fragment;

    }
}
