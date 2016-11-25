package com.mifincaapp.mifincaapp;

import android.content.Intent;
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
import android.widget.Toast;

import static android.app.Activity.RESULT_OK;


public class Inventario_nuevo extends Fragment {
    Button button;
    Button btnCancel;
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
                R.array.raza, android.R.layout.simple_spinner_item);
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
                finishWithResult();
            }
        });
       // btnCancel = (Button) view.findViewById(R.id.btnCancel);
       // btnCancel.setOnClickListener(this);


        return view;



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

        String fecha,arete,edad,categoria,raza;

        fecha = ((EditText) view.findViewById(R.id.txtFecha)).getText().toString();
        arete = ((EditText) view.findViewById(R.id.txtArete)).getText().toString();
        edad = ((EditText) view.findViewById(R.id.txtEdad)).getText().toString();
        categoria=cat;
        raza=raz;
        //categoria = ((EditText) view.findViewById(R.id.spnCategoria)).getText().toString();
       // String stringAge = ((EditText) findViewById(R.id.edad)).getText().toString();
        if (fecha.length() > 0 && edad.length() > 0) {

            Bundle data = new Bundle();
            data.putString(FECHA_KEY, fecha);
            data.putString(ARETE_KEY, arete);
            data.putString(EDAD_KEY, edad);
            data.putString(CATEGORIA_KEY, categoria);
            data.putString(RAZA_KEY, raza);
            Intent intent = new Intent();
            intent.putExtras(data);
            getActivity().setResult(RESULT_OK, intent);
            getActivity().finish();
        } else {
            Toast.makeText(getActivity(), R.string.require_fields, Toast.LENGTH_LONG).show();
        }
    }

}
