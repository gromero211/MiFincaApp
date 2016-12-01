package com.mifincaapp.mifincaapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.mifincaapp.mifincaapp.Adapter.InventarioAdapter;
import com.mifincaapp.mifincaapp.db.Db_inventario;
import com.mifincaapp.mifincaapp.db.Reg_inventario;

import java.util.ArrayList;
import java.util.List;

import static android.app.Activity.RESULT_OK;
import static com.mifincaapp.mifincaapp.Inventario_nuevo.ACTIVITY_CODE;


public class ListadoInventario extends Fragment implements View.OnClickListener{

    Db_inventario dbHelper;
   RecyclerView.LayoutManager lManager;
    RecyclerView mRecyclerView;
    List<Reg_inventario> listPersona;
    InventarioAdapter adapter;
    View view;


    public ListadoInventario() {
        // Required empty public constructor
    }

    public static ListadoInventario getInstance(){
        ListadoInventario fragment=new ListadoInventario();
        return fragment;

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        dbHelper = new Db_inventario(getActivity());

        adVista();
         inicializarRecicler();
        view=inflater.inflate(R.layout.fragment_listado_inventario, container, false);
        return view;
    }

    public void adVista() {
        listPersona = new ArrayList<>();
        //listPersona.addAll(dbHelper.getList(""));
    }

    private void inicializarRecicler()
    {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.reciclador);
        lManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(lManager);
        adapter = new InventarioAdapter(listPersona);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }



    public void onClick(View v) {
        Intent intent = new Intent(getActivity(), Inventario_nuevo.class);
        startActivityForResult(intent, ACTIVITY_CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == Inventario_nuevo.ACTIVITY_CODE &&
                resultCode == RESULT_OK) {
            Reg_inventario persona = new Reg_inventario();
            persona.setFecha(data.getStringExtra(Inventario_nuevo.FECHA_KEY));
            persona.setArete(data.getStringExtra(Inventario_nuevo.ARETE_KEY));
            persona.setEdad(data.getStringExtra(Inventario_nuevo.EDAD_KEY));
            persona.setCategoria(data.getStringExtra(Inventario_nuevo.CATEGORIA_KEY));
            persona.setRaza(data.getStringExtra(Inventario_nuevo.RAZA_KEY));
           // persona.setEdad(data.getIntExtra(PersonActivity.AGE_KEY, 0));
            savePerson(persona);
        }
    }

    private void savePerson(Reg_inventario persona) {
        if (dbHelper.saveRow(persona)) {
            updateRecycler("");
        } else {
            Toast.makeText(getActivity(), R.string.error_on_save, Toast.LENGTH_LONG).show();
        }

    }
    private void updateRecycler(String newText) {
        listPersona.clear();
        //listPersona.addAll(dbHelper.getList(newText));
        adapter.notifyDataSetChanged();
    }

}
