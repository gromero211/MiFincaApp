package com.mifincaapp.mifincaapp;

import android.support.v4.app.Fragment;


public class ListadoReidentificacion extends Fragment /*implements View.OnClickListener*/{
/*
    Db_reidentificacion dbHelper;
    RecyclerView.LayoutManager lManager;
    RecyclerView mRecyclerView;
    List<Reg_reidentificacion> listPersona;
    ReidentificacionAdapter adapter;
    View view;


    public ListadoReidentificacion() {
        // Required empty public constructor
    }

    public static ListadoReidentificacion getInstance(){
        ListadoReidentificacion fragment=new ListadoReidentificacion();
        return fragment;

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        dbHelper = new Db_reidentificacion(getActivity());

        adVista();
        inicializarRecicler();
        view=inflater.inflate(R.layout.fragment_listado_reidentificacion, container, false);
        return view;
    }

    public void adVista() {
        listPersona = new ArrayList<>();
        listPersona.addAll(dbHelper.getList(""));
    }

    private void inicializarRecicler()
    {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.reciclador);
        lManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(lManager);
        adapter = new ReidentificacionAdapter(listPersona);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }



    public void onClick(View v) {
        Intent intent = new Intent(getActivity(), Reidentificacion_nuevo.class);
        startActivityForResult(intent, ACTIVITY_CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == Reidentificacion_nuevo.ACTIVITY_CODE &&
                resultCode == RESULT_OK) {
            Reg_reidentificacion persona = new Reg_reidentificacion();
            persona.setFecha(data.getStringExtra(Reidentificacion_nuevo.FECHA_KEY));
            persona.setAreteanterior(data.getStringExtra(Reidentificacion_nuevo.ARETEANTERIOR_KEY));
            persona.setAretenuevo(data.getStringExtra(Reidentificacion_nuevo.ARETENUEVO_KEY));
            persona.setMotivocambio(data.getStringExtra(Reidentificacion_nuevo.MOTIVOCAMBIO_KEY));
            // persona.setEdad(data.getIntExtra(PersonActivity.AGE_KEY, 0));
            savePerson(persona);
        }
    }

    private void savePerson(Reg_reidentificacion persona) {
        if (dbHelper.saveRow(persona)) {
            updateRecycler("");
        } else {
            Toast.makeText(getActivity(), R.string.error_on_save, Toast.LENGTH_LONG).show();
        }

    }
    private void updateRecycler(String newText) {
        listPersona.clear();
        listPersona.addAll(dbHelper.getList(newText));
        adapter.notifyDataSetChanged();
    }
*/
}
