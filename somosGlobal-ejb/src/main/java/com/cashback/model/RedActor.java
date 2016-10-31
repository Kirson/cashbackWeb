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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gabri_000
 */
@Entity
@Table(name = "red_actor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RedActor.findAll", query = "SELECT r FROM RedActor r"),
    @NamedQuery(name = "RedActor.findByIdRed", query = "SELECT r FROM RedActor r WHERE r.idRed = :idRed")})
public class RedActor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_red")
    private Integer idRed;

    public RedActor() {
    }

    public RedActor(Integer idRed) {
        this.idRed = idRed;
    }

    public Integer getIdRed() {
        return idRed;
    }

    public void setIdRed(Integer idRed) {
        this.idRed = idRed;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRed != null ? idRed.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RedActor)) {
            return false;
        }
        RedActor other = (RedActor) object;
        if ((this.idRed == null && other.idRed != null) || (this.idRed != null && !this.idRed.equals(other.idRed))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cashback.model.RedActor[ idRed=" + idRed + " ]";
    }
    
}
