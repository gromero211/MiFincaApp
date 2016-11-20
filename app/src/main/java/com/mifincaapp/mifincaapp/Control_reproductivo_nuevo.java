package com.mifincaapp.mifincaapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class Control_reproductivo_nuevo extends Fragment {


    public Control_reproductivo_nuevo() {
        // Required empty public constructor
    }
    public static Control_reproductivo_nuevo getInstance(){
        Control_reproductivo_nuevo fragment=new Control_reproductivo_nuevo();
        return fragment;

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_control_reproductivo_nuevo, container, false);
    }

}
