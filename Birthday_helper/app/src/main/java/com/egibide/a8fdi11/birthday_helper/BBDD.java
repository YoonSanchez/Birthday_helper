package com.egibide.a8fdi11.birthday_helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

/**
 * Created by 8fdi11 on 30/3/17.
 */

public class BBDD extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "mis_cumples.db";

    private String sqlCreate = "CREATE TABLE IF NOT EXISTS mis_cumples(ID integer,tipo_notificacion char(1),mensaje VARCHAR(160),telefono VARCHAR(15),fecha_nacimiento VARCHAR(15),nombre VARCHAR(128));";

    public BBDD(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Se ejecuta la sentencia SQL de creación de la tabla
        db.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnterior, int versionNueva) {
        //NOTA: Por simplicidad del ejemplo aquí utilizamos directamente la opción de
        //      eliminar la tabla anterior y crearla de nuevo vacía con el nuevo formato.
        //      Sin embargo lo normal será que haya que migrar datos de la tabla antigua
        //      a la nueva, por lo que este método debería ser más elaborado.

        //Se elimina la versión anterior de la tabla
        db.execSQL("DROP TABLE IF EXISTS mis_cumples");

        //Se crea la nueva versión de la tabla
        db.execSQL(sqlCreate);
    }


}
