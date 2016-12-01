package com.mifincaapp.mifincaapp;

import android.support.v7.app.AppCompatActivity;

public class Control_reproductivo extends AppCompatActivity {
    public static final int FORM_KEY=1;
   /* public static final int ACTIVITY_CODE = 1;

    public static final String TAG = Control_reproductivo.class.getName();
    Db_Control dbHelper;

    RecyclerView mRecyclerView;
    List<Reg_Control> listPersona;
    ReproduccionAdapter adapter;
    View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_reproductivo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        dbHelper= new Db_Control(this);
//nuevo

        mRecyclerView = (RecyclerView) findViewById(R.id.list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        //initList();
        adapter = new ReproduccionAdapter(listPersona);
        mRecyclerView.setAdapter(adapter);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabReproductivo);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                //        .setAction("Action", null).show();
                Fragment fragment=Control_reproductivo_nuevo.getInstance();
                mostrarFragment(fragment);
            }
        });
    }
    private void mostrarFragment(Fragment fragment) {
        FragmentManager fragmentManager= getSupportFragmentManager();
        FragmentTransaction trasaccion=fragmentManager.beginTransaction();
        trasaccion.replace(R.id.cReproductivo,fragment);
        trasaccion.commit();
    }

    private void initList() {
        listPersona = new ArrayList<>();
        listPersona.addAll(dbHelper.getList(""));
        Log.d(TAG, "initList: " + listPersona.size());
    }
    private void updateRecycler(String newText) {
        listPersona.clear();
        listPersona.addAll(dbHelper.getList(newText));
        adapter.notifyDataSetChanged();
    }


    public void onClick(View v) {
        Intent intent = new Intent(this, Control_reproductivo.class);
        startActivityForResult(intent, Control_reproductivo.ACTIVITY_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == Control_reproductivo.ACTIVITY_CODE &&
                resultCode == RESULT_OK) {
            Reg_Control control = new Reg_Control();
            control.setArete(data.getStringExtra(Control_reproductivo_nuevo.ARETE_KEY));
            control.setDiagnostico(data.getStringExtra(Control_reproductivo_nuevo.DIAGNOSTICO_KEY));
            control.setMetodo(data.getStringExtra(Control_reproductivo_nuevo.DETECCION_KEY));
            control.setSemental(data.getStringExtra(Control_reproductivo_nuevo.SEMENTAL_KEY));
            control.setParto(data.getStringExtra(Control_reproductivo_nuevo.PARTO_KEY));
            control.setDesarrollo(data.getStringExtra(Control_reproductivo_nuevo.DESARROLLO_KEY));
            control.setCrias(data.getStringExtra(Control_reproductivo_nuevo.CRIAS_KEY));
            control.setComentarios(data.getStringExtra(Control_reproductivo_nuevo.COMENTARIOS_KEY));
            savePerson(control);
        }
    }

    private void savePerson(Reg_Control persona) {
        if (dbHelper.saveRow(persona)) {
            updateRecycler("");
        } else {
            Toast.makeText(this, R.string.error_on_save, Toast.LENGTH_LONG).show();
        }

    }
*/
}
