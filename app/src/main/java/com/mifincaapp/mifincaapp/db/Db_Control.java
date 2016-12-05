package com.mifincaapp.mifincaapp.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;



import java.util.ArrayList;
import java.util.List;

/**
 * Created by GARF on 27/11/2016.
 */

public class Db_Control extends SQLiteOpenHelper {
    static final int DATABASE_VERSION= 1;
    static final String DATABASE_NAME = "Example.db";
    static final String SEPARATOR = ",";
    private static final String TEXT_TYPE = " TEXT";
    private static final String INTEGER_TYPE = " INTEGER";

    static final String SQL_CREATE_TABLE =
            "CREATE TABLE "+ PersonaContract.TABLE_NAME +
                    " (" + PersonaContract._ID + " INTEGER PRIMARY KEY"+ SEPARATOR +
                    PersonaContract.ARETE_COLUMN + TEXT_TYPE + SEPARATOR +
                    PersonaContract.DIAGNOSTICO_COLUMN + TEXT_TYPE + SEPARATOR +
                    PersonaContract.DETECCION_COLUMN+ TEXT_TYPE + SEPARATOR +
                    PersonaContract.SEMENTAL_COLUMN+ TEXT_TYPE + SEPARATOR +
                    PersonaContract.PARTO_COLUMN+ TEXT_TYPE + SEPARATOR +
                    PersonaContract.DES_PARTO_COLUMN+ TEXT_TYPE + SEPARATOR +
                    PersonaContract.CRIAS_COLUMN+ TEXT_TYPE + SEPARATOR +
                    PersonaContract.COMENTARIOS_COLUMN+ INTEGER_TYPE + ")";
    static final String SQL_DROP_TABLE = "DROP TABLE IF EXISTS" + PersonaContract.TABLE_NAME;




    public Db_Control(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DROP_TABLE);
        onCreate(db);
    }

    public boolean saveRow(Reg_Control persona){
        ContentValues contentValues = new ContentValues();
        contentValues.put(PersonaContract.ARETE_COLUMN, persona.getArete());
        contentValues.put(PersonaContract.DIAGNOSTICO_COLUMN, persona.getDiagnostico());
        contentValues.put(PersonaContract.DETECCION_COLUMN, persona.getMetodo());
        contentValues.put(PersonaContract.SEMENTAL_COLUMN, persona.getSemental());
        contentValues.put(PersonaContract.PARTO_COLUMN, persona.getParto());
        contentValues.put(PersonaContract.DES_PARTO_COLUMN, persona.getDesarrollo());
        contentValues.put(PersonaContract.CRIAS_COLUMN, persona.getCrias());
        contentValues.put(PersonaContract.COMENTARIOS_COLUMN, persona.getComentarios());
        long result = this.getWritableDatabase().insert(PersonaContract.TABLE_NAME,null,contentValues);
        return result != -1;
    }
    public List<Reg_Control> getList(String filter){
        List<Reg_Control> list = new ArrayList<>();
        SQLiteDatabase database = this.getReadableDatabase();
        String[] projection = {
                PersonaContract._ID,
                PersonaContract.ARETE_COLUMN,
                PersonaContract.DIAGNOSTICO_COLUMN,
                PersonaContract.DETECCION_COLUMN,
                PersonaContract.SEMENTAL_COLUMN,
                PersonaContract.PARTO_COLUMN,
                PersonaContract.DES_PARTO_COLUMN,
                PersonaContract.CRIAS_COLUMN,
                PersonaContract.COMENTARIOS_COLUMN
        };
        String selection = PersonaContract.ARETE_COLUMN  +" like ?";
        String[] selectionArgs = {"%"+filter+"%"};
        String sortOrder = PersonaContract.ARETE_COLUMN + " DESC";

        Cursor c = database.query(
                PersonaContract.TABLE_NAME,
                projection,
                filter.length()>0?selection:null,
                filter.length()>0?selectionArgs:null,
                null,
                null,
                sortOrder
        );
        while (c.moveToNext()){
            if(c.getString(1)!= null && c.getInt(2) != 0){
                list.add(new Reg_Control(c.getString(1),c.getString(2),c.getString(3),c.getString(4),c.getString(5),c.getString(6),c.getString(7),c.getString(8)));
            }
        }
        return list;
    }

    public static void removeDatabase(Context context) {
        context.deleteDatabase(DATABASE_NAME);
    }


    public class PersonaContract implements BaseColumns {
        public static final String TABLE_NAME= "Reg_Reproductivo";
        public static final String ARETE_COLUMN= "arete";
        public static final String DIAGNOSTICO_COLUMN = "fecha_diagnostico";
        public static final String DETECCION_COLUMN = "met_deteccion";
        public static final String SEMENTAL_COLUMN = "semental";
        public static final String PARTO_COLUMN = "fec_parto";
        public static final String DES_PARTO_COLUMN = "des_parto";
        public static final String CRIAS_COLUMN = "no_crias";
        public static final String COMENTARIOS_COLUMN = "comentarios";
    }
    public Cursor getNotes()
    {
        String columnas[]={ PersonaContract._ID, PersonaContract.ARETE_COLUMN};
        Cursor c=this.getReadableDatabase().query(PersonaContract.TABLE_NAME,columnas, null,null,null,null, null);
        return c;
    }
}
