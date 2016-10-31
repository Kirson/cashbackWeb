/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashback.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author somosGlobal
 */
@Entity
@Table(name = "puntos_actor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PuntosActor.findAll", query = "SELECT p FROM PuntosActor p"),
    @NamedQuery(name = "PuntosActor.findById", query = "SELECT p FROM PuntosActor p WHERE p.id = :id"),
    @NamedQuery(name = "PuntosActor.findByTotalPuntos", query = "SELECT p FROM PuntosActor p WHERE p.totalPuntos = :totalPuntos"),
    @NamedQuery(name = "PuntosActor.findByNumDocumentoActor", query = "SELECT p FROM PuntosActor p WHERE p.numDocumentoActor = :numDocumentoActor")})
public class PuntosActor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "total_puntos")
    private Integer totalPuntos;
    @Size(max = 15)
    @Column(name = "num_documento_actor")
    private String numDocumentoActor;
    
    @Temporal(TemporalType.DATE)
    @Column(name="vig_desde")
    private Date vigDesde;

    @Temporal(TemporalType.DATE)
    @Column(name="vig_hasta")
    private Date vigHasta;

    //bi-directional many-to-one association to Actor
    @ManyToOne
    @JoinColumn(name="id_actor")
    private Actor actor;

    public PuntosActor() {
        totalPuntos =0;
    }

    public PuntosActor(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTotalPuntos() {
        return totalPuntos;
    }

    public void setTotalPuntos(Integer totalPuntos) {
        this.totalPuntos = totalPuntos;
    }

    public String getNumDocumentoActor() {
        return numDocumentoActor;
    }

    public void setNumDocumentoActor(String numDocumentoActor) {
        this.numDocumentoActor = numDocumentoActor;
    }

    public Date getVigDesde() {
        return vigDesde;
    }

    public void setVigDesde(Date vigDesde) {
        this.vigDesde = vigDesde;
    }

    public Date getVigHasta() {
        return vigHasta;
    }

    public void setVigHasta(Date vigHasta) {
        this.vigHasta = vigHasta;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

   
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PuntosActor)) {
            return false;
        }
        PuntosActor other = (PuntosActor) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "com.cashback.model.PuntosActor[ id=" + id + " ]";
    }
    
}
