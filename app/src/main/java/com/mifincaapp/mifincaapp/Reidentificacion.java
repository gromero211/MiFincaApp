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
import com.mifincaapp.mifincaapp.adapters.ReidentificacionAdapter;
import com.mifincaapp.mifincaapp.db.Db_inventario;
import com.mifincaapp.mifincaapp.db.Db_reidentificacion;
import com.mifincaapp.mifincaapp.db.ListadoReidentificacion;
import com.mifincaapp.mifincaapp.db.Reg_inventario;
import com.mifincaapp.mifincaapp.db.Reg_reidentificacion;

import java.util.List;

import static com.mifincaapp.mifincaapp.Inventario_nuevo.ACTIVITY_CODE;

public class Reidentificacion extends AppCompatActivity {

    public static final String TAG = Reidentificacion.class.getName();
    public static final int FORM_KEY=1;

    Toolbar toolbar;
    Db_reidentificacion dbHelper;
    FloatingActionButton fab;
    RecyclerView mRecyclerView;
    List<Reg_reidentificacion> listPersona;
    ReidentificacionAdapter adapter;
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
//recyclerView
        Fragment fragment = ListadoReidentificacion.getInstance();
        mostrarFragment(fragment);

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

//nuevos


    //
    public void onClick(View v) {
        Intent intent = new Intent(this, Reidentificacion_nuevo.class);
        startActivityForResult(intent, ACTIVITY_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == Reidentificacion_nuevo.ACTIVITY_CODE &&
                resultCode == RESULT_OK) {
            Reg_reidentificacion reidentificacion = new Reg_reidentificacion();
            reidentificacion.setFecha(data.getStringExtra(Reidentificacion_nuevo.FECHA_KEY));
            reidentificacion.setAreteanterior(data.getStringExtra(Reidentificacion_nuevo.ARETEANTERIOR_KEY));
            reidentificacion.setAretenuevo(data.getStringExtra(Reidentificacion_nuevo.ARETENUEVO_KEY));
            reidentificacion.setMotivocambio(data.getStringExtra(Reidentificacion_nuevo.MOTIVOCAMBIO_KEY));

            //persona.setEdad(data.getIntExtra(PersonActivity.AGE_KEY, 0));
            savePerson(reidentificacion);
        }
    }

    private void savePerson(Reg_reidentificacion reidentificacion) {
        if (dbHelper.saveRow(reidentificacion)) {
            // updateRecycler("");
        } else {
            Toast.makeText(this, R.string.error_on_save, Toast.LENGTH_LONG).show();
        }

    }


}