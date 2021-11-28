package com.example.tp2_android_wfe;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tp2_android_wfe.db.DbClientes;
import com.example.tp2_android_wfe.db.DbProductos;

public class NuevoActivityCliente extends AppCompatActivity {

    EditText txtRuc, txtNombre, txtEmail;
    Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_cliente);

        txtRuc = findViewById( R.id.txtRuc );
        txtNombre = findViewById( R.id.txtNombre );
        txtEmail = findViewById( R.id.txtEmail );

        btnGuardar = findViewById( R.id.btnGuardar );

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DbClientes dbClientes = new DbClientes( NuevoActivityCliente.this );

                long id = dbClientes.insertarCliente(
                        txtRuc.getText().toString(),
                        txtNombre.getText().toString(),
                        txtEmail.getText().toString()
                );

                if (id > 0) {
                    Toast.makeText(NuevoActivityCliente.this, "REGISTRO GUARDADO", Toast.LENGTH_SHORT).show();
                    limpiar();
                } else {
                    Toast.makeText(NuevoActivityCliente.this, "ERROR AL GUARDAR REGISTRO", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void limpiar ( ) {
        txtRuc.setText("");
        txtNombre.setText("");
        txtEmail.setText("");
    }


}
