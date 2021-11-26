package com.example.tp2_android_wfe.model;

public class Venta {

    private Integer id;
    private Integer numero_factura;
    private Cliente cliente;
    private Integer total;
    private Detalle[] detalle;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumero_factura() {
        return numero_factura;
    }

    public void setNumero_factura(Integer numero_factura) {
        this.numero_factura = numero_factura;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Detalle[] getDetalle() {
        return detalle;
    }

    public void setDetalle(Detalle[] detalle) {
        this.detalle = detalle;
    }
}
