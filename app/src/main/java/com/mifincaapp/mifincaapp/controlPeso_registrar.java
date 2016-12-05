package com.mifincaapp.mifincaapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.mifincaapp.mifincaapp.db.Db_Peso;

/**
 * Created by USUARIO on 03/12/2016.
 */

public class controlPeso_registrar extends Fragment implements View.OnClickListener{

    Button button;
    Button btnCancel;
    EditText tFecha,tArete,tEdad,tRaza,tPeso;

    public static final int ACTIVITY_CODE = 1;
    public static final String FECHA_KEY = "fecha";
    public static final String ARETE_KEY = "arete";
    public static final String EDAD_KEY = "edad";
    public static final String RAZA_KEY = "raza";
    public static final String PESO_KEY = "peso";
    View view;
    SQLiteDatabase db;

    public controlPeso_registrar() {

    }

    public static controlPeso_registrar getInstance(){
        controlPeso_registrar fragment=new controlPeso_registrar();
        return fragment;

    }



    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_control_peso_registrar,container,false);


        //abrir la base de datos en modo escritura
        Db_Peso dbInventario = new Db_Peso(getActivity());
        db = dbInventario.getWritableDatabase();

        //boton guardar
        button = (Button) view.findViewById(R.id.btnGuardarPeso);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //alert
                AlertDialog.Builder dialogo1 = new AlertDialog.Builder(getContext());
                dialogo1.setTitle("Confirmación");
                dialogo1.setMessage("¿ Desea guardar los datos ?");
                dialogo1.setCancelable(false);
                dialogo1.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                        validarVTerminar();
                    }
                });
                dialogo1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                        Intent intent=new Intent(view.getContext(),controlPeso.class);
                        startActivity(intent);
                    }
                });
                dialogo1.show();
            }
        });

        return view;

    }

    private void validarVTerminar() {
        EditText fecha, arete, edad, raza, peso;

        fecha=(EditText)view.findViewById(R.id.txtFechaRegistrarPeso);
        arete=(EditText)view.findViewById(R.id.txtArete3);
        edad=(EditText)view.findViewById(R.id.txtEdadPeso);
        raza=(EditText)view.findViewById(R.id.txtRazaPeso);
        peso=(EditText)view.findViewById(R.id.txtPeso);


        db.execSQL("INSERT INTO controlPeso (fecha, arete, edad, raza, peso)" +
                " VALUES ('"+ fecha.getText() + "', '" + arete.getText() + "', '" + edad.getText() + "', '" + raza.getText() + "', '" + peso.getText() +"')");
        //db.close();
        Intent intent=new Intent(view.getContext(),controlPeso.class);
        startActivity(intent);
        //getActivity().finish();

    }


    @Override
    public void onClick(View v) {

    }
}
