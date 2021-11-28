package com.example.tp2_android_wfe.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tp2_android_wfe.R;
import com.example.tp2_android_wfe.entidades.Clientes;

import java.util.ArrayList;

public class ListaClientesAdapter extends RecyclerView.Adapter<ListaClientesAdapter.ClienteViewHolder> {

    ArrayList<Clientes> listaClientes;

    public ListaClientesAdapter( ArrayList<Clientes> listaClientes ) {
        this.listaClientes = listaClientes;
    }

    @NonNull
    @Override
    public ListaClientesAdapter.ClienteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item_cliente, null, false );
        return new ListaClientesAdapter.ClienteViewHolder( view );
    }

    @Override
    public void onBindViewHolder(@NonNull ListaClientesAdapter.ClienteViewHolder holder, int position) {

        holder.viewRuc.setText(listaClientes.get(position).getRuc());
        holder.viewNombre.setText(listaClientes.get( position ).getNombre() );
        holder.viewEmail.setText(listaClientes.get(position).getEmail());
    }

    @Override
    public int getItemCount() {
        return listaClientes.size();
    }

    public class ClienteViewHolder extends RecyclerView.ViewHolder {

        TextView viewRuc, viewNombre, viewEmail;

        public ClienteViewHolder(@NonNull View itemView) {
            super(itemView);

            viewRuc = itemView.findViewById(R.id.viewRuc);
            viewNombre = itemView.findViewById(R.id.viewNombre);
            viewEmail = itemView.findViewById(R.id.viewEmail);

        }
    }
}
