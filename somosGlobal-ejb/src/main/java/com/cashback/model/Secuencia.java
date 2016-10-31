/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashback.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gabri_000
 */
@Entity
@Table(name = "secuencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Secuencia.findAll", query = "SELECT s FROM Secuencia s"),
    @NamedQuery(name = "Secuencia.findByTabla", query = "SELECT s FROM Secuencia s WHERE s.tabla = :tabla"),
    @NamedQuery(name = "Secuencia.findBySiguienteValor", query = "SELECT s FROM Secuencia s WHERE s.siguienteValor = :siguienteValor"),
    @NamedQuery(name = "Secuencia.findByIncremento", query = "SELECT s FROM Secuencia s WHERE s.incremento = :incremento"),
    @NamedQuery(name = "Secuencia.findByLongitud", query = "SELECT s FROM Secuencia s WHERE s.longitud = :longitud"),
    @NamedQuery(name = "Secuencia.findByCaracter", query = "SELECT s FROM Secuencia s WHERE s.caracter = :caracter"),
    @NamedQuery(name = "Secuencia.findByMaximo", query = "SELECT s FROM Secuencia s WHERE s.maximo = :maximo")})
public class Secuencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "tabla")
    private String tabla;
    @Column(name = "siguiente_valor")
    private Integer siguienteValor;
    @Column(name = "incremento")
    private Integer incremento;
    @Column(name = "longitud")
    private Integer longitud;
    @Size(max = 1)
    @Column(name = "caracter")
    private String caracter;
    @Column(name = "maximo")
    private Integer maximo;

    public Secuencia() {
    }

    public Secuencia(String tabla) {
        this.tabla = tabla;
    }

    public String getTabla() {
        return tabla;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }

    public Integer getSiguienteValor() {
        return siguienteValor;
    }

    public void setSiguienteValor(Integer siguienteValor) {
        this.siguienteValor = siguienteValor;
    }

    public Integer getIncremento() {
        return incremento;
    }

    public void setIncremento(Integer incremento) {
        this.incremento = incremento;
    }

    public Integer getLongitud() {
        return longitud;
    }

    public void setLongitud(Integer longitud) {
        this.longitud = longitud;
    }

    public String getCaracter() {
        return caracter;
    }

    public void setCaracter(String caracter) {
        this.caracter = caracter;
    }

    public Integer getMaximo() {
        return maximo;
    }

    public void setMaximo(Integer maximo) {
        this.maximo = maximo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tabla != null ? tabla.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Secuencia)) {
            return false;
        }
        Secuencia other = (Secuencia) object;
        if ((this.tabla == null && other.tabla != null) || (this.tabla != null && !this.tabla.equals(other.tabla))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cashback.model.Secuencia[ tabla=" + tabla + " ]";
    }
    
}
