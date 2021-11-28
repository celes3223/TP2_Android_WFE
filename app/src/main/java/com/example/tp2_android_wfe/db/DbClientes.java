package com.example.tp2_android_wfe.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.tp2_android_wfe.entidades.Clientes;

import java.util.ArrayList;

public class DbClientes extends DBHelper{

    Context context;

    public DbClientes(@Nullable Context context) {
        super( context );

        this.context = context;
    }

    public long insertarCliente( String ruc, String nombre, String email ) {

        long id = -1;

        try {

            DBHelper dbHelper = new DBHelper(context);

            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();

            values.put("ruc", ruc);
            values.put("nombre", nombre);
            values.put("email", email);

            id = db.insert(TABLE_CLIENTES, null, values);

        } catch ( Exception e ) {
            e.toString();
        }

        return id;

    }

    public ArrayList<Clientes> mostrarClientes( ) {

        DBHelper dbHelper = new DBHelper(context);

        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ArrayList<Clientes> listaClientes = new ArrayList<>();
        Clientes cliente = null;
        Cursor cursorClientes = null;

        cursorClientes = db.rawQuery("SELECT * FROM " + TABLE_CLIENTES, null);

        if ( cursorClientes.moveToFirst() ) {

            do {
                cliente = new Clientes();
                cliente.setId(cursorClientes.getInt(0));
                cliente.setRuc(cursorClientes.getString(1));
                cliente.setNombre(cursorClientes.getString(2));
                cliente.setEmail(cursorClientes.getString(3));

                listaClientes.add( cliente );
            } while ( cursorClientes.moveToNext());


        }
        cursorClientes.close();

        return listaClientes;
    }

    public Clientes verCliente ( int id ) {

        DBHelper dbHelper = new DBHelper(context);

        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Clientes cliente = null;
        Cursor cursorClientes = null;

        cursorClientes = db.rawQuery("SELECT * FROM " + TABLE_CLIENTES + " WHERE id = " + id + " LIMIT 1", null);

        if ( cursorClientes.moveToFirst() ) {

            cliente = new Clientes();
            cliente.setId(cursorClientes.getInt(0));
            cliente.setRuc(cursorClientes.getString(1));
            cliente.setNombre(cursorClientes.getString(2));
            cliente.setEmail(cursorClientes.getString(3));

        }
        cursorClientes.close();
        return cliente;
    }

    public boolean editarCliente( int id, String ruc, String nombre, String email ) {

        boolean correcto = false;

        DBHelper dbHelper = new DBHelper(context);

        SQLiteDatabase db = dbHelper.getWritableDatabase();

        String update = "UPDATE " + TABLE_PRODUCTOS + " SET ruc = ' " + ruc + " ', nombre = ' " + nombre + " ', email = ' " + email + " ' WHERE id = ' " + id + " ' ";

        try {
            db.execSQL( update );
            correcto = true;

        } catch (Exception e ) {
            e.toString();
            correcto = false;
        } finally {
            db.close();
        }

        return correcto;

    }

    public boolean eliminarCliente( int id ) {

        boolean correcto = false;

        DBHelper dbHelper = new DBHelper(context);

        SQLiteDatabase db = dbHelper.getWritableDatabase();

        String delete = "DELETE FROM " + TABLE_CLIENTES + " WHERE id = '" + id + " ' LIMIT 1 ";

        try {
            db.execSQL( delete );
            correcto = true;

        } catch (Exception e ) {
            e.toString();
            correcto = false;
        } finally {
            db.close();
        }

        return correcto;

    }
}
