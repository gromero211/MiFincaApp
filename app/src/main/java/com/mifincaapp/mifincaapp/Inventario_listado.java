package com.mifincaapp.mifincaapp;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.mifincaapp.mifincaapp.db.Db_inventario;

import java.util.ArrayList;
import java.util.List;


public class Inventario_listado extends Fragment {
    View view;
    ListView lista;
    Db_inventario db;
    List<String> item = null;
    public Inventario_listado() {
        // Required empty public constructor
    }
    public static Inventario_listado getInstance(){
        Inventario_listado fragment=new Inventario_listado();
        return fragment;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_inventario_listado, container, false);
        lista=(ListView)view.findViewById(R.id.inventarioList);
        showInventario();
        return view;
    }
    public void showInventario()
    {
        db=new Db_inventario(view.getContext());
        Cursor c= db.getNotes();
        item=new ArrayList<String>();
        String fecha="",edad="",raza="";


            //recorremos los registros del objeto cursor C
           while (c.moveToNext()){
                fecha=c.getString(0);
                edad=c.getString(1);
                raza=c.getString(2);
                item.add(fecha + " " + edad + " " + raza);
            }


        //crear el adapter de tipo list adapter
        ArrayAdapter<String> adaptador =
                new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_list_item_1, item);
        lista.setAdapter(adaptador);
    }


}
