/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashback.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author somosGlobal
 */
@Entity
@Table(name = "item_glo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemGlo.findAll", query = "SELECT i FROM ItemGlo i"),
    @NamedQuery(name = "ItemGlo.findByIdIg", query = "SELECT i FROM ItemGlo i WHERE i.idIg = :idIg"),
    @NamedQuery(name = "ItemGlo.findByMonbreIg", query = "SELECT i FROM ItemGlo i WHERE i.monbreIg = :monbreIg"),
    @NamedQuery(name = "ItemGlo.findByRefIg", query = "SELECT i FROM ItemGlo i WHERE i.refIg = :refIg")})
public class ItemGlo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ig")
    private Long idIg;
    @Size(max = 50)
    @Column(name = "monbre_ig")
    private String monbreIg;
    @Size(max = 50)
    @Column(name = "ref_ig")
    private String refIg;
    @OneToMany(mappedBy = "idIg")
    private List<ItemLoc> itemLocList;

    public ItemGlo() {
    }

    public ItemGlo(Long idIg) {
        this.idIg = idIg;
    }

    public Long getIdIg() {
        return idIg;
    }

    public void setIdIg(Long idIg) {
        this.idIg = idIg;
    }

    public String getMonbreIg() {
        return monbreIg;
    }

    public void setMonbreIg(String monbreIg) {
        this.monbreIg = monbreIg;
    }

    public String getRefIg() {
        return refIg;
    }

    public void setRefIg(String refIg) {
        this.refIg = refIg;
    }

    @XmlTransient
    public List<ItemLoc> getItemLocList() {
        return itemLocList;
    }

    public void setItemLocList(List<ItemLoc> itemLocList) {
        this.itemLocList = itemLocList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idIg != null ? idIg.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemGlo)) {
            return false;
        }
        ItemGlo other = (ItemGlo) object;
        return !((this.idIg == null && other.idIg != null) || (this.idIg != null && !this.idIg.equals(other.idIg)));
    }

    @Override
    public String toString() {
        return "com.cashback.model.ItemGlo[ idIg=" + idIg + " ]";
    }
    
}
