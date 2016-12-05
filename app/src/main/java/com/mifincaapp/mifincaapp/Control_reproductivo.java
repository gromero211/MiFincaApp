package com.mifincaapp.mifincaapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class Control_reproductivo extends AppCompatActivity {
    public static final int FORM_KEY=1;
    public static final int ACTIVITY_CODE = 1;

    public static final String TAG = Control_reproductivo.class.getName();

    View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_reproductivo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //control reproductivo listado
        Fragment fragment=Control_reproductivo_listar.getInstance();
        mostrarFragment(fragment);

//nuevo


        //initList();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabReproductivo);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                //        .setAction("Action", null).show();
                Fragment fragment=Control_reproductivo_nuevo.getInstance();
                mostrarFragment(fragment);
            }
        });
    }
    private void mostrarFragment(Fragment fragment) {
        FragmentManager fragmentManager= getSupportFragmentManager();
        FragmentTransaction trasaccion=fragmentManager.beginTransaction();
        trasaccion.replace(R.id.cReproductivo,fragment);
        trasaccion.commit();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_reproductivo, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.btnMmodificar:
                Fragment fragment=Control_reproductivo_modificar.getInstance();
                mostrarFragment(fragment);
                return true;
            case R.id.btnEliminarReg:
                Fragment fragment1=Control_reproductivo_eliminar.getInstance();
                mostrarFragment(fragment1);
                return true;
            case R.id.btnHomeReproductivo:
                Intent intent=new Intent(this,MainActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }




    public void onClick(View v) {
        Intent intent = new Intent(this, Control_reproductivo.class);
        startActivityForResult(intent, Control_reproductivo.ACTIVITY_CODE);
    }




}
