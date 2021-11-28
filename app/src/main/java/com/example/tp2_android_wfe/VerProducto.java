package com.example.tp2_android_wfe;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tp2_android_wfe.db.DbProductos;
import com.example.tp2_android_wfe.entidades.Productos;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class VerProducto extends AppCompatActivity {

    EditText txtCodigo, txtNombre, txtPrecio, txtExistencia;
    Button btnGuardar;

    FloatingActionButton fabEditar, fabEliminar;

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
        fabEliminar = findViewById(R.id.fabEliminar);

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

        fabEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder( VerProducto.this );
                builder.setMessage("¿Desea eliminar este producto?")
                        .setPositiveButton("SI", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if ( dbProductos.eliminarProducto( id ) ) {
                                    Toast.makeText(VerProducto.this, "Producto Eliminado", Toast.LENGTH_SHORT).show();
                                    listaProducto();
                                }
                            }
                        })
                        .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).show();
            }
        });

    }

    private void listaProducto ( ) {
        Intent intent = new Intent(this, MainActivity.class );
        startActivity( intent );

    }
}