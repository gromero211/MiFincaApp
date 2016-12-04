package com.mifincaapp.mifincaapp;

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
import android.app.AlertDialog;

import com.mifincaapp.mifincaapp.db.Db_inventario;

import java.util.ArrayList;
import java.util.List;


public class Bajas_listado extends Fragment {
    View view;
    ListView lista;
    Db_inventario db;
    SQLiteDatabase data;
    List<String> item = null;


    public Bajas_listado() {
        // Required empty public constructor
    }
    public static Bajas_listado getInstance(){
        Bajas_listado fragment=new Bajas_listado();
        return fragment;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_bajas_listado, container, false);
        lista=(ListView)view.findViewById(R.id.bajasList);
        showInventario();

        return view;
    }
    public void showInventario()
    {
        db=new Db_inventario(view.getContext());
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


                final String aret= (String) lista.getItemAtPosition(position);
                Db_inventario dbInventario = new Db_inventario(getActivity());
                data = dbInventario.getWritableDatabase();
                //aler
                AlertDialog.Builder dialogo1 = new AlertDialog.Builder(getContext());
                dialogo1.setTitle("Importante");
                dialogo1.setMessage("¿ Desea eliminar el registro seleccionado ?");
                dialogo1.setCancelable(false);
                dialogo1.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                        //para eliminar
                        data.execSQL("DELETE FROM inventario WHERE arete='"+aret+"';");
                    }
                });
                dialogo1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {

                    }
                });
                dialogo1.show();


                //para hacer el select (no copiar esta parte)
                //Cursor cursor=data.rawQuery("SELECT * FROM inventario WHERE arete='"+aret+"'",null);

            }
        });
    }


}
