package com.mifincaapp.mifincaapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.mifincaapp.mifincaapp.db.Db_Peso;

import java.util.ArrayList;
import java.util.List;

public class Peso_listado extends Fragment {
    View view;
    ListView lista;
    Db_Peso db;
    SQLiteDatabase data;
    List<String> item = null;
    TextView tv_inId, tv_inArete;
    public Peso_listado() {
        // Required empty public constructor
    }
    public static Peso_listado getInstance(){
        Peso_listado fragment=new Peso_listado();
        return fragment;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_peso_listado, container, false);
        lista=(ListView)view.findViewById(R.id.pesoList);
        showPeso();
        return view;
    }
    public void showPeso()
    {
        db=new Db_Peso(view.getContext());
        Cursor c= db.getNotes();
        item=new ArrayList<String>();
        String id="",fecha="",arete="",raza="";


        //recorremos los registros del objeto cursor C
        while (c.moveToNext()){
            id=c.getString(0);
            fecha=c.getString(1);
            arete=c.getString(1);
            raza=c.getString(3);
            item.add(arete);
        }


        //crear el adapter de tipo list adapter
        ArrayAdapter<String> adaptador =
                new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_list_item_1, item);
        lista.setAdapter(adaptador);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                String aret= (String) lista.getItemAtPosition(position);

                Toast.makeText(getContext(),"Arete seleccionado: "+ aret, Toast.LENGTH_SHORT).show();
                Db_Peso dbPeso = new Db_Peso(getActivity());
                data = dbPeso.getWritableDatabase();

                //para eliminar
                //data.execSQL("DELETE FROM inventario WHERE arete='"+aret+"';");
                //para hacer el select (no copiar esta parte)
                Cursor cursor=data.rawQuery("SELECT * FROM controlPeso WHERE arete='"+aret+"'",null);
                String i="",fecha="",arete="",edad="",raza="",peso="",datos="";
                if (cursor.moveToFirst()) {
                    i=cursor.getString(0);
                    fecha=cursor.getString(1);
                    arete=cursor.getString(2);
                    edad=cursor.getString(3);
                    raza=cursor.getString(4);
                    peso=cursor.getString(5);

                    datos=" Id: "+i+"\n Arete: "+arete+"\n Fecha de registro: "+fecha+"\n Edad: "+edad+"\n Peso: "+peso+"\n Raza: "+raza;
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
