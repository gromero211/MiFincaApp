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



    public Db_inventario(Context context){
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
    public List<Reg_inventario> getList(String filter){
        List<Reg_inventario> list = new ArrayList<>();
        SQLiteDatabase database = this.getReadableDatabase();
        String[] projection = {
                PersonaContract._ID,
                PersonaContract.DATE_COLUMN,
                PersonaContract.ARETE_COLUMN,
                PersonaContract.AGE_COLUMN,
                PersonaContract.CATEGORIA_COLUMN,
                PersonaContract.RAZA_COLUMN,
                PersonaContract.AGE_COLUMN
        };
        String selection = PersonaContract.DATE_COLUMN  +" like ?";
        String[] selectionArgs = {"%"+filter+"%"};
        String sortOrder = PersonaContract.DATE_COLUMN + " DESC";

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
                list.add(new Reg_inventario(c.getString(1),c.getString(2),c.getString(3),c.getString(4),c.getString(5)));
            }
        }
        return list;
    }

    public static void removeDatabase(Context context) {
        context.deleteDatabase(DATABASE_NAME);
    }


    public class PersonaContract implements BaseColumns {
        public static final String TABLE_NAME= "inventario";
        public static final String DATE_COLUMN= "fecha";
        public static final String ARETE_COLUMN = "arete";
        public static final String AGE_COLUMN = "edad";
        public static final String CATEGORIA_COLUMN = "categoria";
        public static final String RAZA_COLUMN = "raza";
    }
}