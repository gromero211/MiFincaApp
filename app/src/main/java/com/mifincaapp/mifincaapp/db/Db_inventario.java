package com.mifincaapp.mifincaapp.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by GARF on 23/11/2016.
 */

public class Db_inventario extends SQLiteOpenHelper {
    static final int DATABASE_VERSION= 1;
    static final String DATABASE_NAME = "Inventario.db";
    static final String SEPARATOR = ",";
    private static final String TEXT_TYPE = " TEXT";
    private static final String INTEGER_TYPE = " INTEGER";

    static final String SQL_CREATE_TABLE =
            "CREATE TABLE "+ PersonaContract.TABLE_NAME +
                    " (" + PersonaContract._ID + " INTEGER PRIMARY KEY"+ SEPARATOR +
                    PersonaContract.DATE_COLUMN + TEXT_TYPE + SEPARATOR +
                    PersonaContract.ARETE_COLUMN+ TEXT_TYPE + SEPARATOR +
                    PersonaContract.AGE_COLUMN + TEXT_TYPE + SEPARATOR +
                    PersonaContract.CATEGORIA_COLUMN + TEXT_TYPE + SEPARATOR +
                    PersonaContract.RAZA_COLUMN + TEXT_TYPE + ")";
    static final String SQL_DROP_TABLE = "DROP TABLE IF EXISTS" + PersonaContract.TABLE_NAME;

    static final String SQL_CREATE_TABLE2 =
            "CREATE TABLE "+ PersonaContract.TABLE_NAME2 +
                    " (" + PersonaContract._ID + " INTEGER PRIMARY KEY"+ SEPARATOR +
                    PersonaContract.DATE_COLUMN2 + TEXT_TYPE + SEPARATOR +
                    PersonaContract.ARETEANTERIOR_COLUMN+ TEXT_TYPE + SEPARATOR +
                    PersonaContract.ARETENUEVO_COLUMN + TEXT_TYPE + SEPARATOR +
                    PersonaContract.MOTIVOCAMBIO_COLUMN + TEXT_TYPE + ")";
    static final String SQL_DROP_TABLE2 = "DROP TABLE IF EXISTS" + PersonaContract.TABLE_NAME;

    static final String SQL_CREATE_TABLE3 =
            "CREATE TABLE "+ PersonaContract.TABLE_NAME3 +
                    " (" + PersonaContract._ID + " INTEGER PRIMARY KEY"+ SEPARATOR +
                    PersonaContract.DATE_COLUMN3 + TEXT_TYPE + SEPARATOR +
                    PersonaContract.ARETE_COLUMN3+ TEXT_TYPE + SEPARATOR +
                    PersonaContract.AGE_COLUMN3 + TEXT_TYPE + SEPARATOR +
                    PersonaContract.RAZA_COLUMN3 + TEXT_TYPE + SEPARATOR +
                    PersonaContract.PESO_COLUMN + TEXT_TYPE + ")";
    static final String SQL_DROP_TABLE3 = "DROP TABLE IF EXISTS" + PersonaContract.TABLE_NAME;


    public Db_inventario(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //crea la base de dattos
        db.execSQL(SQL_CREATE_TABLE);
        db.execSQL(SQL_CREATE_TABLE2);
        db.execSQL(SQL_CREATE_TABLE3);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DROP_TABLE);
        onCreate(db);
        db.execSQL(SQL_DROP_TABLE2);
        onCreate(db);
        db.execSQL(SQL_DROP_TABLE3);
        onCreate(db);
    }
    public boolean saveRow(Reg_inventario persona){
        ContentValues contentValues = new ContentValues();
        contentValues.put(PersonaContract.DATE_COLUMN, persona.getFecha());
        contentValues.put(PersonaContract.ARETE_COLUMN, persona.getArete());
        contentValues.put(PersonaContract.AGE_COLUMN, persona.getEdad());
        contentValues.put(PersonaContract.CATEGORIA_COLUMN, persona.getCategoria());
        contentValues.put(PersonaContract.RAZA_COLUMN, persona.getRaza());
        long result = this.getWritableDatabase().insert(PersonaContract.TABLE_NAME,null,contentValues);
        return result != -1;
    }

    public class PersonaContract implements BaseColumns {
        public static final String TABLE_NAME= "inventario";
        public static final String DATE_COLUMN= "fecha";
        public static final String ARETE_COLUMN = "arete";
        public static final String AGE_COLUMN = "edad";
        public static final String CATEGORIA_COLUMN = "categoria";
        public static final String RAZA_COLUMN = "raza";


        /*Ekaterina*/
        public static final String TABLE_NAME2= "reidentificacion";
        public static final String DATE_COLUMN2= "fecha";
        public static final String ARETEANTERIOR_COLUMN = "areteanterior";
        public static final String ARETENUEVO_COLUMN = "aretenuevo";
        public static final String MOTIVOCAMBIO_COLUMN = "motivocambio";

        public static final String TABLE_NAME3= "controlPeso";
        public static final String DATE_COLUMN3= "fecha";
        public static final String ARETE_COLUMN3 = "arete";
        public static final String AGE_COLUMN3 = "edad";
        public static final String RAZA_COLUMN3 = "raza";
        public static final String PESO_COLUMN = "peso";
    }
    //listar elementos
    public Cursor getNotes()
    {
        String columnas[]={ PersonaContract.DATE_COLUMN,PersonaContract.AGE_COLUMN, PersonaContract.RAZA_COLUMN};
        Cursor c=this.getReadableDatabase().query(PersonaContract.TABLE_NAME,columnas, null,null,null,null, null);
        return c;
    }
}
