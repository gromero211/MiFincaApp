package com.mifincaapp.mifincaapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.mifincaapp.mifincaapp.adapters.InventarioAdapter;
import com.mifincaapp.mifincaapp.db.Db_inventario;
import com.mifincaapp.mifincaapp.db.Reg_inventario;

import java.util.List;

import static com.mifincaapp.mifincaapp.Inventario_nuevo.ACTIVITY_CODE;

public class Inventario extends AppCompatActivity {
    public static final String TAG = Inventario.class.getName();
    public static final int FORM_KEY=1;

   // public static final String TAG = ListaConBusqueda.class.getName();

    Toolbar toolbar;
    Db_inventario dbHelper;
    FloatingActionButton fab;
    RecyclerView mRecyclerView;
    List<Reg_inventario> listPersona;
    InventarioAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventario);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabInventario);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment=Inventario_nuevo.getInstance();
                mostrarFragment(fragment);

            }
        });
//recyclerView


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

                //Intent intent=new Intent(Inventario.this, Inventario.class);
                //startActivityForResult(intent,Inventario.FORM_KEY);
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

//nuevos


    //
    public void onClick(View v) {
        Intent intent = new Intent(this, Inventario_nuevo.class);
        startActivityForResult(intent, ACTIVITY_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == Inventario_nuevo.ACTIVITY_CODE &&
                resultCode == RESULT_OK) {
            Reg_inventario inventario = new Reg_inventario();
            inventario.setFecha(data.getStringExtra(Inventario_nuevo.FECHA_KEY));
            inventario.setArete(data.getStringExtra(Inventario_nuevo.ARETE_KEY));
            inventario.setEdad(data.getStringExtra(Inventario_nuevo.EDAD_KEY));
            inventario.setCategoria(data.getStringExtra(Inventario_nuevo.CATEGORIA_KEY));
            inventario.setRaza(data.getStringExtra(Inventario_nuevo.RAZA_KEY));
            //persona.setEdad(data.getIntExtra(PersonActivity.AGE_KEY, 0));
            savePerson(inventario);
        }
    }

    private void savePerson(Reg_inventario inventario) {
        if (dbHelper.saveRow(inventario)) {
           // updateRecycler("");
        } else {
            Toast.makeText(this, R.string.error_on_save, Toast.LENGTH_LONG).show();
        }

    }

}
