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
 * @author somosGlobal
 */
@Entity
@Table(name = "forma_pago")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FormaPago.findAll", query = "SELECT f FROM FormaPago f"),
    @NamedQuery(name = "FormaPago.findByIdForPag", query = "SELECT f FROM FormaPago f WHERE f.idForPag = :idForPag"),
    @NamedQuery(name = "FormaPago.findByNombreForPag", query = "SELECT f FROM FormaPago f WHERE f.nombreForPag = :nombreForPag")})
public class FormaPago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_for_pag")
    private Integer idForPag;
    @Size(max = 50)
    @Column(name = "nombre_for_pag")
    private String nombreForPag;

    public FormaPago() {
    }

    public FormaPago(Integer idForPag) {
        this.idForPag = idForPag;
    }

    public Integer getIdForPag() {
        return idForPag;
    }

    public void setIdForPag(Integer idForPag) {
        this.idForPag = idForPag;
    }

    public String getNombreForPag() {
        return nombreForPag;
    }

    public void setNombreForPag(String nombreForPag) {
        this.nombreForPag = nombreForPag;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idForPag != null ? idForPag.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FormaPago)) {
            return false;
        }
        FormaPago other = (FormaPago) object;
        if ((this.idForPag == null && other.idForPag != null) || (this.idForPag != null && !this.idForPag.equals(other.idForPag))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cashback.model.FormaPago[ idForPag=" + idForPag + " ]";
    }
    
}
