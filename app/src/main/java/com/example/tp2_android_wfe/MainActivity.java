package com.example.tp2_android_wfe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import com.example.tp2_android_wfe.adaptadores.ListaProductosAdapter;
import com.example.tp2_android_wfe.db.DBHelper;
import com.example.tp2_android_wfe.db.DbProductos;
import com.example.tp2_android_wfe.entidades.Productos;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnCrear;
    RecyclerView listaProductos;
    ArrayList<Productos> listaArrayProductos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCrear = findViewById( R.id.btnCrear );

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbHelper = new DBHelper(MainActivity.this );
                SQLiteDatabase db = dbHelper.getWritableDatabase();

                if ( db != null) {
                    Toast.makeText( MainActivity.this, "BASE DE DATOS CREADA", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText( MainActivity.this, "ERROR AL CREAR LA BASE DE DATOS", Toast.LENGTH_SHORT).show();
                }
            }
        });

//        listaProductos = findViewById(R.id.listaProductos);
//
//        listaProductos.setLayoutManager(new LinearLayoutManager(this ));
//
//        DbProductos dbProductos = new DbProductos( MainActivity.this );
//
//        listaArrayProductos = new ArrayList<>();
//
//        ListaProductosAdapter adapter = new ListaProductosAdapter(dbProductos.mostrarProductos());
//        listaProductos.setAdapter(adapter);

    }

    public boolean onCreateOptionsMenu ( Menu menu ) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate( R.menu.menu_principal, menu );

        return true;

    }

    public boolean onOptionsItemSelected (MenuItem item ) {

        switch( item.getItemId() ) {
            case R.id.menuNuevo:
                nuevoRegistro();
                return true;

            default:
                return super.onOptionsItemSelected( item );
        }
    }

    private void nuevoRegistro ( ) {

        Intent intent = new Intent( this, NuevoActivityProducto.class );
        startActivity( intent );

    }



}