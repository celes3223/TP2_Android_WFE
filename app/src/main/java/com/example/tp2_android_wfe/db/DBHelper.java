package com.example.tp2_android_wfe.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NOMBRE = "venta.db";
    public static final String TABLE_PRODUCTOS = "t_productos";
    public static final String TABLE_CLIENTES = "t_clientes";


    public DBHelper(@Nullable Context context ) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String crear_producto = "CREATE TABLE " + TABLE_PRODUCTOS + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "codigo INTEGER NOT NULL," +
                "nombre TEXT NOT NULL," +
                "precio TEXT NOT NULL," +
                "existencia TEXT)";

        String crear_cliente = "CREATE TABLE " + TABLE_CLIENTES + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "ruc INTEGER NOT NULL," +
                "nombre TEXT NOT NULL," +
                "email TEXT NOT NULL)";

        db.execSQL( crear_producto );
        db.execSQL( crear_cliente );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE " + TABLE_PRODUCTOS );
        db.execSQL("DROP TABLE " + TABLE_CLIENTES );
        onCreate(db);
    }
}
