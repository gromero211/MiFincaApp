package com.mifincaapp.mifincaapp;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mifincaapp.mifincaapp.db.Db_inventario;

import static android.app.Activity.RESULT_OK;

public class controlPeso_registrar extends Fragment implements View.OnClickListener{

    Button button;
    Button btnCancel;

    public static final int ACTIVITY_CODE = 1;
    public static final String FECHA_KEY = "fecha";
    public static final String ARETE_KEY = "arete";
    public static final String AGE_KEY = "edad";
    public static final String RAZA_KEY = "raza";
    public static final String PESO_KEY = "peso";
    View view;
    SQLiteDatabase db;

    public controlPeso_registrar() {
        // Required empty public constructor
    }

    public static Fragment getInstance() {
        controlPeso_registrar fragment=new controlPeso_registrar();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.fragment_control_peso_registrar,container,false);

        //abrir la base de datos en modo escritura
        Db_inventario dbInventario = new Db_inventario(getActivity());
        db = dbInventario.getWritableDatabase();

        //boton guardar
        button = (Button) view.findViewById(R.id.btnGuardarPeso);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validarVTerminar();
            }
        });
        // btnCancel = (Button) view.findViewById(R.id.btnCancel);
        // btnCancel.setOnClickListener(this);

        return view;
    }

    private void validarVTerminar() {
        EditText fechaRegPeso, arete, edad, raza, peso;

        fechaRegPeso=(EditText)view.findViewById(R.id.txtFechaRegistrarPeso);
        arete=(EditText)view.findViewById(R.id.txtArete);
        edad=(EditText)view.findViewById(R.id.txtEdad);
        raza=(EditText)view.findViewById(R.id.txtRaza);
        peso=(EditText)view.findViewById(R.id.txtPeso);


        db.execSQL("INSERT INTO controlPeso (fecha, arete, edad, raza, peso)" +
                " VALUES ('"+ fechaRegPeso.getText() + "', '" + arete.getText() + "', '" + edad.getText() + "', '" + raza.getText() + "', '" + peso.getText() + "')");
        db.close();

        Intent intent=new Intent(view.getContext(), controlPeso.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {

    }

    public class YourItemSelectedListener implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            String selected = parent.getItemAtPosition(pos).toString();
        }

        public void onNothingSelected(AdapterView parent) {
            // Do nothing.
        }
    }
    private void finishWithResult() {

        String fechaRegPeso, arete, edad, raza, peso;

        fechaRegPeso = ((EditText) view.findViewById(R.id.txtFechaRegistrarPeso)).getText().toString();
        arete = ((EditText) view.findViewById(R.id.txtArete)).getText().toString();
        edad = ((EditText) view.findViewById(R.id.txtEdad)).getText().toString();
        raza = ((EditText) view.findViewById(R.id.txtRaza)).getText().toString();
        peso = ((EditText) view.findViewById(R.id.txtPeso)).getText().toString();

        // String stringAge = ((EditText) findViewById(R.id.edad)).getText().toString();
        if (fechaRegPeso.length() > 0 && arete.length() > 0) {

            Bundle data = new Bundle();
            data.putString(FECHA_KEY, fechaRegPeso);
            data.putString(ARETE_KEY, arete);
            data.putString(AGE_KEY, edad);
            data.putString(RAZA_KEY, raza);
            data.putString(PESO_KEY, peso);
            Intent intent = new Intent();
            intent.putExtras(data);
            getActivity().setResult(RESULT_OK, intent);
            getActivity().finish();
        } else {
            Toast.makeText(getActivity(), R.string.require_fields, Toast.LENGTH_LONG).show();
        }
    }
}
