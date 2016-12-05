package com.mifincaapp.mifincaapp.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by GARF on 4/12/2016.
 */

public class Db_Peso extends SQLiteOpenHelper {
    static final int DATABASE_VERSION= 1;
    static final String DATABASE_NAME = "Peso.db";
    static final String SEPARATOR = ",";
    private static final String TEXT_TYPE = " TEXT";
    static final String SQL_CREATE_TABLE =
            "CREATE TABLE "+ PersonaContract.TABLE_NAME +
                    " (" + PersonaContract._ID + " INTEGER PRIMARY KEY"+ SEPARATOR +
                    PersonaContract.FECHA_COLUMN + TEXT_TYPE + SEPARATOR +
                    PersonaContract.ARETE_COLUMN+ TEXT_TYPE + SEPARATOR +
                    PersonaContract.EDAD_COLUMN+ TEXT_TYPE + SEPARATOR +
                    PersonaContract.RAZA_COLUMN+ TEXT_TYPE + SEPARATOR +
                    PersonaContract.PESO_COLUMN+ TEXT_TYPE + ")";
    static final String SQL_DROP_TABLE = "DROP TABLE IF EXISTS" + Db_Control.PersonaContract.TABLE_NAME;



    public Db_Peso(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public class PersonaContract implements BaseColumns {
        public static final String TABLE_NAME= "controlPeso";
        public static final String FECHA_COLUMN= "fecha";
        public static final String ARETE_COLUMN = "arete";
        public static final String EDAD_COLUMN = "edad";
        public static final String RAZA_COLUMN = "raza";
        public static final String PESO_COLUMN = "peso";

    }
}
