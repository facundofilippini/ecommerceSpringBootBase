package com.facudev.ecommerceSpringBootBase.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ordenes")
public class Orden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String numero;
    private Date fechaCreacion;
    private Date fechaRecibida;


    @ManyToOne
    private Usuario usuario;

    @OneToMany(mappedBy = "orden")
    private List<Producto> productos;

    public Orden(Integer id, String numero, Date fechaCreacion, Date fechaRecibida) {
        this.id = id;
        this.numero = numero;
        this.fechaCreacion = fechaCreacion;
        this.fechaRecibida = fechaRecibida;
    }

    public Orden() {
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {

        this.id = id;
    }

    public String getNumero() {

        return numero;
    }

    public void setNumero(String numero) {

        this.numero = numero;
    }

    public Date getFechaCreacion() {

        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {

        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaRecibida() {

        return fechaRecibida;
    }

    public void setFechaRecibida(Date fechaRecibida) {

        this.fechaRecibida = fechaRecibida;
    }

    @Override
    public String toString() {
        return "Orden{" +
                "id=" + id +
                ", numero='" + numero + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", fechaRecibida=" + fechaRecibida +
                '}';
    }
}
