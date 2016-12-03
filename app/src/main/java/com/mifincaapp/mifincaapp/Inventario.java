package com.mifincaapp.mifincaapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Inventario extends AppCompatActivity{
    public static final String TAG = Inventario.class.getName();
    public static final int FORM_KEY=1;



    public Inventario() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventario);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Fragment fragment=Inventario_listado.getInstance();
        mostrarFragment(fragment);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabInventario);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Fragment fragment=Inventario_nuevo.getInstance();
                mostrarFragment(fragment);
            }
        });

    }

    private void mostrarFragment(Fragment fragment) {
        FragmentManager fragmentManager= getSupportFragmentManager();
        FragmentTransaction trasaccion=fragmentManager.beginTransaction();
        trasaccion.replace(R.id.content,fragment);
        trasaccion.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_inventario, menu);
        MenuItem item = menu.findItem(R.id.btnEliminarInventario);
        item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Fragment fragment=Inventario_eliminar.getInstance();
                mostrarFragment(fragment);
                return true;
            }

        });

        MenuItem item2 = menu.findItem(R.id.btnBuscarInventario);
        item2.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Fragment fragment=Inventario_buscar.getInstance();
                mostrarFragment(fragment);
                return true;
            }
        });
        return true;
    }

}
