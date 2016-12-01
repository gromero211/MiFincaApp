package com.mifincaapp.mifincaapp;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.mifincaapp.mifincaapp.db.Db_inventario;

import static com.mifincaapp.mifincaapp.R.array.raza;


public class Inventario_nuevo extends Fragment implements View.OnClickListener {
    Button button;
    Button btnCancel;
    EditText tFecha,tArete,tEdad,tCategoria,tRaza;
    RecyclerView mRecyclerView;
    public static final int ACTIVITY_CODE = 1;
    public static final String FECHA_KEY = "fecha";
    public static final String ARETE_KEY = "arete";
    public static final String EDAD_KEY = "edad";
    public static final String CATEGORIA_KEY = "categoria";
    public static final String RAZA_KEY = "raza";
    public String cat;
    public String raz;
    View view;
    SQLiteDatabase db;

    public Inventario_nuevo() {

    }

    public static Inventario_nuevo getInstance(){
        Inventario_nuevo fragment=new Inventario_nuevo();
        return fragment;

    }



    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_inventario_nuevo,container,false);

        Spinner spinner = (Spinner) view.findViewById(R.id.spnCategoria);

        //abrir la base de datos en modo escritura
        Db_inventario dbInventario = new Db_inventario(getActivity());
        db = dbInventario.getWritableDatabase();

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.categoriasNuevoInventario, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                cat = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Spinner spinner1 = (Spinner) view.findViewById(R.id.spnRaza);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(getActivity(),
                raza, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                raz= parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //boton guardar
        button = (Button) view.findViewById(R.id.btnGuardarNuevo);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validarVTerminar();
            }
        });

        return view;



    }

    private void validarVTerminar() {
        EditText fecha,arete,edad;//categoria,raza;
        String categoria,raza;//fecha,arete,edad,
        categoria=cat;
        raza=raz;
        fecha=(EditText)view.findViewById(R.id.txtFecha);
        arete=(EditText)view.findViewById(R.id.txtArete);
        edad=(EditText)view.findViewById(R.id.txtEdad);


        db.execSQL("INSERT INTO inventario (fecha, arete, edad, categoria, raza)" +
                    "VALUES ('"+ fecha.getText() + "', '" + arete.getText() + "', '" + edad.getText() + "', '" + categoria + "', '" + raza +"')");
        db.close();

        getActivity().finish();

    }


    @Override
    public void onClick(View v) {

    }
}
