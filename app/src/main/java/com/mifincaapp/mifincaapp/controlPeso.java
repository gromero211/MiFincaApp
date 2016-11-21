package com.mifincaapp.mifincaapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class controlPeso extends AppCompatActivity {
    public static final int FORM_KEY=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_peso);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        findViewById(R.id.buttonBuscarPeso).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                controlPeso.this.startActivity(new Intent(controlPeso.this, control_peso_buscar.class));
            }
        });

        findViewById(R.id.buttonEliminarPeso).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                controlPeso.this.startActivity(new Intent(controlPeso.this, control_peso_eliminar.class));
            }
        });

        findViewById(R.id.buttonEditarPeso).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                controlPeso.this.startActivity(new Intent(controlPeso.this, control_peso_editar.class));
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabControlPeso);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment= controlPeso_registrar.getInstance();
                mostrarFragment(fragment);
            }
        });
    }

    private void mostrarFragment(Fragment fragment) {
        FragmentManager fragmentManager= getSupportFragmentManager();
        FragmentTransaction trasaccion=fragmentManager.beginTransaction();
        trasaccion.replace(R.id.content_control_peso,fragment);
        trasaccion.commit();
    }

}
