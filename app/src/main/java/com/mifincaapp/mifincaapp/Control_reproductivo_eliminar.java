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


public class Control_reproductivo_eliminar extends Fragment {
    View view;
    ListView lista;
    Db_Control db;
    SQLiteDatabase data;
    List<String> item = null;
    public Control_reproductivo_eliminar() {
        // Required empty public constructor
    }
    public static Control_reproductivo_eliminar getInstance(){
        Control_reproductivo_eliminar fragment=new Control_reproductivo_eliminar();
        return fragment;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_control_reproductivo_eliminar, container, false);

        lista=(ListView)view.findViewById(R.id.reproductivoListaEliminar);
        showInventario();

        return view;
    }

    private void showInventario() {
        db=new Db_Control(view.getContext());
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

                TextView tv1=(TextView)view.findViewById(R.id.textView11);
                final String aret= (String) lista.getItemAtPosition(position);

                //Toast.makeText(getContext(),"Arete deleccionado: "+ aret, Toast.LENGTH_SHORT).show();
                Db_Control dbInventario = new Db_Control(getActivity());
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
                        data.execSQL("DELETE FROM Reg_Reproductivo WHERE arete='"+aret+"';");
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
