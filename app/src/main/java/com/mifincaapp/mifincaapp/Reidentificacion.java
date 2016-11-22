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

public class Reidentificacion extends AppCompatActivity {
    public static final int FORM_KEY=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reidentificacion);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabReidentificacion);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment=Reidentificacion_nuevo.getInstance();
                mostrarFragment(fragment);
            }
        });
    }
    private void mostrarFragment(Fragment fragment) {
        FragmentManager fragmentManager= getSupportFragmentManager();
        FragmentTransaction trasaccion=fragmentManager.beginTransaction();
        trasaccion.replace(R.id.content_reidentificacion,fragment);
        trasaccion.commit();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_reidentificacion, menu);
        MenuItem item = menu.findItem(R.id.btnEliminarReidentificacion);
        item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Fragment fragment=Reidentificacion_eliminar.getInstance();
                mostrarFragment(fragment);

                //Intent intent=new Intent(Inventario.this, Inventario.class);
                //startActivityForResult(intent,Inventario.FORM_KEY);
                return true;
            }

        });

        MenuItem item2 = menu.findItem(R.id.btnBuscarReidentificacion);
        item2.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Fragment fragment=Reidentificacion_buscar.getInstance();
                mostrarFragment(fragment);
                return true;
            }
        });
        return true;
    }

}
