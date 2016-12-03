package com.mifincaapp.mifincaapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import static android.app.Activity.RESULT_OK;


public class Control_reproductivo_nuevo extends Fragment implements View.OnClickListener{
    public static final int ACTIVITY_CODE = 1;
    public static final String DIAGNOSTICO_KEY = "diagnostico";
    public static final String ARETE_KEY = "arete";
    public static final String DETECCION_KEY = "deteccion";
    public static final String SEMENTAL_KEY = "semental";
    public static final String DESARROLLO_KEY = "desarrollo";
    public static final String PARTO_KEY = "parto";
    public static final String CRIAS_KEY = "crias";
    public static final String COMENTARIOS_KEY = "comentarios";

    View view;

    public Control_reproductivo_nuevo() {
        // Required empty public constructor
    }
    public static Control_reproductivo_nuevo getInstance(){
        Control_reproductivo_nuevo fragment=new Control_reproductivo_nuevo();
        return fragment;

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_control_reproductivo_nuevo, container, false);
    }
    private void finishWithResult() {

        String diagnostico,arete,deteccion,semental,parto,desarrollo,crias,comentarios;

        arete = ((EditText) view.findViewById(R.id.txtArete)).getText().toString();
        diagnostico = ((EditText) view.findViewById(R.id.txtFechaRegistrarPeso)).getText().toString();
        deteccion = ((EditText) view.findViewById(R.id.txtMetodo)).getText().toString();
        semental = ((EditText) view.findViewById(R.id.txtSemental)).getText().toString();
        parto = ((EditText) view.findViewById(R.id.txtFechaParto)).getText().toString();
        desarrollo = ((EditText) view.findViewById(R.id.txtParto)).getText().toString();
        crias = ((EditText) view.findViewById(R.id.txtCrias)).getText().toString();
        comentarios = ((EditText) view.findViewById(R.id.txtComentarios)).getText().toString();

        //categoria = ((EditText) view.findViewById(R.id.spnCategoria)).getText().toString();
        // String stringAge = ((EditText) findViewById(R.id.edad)).getText().toString();
        if (arete.length() > 0 && diagnostico.length() > 0) {

            Bundle data = new Bundle();
            data.putString(ARETE_KEY, arete);
            data.putString(DIAGNOSTICO_KEY, diagnostico);
            data.putString(DETECCION_KEY, deteccion);
            data.putString(SEMENTAL_KEY, semental);
            data.putString(PARTO_KEY, parto);
            data.putString(DESARROLLO_KEY, desarrollo);
            data.putString(CRIAS_KEY, crias);
            data.putString(COMENTARIOS_KEY, comentarios);
            Intent intent = new Intent();
            intent.putExtras(data);
            getActivity().setResult(RESULT_OK, intent);
            getActivity().finish();
        } else {
            Toast.makeText(getActivity(), R.string.require_fields, Toast.LENGTH_LONG).show();
        }
    }


    @Override
    public void onClick(View v) {

    }
}
