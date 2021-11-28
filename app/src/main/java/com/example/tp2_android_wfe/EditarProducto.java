package com.example.tp2_android_wfe;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tp2_android_wfe.db.DbProductos;
import com.example.tp2_android_wfe.entidades.Productos;

public class EditarProducto extends AppCompatActivity {

    EditText txtCodigo, txtNombre, txtPrecio, txtExistencia;
    Button btnGuardar;

    boolean correcto = false;

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
        DbProductos dbProductos = new DbProductos(EditarProducto.this );
        producto = dbProductos.verProducto( id );

        if (producto != null) {
            txtCodigo.setText(producto.getCodigo());
            txtNombre.setText(producto.getNombre());
            txtPrecio.setText(producto.getPrecio());
            txtExistencia.setText(producto.getExistencia());

        }

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( !txtCodigo.getText().toString().equals("") && !txtNombre.getText().toString().equals("") && !txtPrecio.getText().toString().equals("") && !txtExistencia.getText().toString().equals("")) {
                    correcto = dbProductos.editarProducto( id, txtCodigo.getText().toString(), txtNombre.getText().toString(), txtPrecio.getText().toString(), txtExistencia.getText().toString());
                    
                    if ( correcto ) {
                        Toast.makeText(EditarProducto.this, "Registro Modificado", Toast.LENGTH_SHORT).show();
                        verProducto();
                    } else {
                        Toast.makeText(EditarProducto.this, "Error al modificar el registro", Toast.LENGTH_SHORT).show();
                    }
                
                } else {
                    Toast.makeText( EditarProducto.this, "Debe llenar los campos obligatorios", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void verProducto ( ) {
        Intent intent = new Intent(this, VerProducto.class );
        intent.putExtra( "ID", id );
        startActivity( intent );
    }
}
