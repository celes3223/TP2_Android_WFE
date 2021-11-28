package com.example.tp2_android_wfe.adaptadores;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tp2_android_wfe.R;

import com.example.tp2_android_wfe.VerProducto;
import com.example.tp2_android_wfe.entidades.Productos;

import java.util.ArrayList;

public class ListaProductosAdapter extends RecyclerView.Adapter<ListaProductosAdapter.ProductoViewHolder> {

    ArrayList<Productos> listaProductos;

    public ListaProductosAdapter( ArrayList<Productos> listaProductos ) {
        this.listaProductos = listaProductos;
    }

    @NonNull
    @Override
    public ProductoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item_producto, null, false );
        return new ProductoViewHolder( view );
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoViewHolder holder, int position) {
        holder.viewCodigo.setText(listaProductos.get( position ).getCodigo() );
        holder.viewNombre.setText(listaProductos.get( position ).getNombre() );
        holder.viewPrecio.setText(listaProductos.get(position).getPrecio());
        holder.viewExistencia.setText(listaProductos.get(position).getExistencia());
    }

    @Override
    public int getItemCount() {
        return listaProductos.size();
    }

    public class ProductoViewHolder extends RecyclerView.ViewHolder {

        TextView viewCodigo, viewNombre, viewPrecio, viewExistencia;

        public ProductoViewHolder(@NonNull View itemView) {
            super(itemView);

            viewCodigo = itemView.findViewById(R.id.viewCodigo);
            viewNombre = itemView.findViewById(R.id.viewNombre);
            viewPrecio = itemView.findViewById(R.id.viewPrecio);
            viewExistencia = itemView.findViewById(R.id.viewExistencia);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();
                    Intent intent = new Intent( context, VerProducto.class );
                    intent.putExtra("ID", listaProductos.get(getAdapterPosition()).getId());
                    context.startActivity( intent );
                }
            });
        }
    }
}
