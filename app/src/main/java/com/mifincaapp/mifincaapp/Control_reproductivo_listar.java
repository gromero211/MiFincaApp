package com.mifincaapp.mifincaapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.mifincaapp.mifincaapp.db.Db_Control;

import java.util.ArrayList;
import java.util.List;


public class Control_reproductivo_listar extends Fragment {
    View view;
    ListView lista;
    Db_Control db;
    SQLiteDatabase data;
    List<String> item = null;

    public Control_reproductivo_listar() {
        // Required empty public constructor

}
    public static Control_reproductivo_listar getInstance(){
        Control_reproductivo_listar fragment=new Control_reproductivo_listar();
        return fragment;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_control_reproductivo_listar, container, false);
        lista=(ListView)view.findViewById(R.id.reproduccionList);
        showInventario();


        return view;
    }
    public void showInventario()
    {
        db=new Db_Control(view.getContext());
        Cursor c= db.getNotes();
        item=new ArrayList<String>();
        String id="",fecha="",arete="",raza="";


        //recorremos los registros del objeto cursor C
        while (c.moveToNext()){
            id=c.getString(0);
            arete=c.getString(1);

            item.add(arete);
        }


        //crear el adapter de tipo list adapter
        ArrayAdapter<String> adaptador =
                new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_list_item_1, item);
        lista.setAdapter(adaptador);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                TextView tv1=(TextView)view.findViewById(R.id.textView11);
                String aret= (String) lista.getItemAtPosition(position);

                //Toast.makeText(getContext(),"Arete deleccionado: "+ aret, Toast.LENGTH_SHORT).show();
                Db_Control dbInventario = new Db_Control(getActivity());
                data = dbInventario.getWritableDatabase();

                //para eliminar
               // data.execSQL("DELETE FROM inventario WHERE arete='"+aret+"';");
                //para hacer el select (no copiar esta parte)
                Cursor cursor=data.rawQuery("SELECT * FROM Reg_Reproductivo WHERE arete='"+aret+"'",null);
                String datos="",i="",arete="",fecha="",metodo="",semental="",parto="",desarrollo="",crias="",comentario="";
                if (cursor.moveToFirst())
                {
                    i=cursor.getString(0);
                    arete=cursor.getString(1);
                    fecha= cursor.getString(2);
                    metodo=cursor.getString(3);
                    semental=cursor.getString(4);
                    parto=cursor.getString(5);
                    desarrollo=cursor.getString(6);
                    crias=cursor.getString(7);
                    comentario=cursor.getString(8);
                    datos=" Id: "+i+"\n Arete: "+aret+"\n Fecha de detección: "+fecha+"\n Método de parto: "+metodo+"\n Número de crías: "+crias;
                    //Toast.makeText(getContext(),datos, Toast.LENGTH_SHORT).show();
                    //alert
                    AlertDialog.Builder dialogo1 = new AlertDialog.Builder(getContext());
                    dialogo1.setTitle("Información");
                    dialogo1.setMessage(datos);
                    dialogo1.setCancelable(false);
                    dialogo1.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogo1, int id) {

                        }
                    });

                    dialogo1.show();
                }

            }
        });
    }

}
