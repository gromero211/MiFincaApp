package com.mifincaapp.mifincaapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.mifincaapp.mifincaapp.db.Db_Control;


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
    SQLiteDatabase db;
    View view;
    Button button;

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
        view=inflater.inflate(R.layout.fragment_control_reproductivo_nuevo, container, false);

        //abrir la base de datos en modo escritura
        Db_Control dbInventario = new Db_Control(getActivity());
        db = dbInventario.getWritableDatabase();

        //boton guardar
        button = (Button) view.findViewById(R.id.btnGuardarReproductivo);
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



    @Override
    public void onClick(View v) {

    }
    private void validarVTerminar() {
        EditText arete, fecha,diagnostico,metodo,semental,fParto,dParto, crias,comentarios;

        arete=(EditText)view.findViewById(R.id.txtArete3);
        fecha=(EditText)view.findViewById(R.id.txtFechaDiagnostico);
        metodo=(EditText)view.findViewById(R.id.txtMetodo);
        semental=(EditText)view.findViewById(R.id.txtSemental);
        fParto=(EditText)view.findViewById(R.id.txtFechaParto);
        dParto=(EditText)view.findViewById(R.id.txtParto);
        crias=(EditText)view.findViewById(R.id.txtCrias);
        comentarios=(EditText)view.findViewById(R.id.txtComentarios);


        db.execSQL("INSERT INTO Reg_Reproductivo (arete,fecha_diagnostico,met_deteccion,semental,fec_parto,des_parto,no_crias,comentarios)" +
                " VALUES ('"+ arete.getText() + "', '" + fecha.getText() + "', '" + metodo.getText() + "', '" + semental.getText() + "', '" + fParto.getText() + "', '" + dParto.getText()+ "', '" + crias.getText()+ "', '" + comentarios.getText() + "')");
        //db.close();
        Intent intent=new Intent(view.getContext(),Control_reproductivo.class);
        startActivity(intent);
        //getActivity().finish();

    }
}
