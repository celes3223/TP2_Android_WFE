package com.example.tp2_android_wfe.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.tp2_android_wfe.entidades.Productos;

import java.util.ArrayList;

public class DbProductos extends DBHelper {

    Context context;

    public DbProductos(@Nullable Context context) {
        super(context);

        this.context = context;
    }

    public long insertarProducto( String codigo, String nombre, String precio, String existencia ) {

        long id = -1;

        try {

            DBHelper dbHelper = new DBHelper(context);

            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();

            values.put("codigo", codigo);
            values.put("nombre", nombre);
            values.put("precio", precio);
            values.put("existencia", existencia);

            id = db.insert(TABLE_PRODUCTOS, null, values);

        } catch ( Exception e ) {
            e.toString();
        }

        return id;

    }

    public ArrayList<Productos> mostrarProductos( ) {

        DBHelper dbHelper = new DBHelper(context);

        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ArrayList<Productos> listaProductos = new ArrayList<>();
        Productos producto = null;
        Cursor cursorProductos = null;

        cursorProductos = db.rawQuery("SELECT * FROM " + TABLE_PRODUCTOS, null);

        if ( cursorProductos.moveToFirst() ) {

            do {
                producto = new Productos();
                producto.setId(cursorProductos.getInt(0));
                producto.setCodigo(cursorProductos.getString(1));
                producto.setNombre(cursorProductos.getString(2));
                producto.setPrecio(cursorProductos.getString(3));
                producto.setExistencia(cursorProductos.getString(4));

                listaProductos.add( producto );
            } while ( cursorProductos.moveToNext());

            cursorProductos.close();
        }
        return listaProductos;
    }

    public Productos verProducto (int id ) {

        DBHelper dbHelper = new DBHelper(context);

        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Productos producto = null;
        Cursor cursorProductos = null;

        cursorProductos = db.rawQuery("SELECT * FROM " + TABLE_PRODUCTOS + " WHERE id = " + id + " LIMIT 1", null);

        if ( cursorProductos.moveToFirst() ) {

            producto = new Productos();
            producto.setId(cursorProductos.getInt(0));
            producto.setCodigo(cursorProductos.getString(1));
            producto.setNombre(cursorProductos.getString(2));
            producto.setPrecio(cursorProductos.getString(3));
            producto.setExistencia(cursorProductos.getString(4));

        }
        cursorProductos.close();

        return producto;
    }
}
