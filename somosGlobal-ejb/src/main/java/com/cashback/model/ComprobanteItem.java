/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashback.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author somosGlobal
 */
@Entity
@Table(name = "comprobante_item")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ComprobanteItem.findAll", query = "SELECT c FROM ComprobanteItem c"),
    @NamedQuery(name = "ComprobanteItem.findByIdItem", query = "SELECT c FROM ComprobanteItem c WHERE c.idItem = :idItem"),
    @NamedQuery(name = "ComprobanteItem.findByNumComprobante", query = "SELECT c FROM ComprobanteItem c WHERE c.numComprobante = :numComprobante"),
    @NamedQuery(name = "ComprobanteItem.findByDescripcionItem", query = "SELECT c FROM ComprobanteItem c WHERE c.descripcionItem = :descripcionItem"),
    @NamedQuery(name = "ComprobanteItem.findByValorItem", query = "SELECT c FROM ComprobanteItem c WHERE c.valorItem = :valorItem")})
public class ComprobanteItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_item")
    private Integer idItem;
    @Size(max = 15)
    @Column(name = "num_comprobante")
    private String numComprobante;
    @Size(max = 150)
    @Column(name = "descripcion_item")
    private String descripcionItem;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor_item")
    private BigDecimal valorItem;
    @JoinColumn(name = "id_comprobante", referencedColumnName = "id_comprobante")
    @ManyToOne(optional = false)
    private Comprobante idComprobante;

    public ComprobanteItem() {
    }

    public ComprobanteItem(Integer idItem) {
        this.idItem = idItem;
    }

    public Integer getIdItem() {
        return idItem;
    }

    public void setIdItem(Integer idItem) {
        this.idItem = idItem;
    }

    public String getNumComprobante() {
        return numComprobante;
    }

    public void setNumComprobante(String numComprobante) {
        this.numComprobante = numComprobante;
    }

    public String getDescripcionItem() {
        return descripcionItem;
    }

    public void setDescripcionItem(String descripcionItem) {
        this.descripcionItem = descripcionItem;
    }

    public BigDecimal getValorItem() {
        return valorItem;
    }

    public void setValorItem(BigDecimal valorItem) {
        this.valorItem = valorItem;
    }

    public Comprobante getIdComprobante() {
        return idComprobante;
    }

    public void setIdComprobante(Comprobante idComprobante) {
        this.idComprobante = idComprobante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idItem != null ? idItem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComprobanteItem)) {
            return false;
        }
        ComprobanteItem other = (ComprobanteItem) object;
        if ((this.idItem == null && other.idItem != null) || (this.idItem != null && !this.idItem.equals(other.idItem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cashback.model.ComprobanteItem[ idItem=" + idItem + " ]";
    }
    
}
