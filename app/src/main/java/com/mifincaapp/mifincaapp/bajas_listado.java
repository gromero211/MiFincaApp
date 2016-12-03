package com.mifincaapp.mifincaapp;

import android.content.Context;
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

import com.mifincaapp.mifincaapp.R;
import com.mifincaapp.mifincaapp.db.Db_inventario;

import java.util.ArrayList;
import java.util.List;

public class bajas_listado extends Fragment {
    View view;
    ListView lista;
    Db_inventario db;
    SQLiteDatabase data;
    List<String> item = null;
    TextView tv_inId, tv_inArete;
    public bajas_listado() {
        // Required empty public constructor
    }
    public static bajas_listado getInstance(){
        bajas_listado fragment=new bajas_listado();
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
                //muestra el nuevo fragment
                //
                //na.setText("Población de "+ lv1.getItemAtPosition(posicion) + " es "+ habitantes[posicion]);
                TextView tv1=(TextView)view.findViewById(R.id.textView11);
                String aret= (String) lista.getItemAtPosition(position);
//                tv1.setText("posicion: "+lista.getItemIdAtPosition(position)+ " es " );
                Toast.makeText(getContext(), aret, Toast.LENGTH_SHORT).show();
                Db_inventario dbInventario = new Db_inventario(getActivity());
                data = dbInventario.getWritableDatabase();

                //para eliminar
                data.execSQL("DELETE FROM inventario WHERE arete='"+aret+"';");
                //para hacer el select (no copiar esta parte)
                Cursor cursor=data.rawQuery("SELECT * FROM inventario WHERE arete='"+aret+"'",null);

            }
        });
    }
}
