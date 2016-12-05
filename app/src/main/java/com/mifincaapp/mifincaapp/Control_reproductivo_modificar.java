package com.mifincaapp.mifincaapp;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.mifincaapp.mifincaapp.db.Db_Control;


public class Control_reproductivo_modificar extends Fragment {
    SQLiteDatabase data;
    View view;
    public Control_reproductivo_modificar() {

    }
    public static Control_reproductivo_modificar getInstance(){
        Control_reproductivo_modificar fragment=new Control_reproductivo_modificar();
        return fragment;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_control_reproductivo_modificar, container, false);
        return view;
    }
    public void modificarElementos(final String i, final String arete, final String fecha, final String metodo, final String semental, final String parto, final String desarrollo, final String crias, final String comentario)
    {

        EditText t1=(EditText)view.findViewById(R.id.tArete);
        EditText t2=(EditText)view.findViewById(R.id.tDiagnostico);
        EditText t3=(EditText)view.findViewById(R.id.tMetodo);
        EditText t4=(EditText)view.findViewById(R.id.tSemental);
        EditText t5=(EditText)view.findViewById(R.id.tFparto);
        EditText t6=(EditText)view.findViewById(R.id.tDesarrollo);
        EditText t7=(EditText)view.findViewById(R.id.tCrias);
        EditText t8=(EditText)view.findViewById(R.id.tComentarios);

        t1.setText(arete);
        t2.setText(fecha);
        t3.setText(metodo);
        t4.setText(semental);
        t5.setText(parto);
        t6.setText(desarrollo);
        t7.setText(crias);
        t8.setText(comentario);

        Button button=(Button)view.findViewById(R.id.btnModificarControl);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Db_Control dbInventario = new Db_Control(getActivity());
                data = dbInventario.getWritableDatabase();
                data.execSQL("UPDATE Reg_Reproductivo SET arete='"+arete+"', fecha_diagnostico='"+fecha+"', met_deteccion='"+
                        metodo+"', semental='"+semental+"', fec_parto='"+parto+"', des_parto='"+desarrollo+"'. no_crias='"+crias+"', comentarios='"+comentario+" WHERE _id='"+i+"'");
            }
        });


    }
}
