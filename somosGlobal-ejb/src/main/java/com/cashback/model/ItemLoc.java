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
@Table(name = "item_loc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemLoc.findAll", query = "SELECT i FROM ItemLoc i"),
    @NamedQuery(name = "ItemLoc.findByIdIl", query = "SELECT i FROM ItemLoc i WHERE i.idIl = :idIl"),
    @NamedQuery(name = "ItemLoc.findByNombreIl", query = "SELECT i FROM ItemLoc i WHERE i.nombreIl = :nombreIl"),
    @NamedQuery(name = "ItemLoc.findByCosUniIl", query = "SELECT i FROM ItemLoc i WHERE i.cosUniIl = :cosUniIl"),
    @NamedQuery(name = "ItemLoc.findByIvaIl", query = "SELECT i FROM ItemLoc i WHERE i.ivaIl = :ivaIl")})
public class ItemLoc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_il")
    private Long idIl;
    @Size(max = 50)
    @Column(name = "nombre_il")
    private String nombreIl;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cos_uni_il")
    private Double cosUniIl;
    @Size(max = 1)
    @Column(name = "iva_il")
    private String ivaIl;
    @JoinColumn(name = "id_act", referencedColumnName = "id_act")
    @ManyToOne
    private Actor idAct;
    @JoinColumn(name = "id_ig", referencedColumnName = "id_ig")
    @ManyToOne
    private ItemGlo idIg;
    
    @Column(name = "porc_fijo_il")
    private Double porcFijoIl;
    
    @Column(name = "porc_var_il")
    private Double porcVarIl;

    public ItemLoc() {
    }

    public ItemLoc(Long idIl) {
        this.idIl = idIl;
    }

    public Long getIdIl() {
        return idIl;
    }

    public void setIdIl(Long idIl) {
        this.idIl = idIl;
    }

    public String getNombreIl() {
        return nombreIl;
    }

    public void setNombreIl(String nombreIl) {
        this.nombreIl = nombreIl;
    }

    public Double getCosUniIl() {
        return cosUniIl;
    }

    public void setCosUniIl(Double cosUniIl) {
        this.cosUniIl = cosUniIl;
    }

    public String getIvaIl() {
        return ivaIl;
    }

    public void setIvaIl(String ivaIl) {
        this.ivaIl = ivaIl;
    }

    public Actor getIdAct() {
        return idAct;
    }

    public void setIdAct(Actor idAct) {
        this.idAct = idAct;
    }

    public ItemGlo getIdIg() {
        return idIg;
    }

    public void setIdIg(ItemGlo idIg) {
        this.idIg = idIg;
    }

    public Double getPorcFijoIl() {
        return porcFijoIl;
    }

    public void setPorcFijoIl(Double porcFijoIl) {
        this.porcFijoIl = porcFijoIl;
    }

    public Double getPorcVarIl() {
        return porcVarIl;
    }

    public void setPorcVarIl(Double porcVarIl) {
        this.porcVarIl = porcVarIl;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idIl != null ? idIl.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemLoc)) {
            return false;
        }
        ItemLoc other = (ItemLoc) object;
        return !((this.idIl == null && other.idIl != null) || (this.idIl != null && !this.idIl.equals(other.idIl)));
    }

    @Override
    public String toString() {
        return this.nombreIl;
    }
    
}
