/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashback.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "transacciones_actor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TransaccionesActor.findAll", query = "SELECT t FROM TransaccionesActor t"),
    @NamedQuery(name = "TransaccionesActor.findById", query = "SELECT t FROM TransaccionesActor t WHERE t.id = :id"),
    @NamedQuery(name = "TransaccionesActor.findByNumDocumentoActor", query = "SELECT t FROM TransaccionesActor t WHERE t.numDocumentoActor = :numDocumentoActor"),
    @NamedQuery(name = "TransaccionesActor.findByNumDocumentoBeneficiario", query = "SELECT t FROM TransaccionesActor t WHERE t.numDocumentoBeneficiario = :numDocumentoBeneficiario"),
    @NamedQuery(name = "TransaccionesActor.findByPuntosTransaccion", query = "SELECT t FROM TransaccionesActor t WHERE t.puntosTransaccion = :puntosTransaccion"),
    @NamedQuery(name = "TransaccionesActor.findByPuntosGanados", query = "SELECT t FROM TransaccionesActor t WHERE t.puntosGanados = :puntosGanados"),
    @NamedQuery(name = "TransaccionesActor.findByFechaTransaccion", query = "SELECT t FROM TransaccionesActor t WHERE t.fechaTransaccion = :fechaTransaccion"),
    @NamedQuery(name = "TransaccionesActor.findByValorCompra", query = "SELECT t FROM TransaccionesActor t WHERE t.valorCompra = :valorCompra")})
public class TransaccionesActor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 15)
    @Column(name = "num_documento_actor")
    private String numDocumentoActor;
    @Size(max = 15)
    @Column(name = "num_documento_beneficiario")
    private String numDocumentoBeneficiario;
    @Column(name = "puntos_transaccion")
    private Integer puntosTransaccion;
    @Column(name = "puntos_ganados")
    private Integer puntosGanados;
    @Column(name = "fecha_transaccion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaTransaccion;
    @Column(name = "valor_compra")
    private BigDecimal valorCompra;
    @Column(name = "porcentaje_descuento")
    private BigDecimal porcentajeDescuento;
    @Column(name = "descripcion_compra")
    private String descripcionCompra;
    

    //bi-directional many-to-one association to Actor
    @ManyToOne
    @JoinColumn(name="id_consumidor")
    private Actor consumidor;
    //bi-directional many-to-one association to Actor
    @ManyToOne
    @JoinColumn(name="id_beneficiario")
    private Actor beneficiario;
    
     //bi-directional many-to-one association to Actor
    @ManyToOne
    @JoinColumn(name="id_local")
    private Actor localVenta;

    public TransaccionesActor() {
    }

    public TransaccionesActor(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumDocumentoActor() {
        return numDocumentoActor;
    }

    public void setNumDocumentoActor(String numDocumentoActor) {
        this.numDocumentoActor = numDocumentoActor;
    }

    

    public String getNumDocumentoBeneficiario() {
        return numDocumentoBeneficiario;
    }

    public void setNumDocumentoBeneficiario(String numDocumentoBeneficiario) {
        this.numDocumentoBeneficiario = numDocumentoBeneficiario;
    }

    public Integer getPuntosTransaccion() {
        return puntosTransaccion;
    }

    public void setPuntosTransaccion(Integer puntosTransaccion) {
        this.puntosTransaccion = puntosTransaccion;
    }

    public Integer getPuntosGanados() {
        return puntosGanados;
    }

    public void setPuntosGanados(Integer puntosGanados) {
        this.puntosGanados = puntosGanados;
    }

    public Date getFechaTransaccion() {
        return fechaTransaccion;
    }

    public void setFechaTransaccion(Date fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }

    public BigDecimal getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(BigDecimal valorCompra) {
        this.valorCompra = valorCompra;
    }

    public Actor getConsumidor() {
        return consumidor;
    }

    public void setConsumidor(Actor consumidor) {
        this.consumidor = consumidor;
    }

    public Actor getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(Actor beneficiario) {
        this.beneficiario = beneficiario;
    }

    public Actor getLocalVenta() {
        return localVenta;
    }

    public void setLocalVenta(Actor localVenta) {
        this.localVenta = localVenta;
    }

    public BigDecimal getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(BigDecimal porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public String getDescripcionCompra() {
        return descripcionCompra;
    }

    public void setDescripcionCompra(String descripcionCompra) {
        this.descripcionCompra = descripcionCompra;
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
        if (!(object instanceof TransaccionesActor)) {
            return false;
        }
        TransaccionesActor other = (TransaccionesActor) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "com.cashback.model.TransaccionesActor[ id=" + id + " ]";
    }
    
}
