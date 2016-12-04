package com.mifincaapp.mifincaapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Bajas extends AppCompatActivity {
    public static final int FORM_KEY=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bajas);
        //fragment listado
        Fragment fragment=Bajas_listado.getInstance();
        mostrarFragment(fragment);
    }
    private void mostrarFragment(Fragment fragment) {
        FragmentManager fragmentManager= getSupportFragmentManager();
        FragmentTransaction trasaccion=fragmentManager.beginTransaction();
        trasaccion.replace(R.id.contentBajas,fragment);
        trasaccion.commit();
    }
}
