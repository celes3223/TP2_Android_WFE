package com.example.tp2_android_wfe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tp2_android_wfe.db.DbProductos;

public class NuevoActivityProducto extends AppCompatActivity {

    EditText txtCodigo, txtNombre, txtPrecio, txtExistencia;
    Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_producto);

        txtCodigo = findViewById( R.id.txtCodigo );
        txtNombre = findViewById( R.id.txtNombre );
        txtPrecio = findViewById( R.id.txtPrecio );
        txtExistencia = findViewById( R.id.txtExistencia );

        btnGuardar = findViewById( R.id.btnGuardar );

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DbProductos dbProductos = new DbProductos( NuevoActivityProducto.this );

                long id = dbProductos.insertarProducto(
                        txtCodigo.getText().toString(),
                        txtNombre.getText().toString(),
                        txtPrecio.getText().toString(),
                        txtExistencia.getText().toString());

                if (id > 0) {
                    Toast.makeText(NuevoActivityProducto.this, "REGISTRO GUARDADO", Toast.LENGTH_SHORT).show();
                    limpiar();
                } else {
                    Toast.makeText(NuevoActivityProducto.this, "ERROR AL GUARDAR REGISTRO", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void limpiar ( ) {
        txtCodigo.setText("");
        txtNombre.setText("");
        txtPrecio.setText("");
        txtExistencia.setText("");
    }
}