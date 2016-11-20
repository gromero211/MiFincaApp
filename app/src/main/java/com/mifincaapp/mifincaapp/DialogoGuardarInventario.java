package com.mifincaapp.mifincaapp;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

/**
 * Created by GARF on 20/11/2016.
 */

public class DialogoGuardarInventario  extends DialogFragment{
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
            AlertDialog.Builder ventana=new AlertDialog.Builder(getActivity());
            ventana.setMessage("¿Desea Guardar los Datos?")
                .setTitle("Guardar")
                .setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                 @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getActivity() ,"Guardado",Toast.LENGTH_LONG).show();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(getActivity(),"Cancelado",Toast.LENGTH_LONG).show();
                }
            });

            return ventana.create();
    }
}
