package com.mifincaapp.mifincaapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
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

import com.mifincaapp.mifincaapp.db.Db_Peso;

import java.util.ArrayList;
import java.util.List;

public class Peso_eliminar extends Fragment {
    View view;
    ListView lista;
    Db_Peso db;
    SQLiteDatabase data;
    List<String> item = null;

    public Peso_eliminar() {
        // Required empty public constructor
    }

    public static Peso_eliminar getInstance(){
        Peso_eliminar fragment=new Peso_eliminar();
        return fragment;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_peso_eliminar, container, false);

        lista=(ListView)view.findViewById(R.id.pesoListaEliminar);
        showInventario();

        return view;
    }

    private void showInventario() {
        db=new Db_Peso(view.getContext());
        Cursor c= db.getNotes();
        item=new ArrayList<String>();
        String arete="";
        String id="";


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


                final String aret= (String) lista.getItemAtPosition(position);

                //Toast.makeText(getContext(),"Arete deleccionado: "+ aret, Toast.LENGTH_SHORT).show();
                Db_Peso dbInventario = new Db_Peso(getActivity());
                data = dbInventario.getWritableDatabase();

                //para eliminar
                // data.execSQL("DELETE FROM inventario WHERE arete='"+aret+"';");
                //aler
                AlertDialog.Builder dialogo1 = new AlertDialog.Builder(getContext());
                dialogo1.setTitle("Importante");
                dialogo1.setMessage("¿ Desea eliminar el registro seleccionado ?");
                dialogo1.setCancelable(false);
                dialogo1.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                        //para eliminar
                        data.execSQL("DELETE FROM controlPeso WHERE arete='"+aret+"';");
                        Intent intent=new Intent(getContext(),controlPeso.class);
                        startActivity(intent);
                    }
                });
                dialogo1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {

                    }
                });
                dialogo1.show();


            }
        });
    }
}
