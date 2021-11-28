package com.example.tp2_android_wfe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tp2_android_wfe.db.DbClientes;
import com.example.tp2_android_wfe.db.DbProductos;
import com.example.tp2_android_wfe.entidades.Clientes;
import com.example.tp2_android_wfe.entidades.Productos;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class EditarCliente extends AppCompatActivity {

    EditText txtRuc, txtNombre, txtEmail;
    Button btnGuardar;
    FloatingActionButton fabEditar, fabEliminar;

    boolean correcto = false;

    Clientes cliente;
    int id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_cliente);

        txtRuc = findViewById(R.id.txtCodigo);
        txtNombre = findViewById(R.id.txtNombre);
        txtEmail = findViewById(R.id.txtPrecio);
        fabEditar = findViewById(R.id.fabEditar);
        fabEditar.setVisibility(View.INVISIBLE);
        fabEliminar = findViewById(R.id.fabEliminar);
        fabEliminar.setVisibility(View.INVISIBLE);

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
        DbClientes dbClientes = new DbClientes(EditarCliente.this );
        cliente = dbClientes.verCliente( id );

        if ( cliente != null ) {
            txtRuc.setText(cliente.getRuc());
            txtNombre.setText(cliente.getNombre());
            txtEmail.setText(cliente.getEmail());

        }

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( !txtRuc.getText().toString().equals("") && !txtNombre.getText().toString().equals("") && !txtEmail.getText().toString().equals("") ) {
                    correcto = dbClientes.editarCliente( id, txtRuc.getText().toString(), txtNombre.getText().toString(), txtEmail.getText().toString() );

                    if ( correcto ) {
                        Toast.makeText(EditarCliente.this, "Registro Modificado", Toast.LENGTH_SHORT).show();
                        verCliente();
                    } else {
                        Toast.makeText(EditarCliente.this, "Error al modificar el registro", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText( EditarCliente.this, "Debe llenar los campos obligatorios", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void verCliente ( ) {
        Intent intent = new Intent(this, VerCliente.class );
        intent.putExtra( "ID", id );
        startActivity( intent );
    }
}

