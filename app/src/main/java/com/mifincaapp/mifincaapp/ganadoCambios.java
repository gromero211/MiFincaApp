package com.mifincaapp.mifincaapp;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class ganadoCambios extends AppCompatActivity {
    public static final int FORM_KEY=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ganado_cambios);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarGanadoCambios);
        setSupportActionBar(toolbar);

        findViewById(R.id.buttonReidentificacion).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                ganadoCambios.this.startActivity(new Intent(ganadoCambios.this, cambios_reidentificacion.class));
            }
        });

        findViewById(R.id.buttonBajas).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                ganadoCambios.this.startActivity(new Intent(ganadoCambios.this, cambiosBajas.class));
            }
        });

    }

    /*private void mostrarFragment(Fragment fragment) {
        FragmentManager fragmentManager= getSupportFragmentManager();
        FragmentTransaction trasaccion=fragmentManager.beginTransaction();
        trasaccion.replace(R.id.content_control_peso,fragment);
        trasaccion.commit();
    }*/
}
