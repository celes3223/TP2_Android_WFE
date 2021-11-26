package com.example.tp2_android_wfe.model;

public class Detalle {

    private Producto producto;
    private Integer cantidad;
    private Integer total_detalle;

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getTotal_detalle() {
        return total_detalle;
    }

    public void setTotal_detalle(Integer total_detalle) {
        this.total_detalle = total_detalle;
    }
}
