package com.mifincaapp.mifincaapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.app.Activity.RESULT_OK;


public class Reidentificacion_nuevo extends Fragment implements View.OnClickListener {

    Button button;
    Button btnCancel;
    RecyclerView mRecyclerView;
    public static final int ACTIVITY_CODE = 1;
    public static final String FECHA_KEY = "fecha";
    public static final String ARETEANTERIOR_KEY = "areteanterior";
    public static final String ARETENUEVO_KEY = "aretenuevo";
    public static final String MOTIVOCAMBIO_KEY = "motivocambio";
    public String cat;
    public String raz;
    View view;

    public Reidentificacion_nuevo() {
        // Required empty public constructor
    }

    public static Fragment getInstance() {
        Reidentificacion_nuevo fragment=new Reidentificacion_nuevo();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.fragment_reidentificacion_nuevo,container,false);

        //boton guardar
        button = (Button) view.findViewById(R.id.btnGuardarNuevoRei);
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

        String fecha,areteanterior,aretenuevo,motivocambio;

        fecha = ((EditText) view.findViewById(R.id.txtFecha)).getText().toString();
        areteanterior = ((EditText) view.findViewById(R.id.txtAreteanterior)).getText().toString();
        aretenuevo = ((EditText) view.findViewById(R.id.txtAretenuevo)).getText().toString();
       // categoria=cat;
        motivocambio = cat;
        // String stringAge = ((EditText) findViewById(R.id.edad)).getText().toString();
        if (fecha.length() > 0 && aretenuevo.length() > 0) {

            Bundle data = new Bundle();
            data.putString(FECHA_KEY, fecha);
            data.putString(ARETEANTERIOR_KEY, areteanterior);
            data.putString(ARETENUEVO_KEY, aretenuevo);
            data.putString(MOTIVOCAMBIO_KEY, motivocambio);
            Intent intent = new Intent();
            intent.putExtras(data);
            getActivity().setResult(RESULT_OK, intent);
            getActivity().finish();
        } else {
            Toast.makeText(getActivity(), R.string.require_fields, Toast.LENGTH_LONG).show();
        }
    }
}
