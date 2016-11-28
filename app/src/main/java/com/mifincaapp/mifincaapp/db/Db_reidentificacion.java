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
 * Created by USUARIO on 27/11/2016.
 */

public class Db_reidentificacion extends SQLiteOpenHelper {
    static final int DATABASE_VERSION= 1;
    static final String DATABASE_NAME = "Reidentificacion.db";
    static final String SEPARATOR = ",";
    private static final String TEXT_TYPE = " TEXT";
    private static final String INTEGER_TYPE = " INTEGER";

    static final String SQL_CREATE_TABLE =
            "CREATE TABLE "+ Db_reidentificacion.PersonaContract.TABLE_NAME +
                    " (" + Db_reidentificacion.PersonaContract._ID + " INTEGER PRIMARY KEY"+ SEPARATOR +
                    Db_reidentificacion.PersonaContract.DATE_COLUMN + TEXT_TYPE + SEPARATOR +
                    Db_reidentificacion.PersonaContract.ARETE_COLUMN+ TEXT_TYPE + SEPARATOR +
                    Db_reidentificacion.PersonaContract.AGE_COLUMN + TEXT_TYPE + SEPARATOR +
                    Db_reidentificacion.PersonaContract.CATEGORIA_COLUMN + TEXT_TYPE + SEPARATOR +
                    Db_reidentificacion.PersonaContract.RAZA_COLUMN + TEXT_TYPE + ")";
    static final String SQL_DROP_TABLE = "DROP TABLE IF EXISTS" + Db_reidentificacion.PersonaContract.TABLE_NAME;



    public Db_reidentificacion(Context context){
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

    public boolean saveRow(Reg_reidentificacion persona){
        ContentValues contentValues = new ContentValues();
        contentValues.put(Db_reidentificacion.PersonaContract.DATE_COLUMN, persona.getFecha());
        contentValues.put(Db_reidentificacion.PersonaContract.ARETE_COLUMN, persona.getArete());
        contentValues.put(Db_reidentificacion.PersonaContract.AGE_COLUMN, persona.getEdad());
        contentValues.put(Db_reidentificacion.PersonaContract.CATEGORIA_COLUMN, persona.getCategoria());
        contentValues.put(Db_reidentificacion.PersonaContract.RAZA_COLUMN, persona.getRaza());
        long result = this.getWritableDatabase().insert(Db_reidentificacion.PersonaContract.TABLE_NAME,null,contentValues);
        return result != -1;
    }
    public List<Reg_inventario> getList(String filter){
        List<Reg_inventario> list = new ArrayList<>();
        SQLiteDatabase database = this.getReadableDatabase();
        String[] projection = {
                Db_reidentificacion.PersonaContract._ID,
                Db_reidentificacion.PersonaContract.DATE_COLUMN,
                Db_reidentificacion.PersonaContract.ARETE_COLUMN,
                Db_reidentificacion.PersonaContract.AGE_COLUMN,
                Db_reidentificacion.PersonaContract.CATEGORIA_COLUMN,
                Db_reidentificacion.PersonaContract.RAZA_COLUMN,
                Db_reidentificacion.PersonaContract.AGE_COLUMN
        };
        String selection = Db_reidentificacion.PersonaContract.DATE_COLUMN  +" like ?";
        String[] selectionArgs = {"%"+filter+"%"};
        String sortOrder = Db_reidentificacion.PersonaContract.DATE_COLUMN + " DESC";

        Cursor c = database.query(
                Db_reidentificacion.PersonaContract.TABLE_NAME,
                projection,
                filter.length()>0?selection:null,
                filter.length()>0?selectionArgs:null,
                null,
                null,
                sortOrder
        );
        while (c.moveToNext()){
            if(c.getString(1)!= null && c.getInt(2) != 0){
                list.add(new Reg_reidentificacion(c.getString(1),c.getString(2),c.getString(3),c.getString(4),c.getString(5)));
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

