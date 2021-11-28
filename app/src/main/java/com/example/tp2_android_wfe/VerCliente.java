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

import com.example.tp2_android_wfe.db.DbClientes;
import com.example.tp2_android_wfe.entidades.Clientes;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class VerCliente extends AppCompatActivity {

    EditText txtRuc, txtNombre, txtEmail;
    Button btnGuardar;
    FloatingActionButton fabEditar, fabEliminar;

    Clientes cliente;
    int id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_cliente);

        txtRuc = findViewById(R.id.txtRuc);
        txtNombre = findViewById(R.id.txtNombre);
        txtEmail = findViewById(R.id.txtEmail);
        btnGuardar = findViewById(R.id.btnGuardar);
        fabEditar = findViewById(R.id.fabEditar);
        fabEliminar = findViewById(R.id.fabEliminar);

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
        DbClientes dbClientes = new DbClientes(VerCliente.this );
        cliente = dbClientes.verCliente( id );

        if (cliente != null) {
            txtRuc.setText(cliente.getRuc());
            txtNombre.setText(cliente.getNombre());
            txtEmail.setText(cliente.getEmail());

            btnGuardar.setVisibility(View.INVISIBLE);

            txtRuc.setInputType(InputType.TYPE_NULL);
            txtNombre.setInputType(InputType.TYPE_NULL);
            txtEmail.setInputType(InputType.TYPE_NULL);

        }

        fabEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( VerCliente.this, EditarCliente.class);
                intent.putExtra("ID", id);
                startActivity( intent );
            }
        });

        fabEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder( VerCliente.this );
                builder.setMessage("¿Desea eliminar este cliente?")
                        .setPositiveButton("SI", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if ( dbClientes.eliminarCliente( id ) ) {
                                    Toast.makeText(VerCliente.this, "Cliente Eliminado", Toast.LENGTH_SHORT).show();
                                    listaCliente();
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

    private void listaCliente ( ) {
        Intent intent = new Intent(this, MainActivity.class );
        startActivity( intent );

    }

}