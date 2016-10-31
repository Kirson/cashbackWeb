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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gabri_000
 */
@Entity
@Table(name = "local_venta_categoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LocalVentaCategoria.findAll", query = "SELECT l FROM LocalVentaCategoria l"),
    @NamedQuery(name = "LocalVentaCategoria.findByLvcId", query = "SELECT l FROM LocalVentaCategoria l WHERE l.lvcId = :lvcId"),
    @NamedQuery(name = "LocalVentaCategoria.findByLvcEstado", query = "SELECT l FROM LocalVentaCategoria l WHERE l.lvcEstado = :lvcEstado")})
public class LocalVentaCategoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "lvc_id")
    private Integer lvcId;
    @Size(max = 3)
    @Column(name = "lvc_estado")
    private String lvcEstado;

    public LocalVentaCategoria() {
    }

    public LocalVentaCategoria(Integer lvcId) {
        this.lvcId = lvcId;
    }

    public Integer getLvcId() {
        return lvcId;
    }

    public void setLvcId(Integer lvcId) {
        this.lvcId = lvcId;
    }

    public String getLvcEstado() {
        return lvcEstado;
    }

    public void setLvcEstado(String lvcEstado) {
        this.lvcEstado = lvcEstado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lvcId != null ? lvcId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LocalVentaCategoria)) {
            return false;
        }
        LocalVentaCategoria other = (LocalVentaCategoria) object;
        if ((this.lvcId == null && other.lvcId != null) || (this.lvcId != null && !this.lvcId.equals(other.lvcId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cashback.model.LocalVentaCategoria[ lvcId=" + lvcId + " ]";
    }
    
}
