package com.example.tp2_android_wfe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.tp2_android_wfe.db.DbProductos;
import com.example.tp2_android_wfe.entidades.Productos;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class VerProducto extends AppCompatActivity {

    EditText txtCodigo, txtNombre, txtPrecio, txtExistencia;
    Button btnGuardar;

    FloatingActionButton fabEditar;

    Productos producto;
    int id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_producto);

        txtCodigo = findViewById(R.id.txtCodigo);
        txtNombre = findViewById(R.id.txtNombre);
        txtPrecio = findViewById(R.id.txtPrecio);
        txtExistencia = findViewById(R.id.txtExistencia);
        fabEditar = findViewById(R.id.fabEditar);

        btnGuardar = findViewById(R.id.btnGuardar);

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();

            if ( extras == null) {
                id = Integer.parseInt(null);
            } else {
                id = extras.getInt("ID");

            }
        } else {
            id = (int) savedInstanceState.getSerializable("ID");
        }
        DbProductos dbProductos = new DbProductos(VerProducto.this );
        producto = dbProductos.verProducto( id );

        if (producto != null) {
            txtCodigo.setText(producto.getCodigo());
            txtNombre.setText(producto.getNombre());
            txtPrecio.setText(producto.getPrecio());
            txtExistencia.setText(producto.getExistencia());

            btnGuardar.setVisibility(View.INVISIBLE);

            txtCodigo.setInputType(InputType.TYPE_NULL);
            txtNombre.setInputType(InputType.TYPE_NULL);
            txtPrecio.setInputType(InputType.TYPE_NULL);
            txtExistencia.setInputType(InputType.TYPE_NULL);
        }

        fabEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( VerProducto.this, EditarProducto.class);
                intent.putExtra("ID", id);
                startActivity( intent );
            }
        });

    }
}