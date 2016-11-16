/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashback.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author somosGlobal
 */
@Entity
@Table(name = "comprobante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comprobante.findAll", query = "SELECT c FROM Comprobante c"),
    @NamedQuery(name = "Comprobante.findByIdComprobante", query = "SELECT c FROM Comprobante c WHERE c.idComprobante = :idComprobante"),
    @NamedQuery(name = "Comprobante.findByNumComprobante", query = "SELECT c FROM Comprobante c WHERE c.numComprobante = :numComprobante"),
    @NamedQuery(name = "Comprobante.findByNumDocumento", query = "SELECT c FROM Comprobante c WHERE c.numDocumento = :numDocumento"),
    @NamedQuery(name = "Comprobante.findByPuntosTransaccion", query = "SELECT c FROM Comprobante c WHERE c.puntosTransaccion = :puntosTransaccion"),
    @NamedQuery(name = "Comprobante.findByPuntosGanados", query = "SELECT c FROM Comprobante c WHERE c.puntosGanados = :puntosGanados"),
    @NamedQuery(name = "Comprobante.findByFechaComprobante", query = "SELECT c FROM Comprobante c WHERE c.fechaComprobante = :fechaComprobante"),
    @NamedQuery(name = "Comprobante.findByValorCompra", query = "SELECT c FROM Comprobante c WHERE c.valorCompra = :valorCompra"),
    @NamedQuery(name = "Comprobante.findByValorIva", query = "SELECT c FROM Comprobante c WHERE c.valorIva = :valorIva"),
    @NamedQuery(name = "Comprobante.findByTotalCompra", query = "SELECT c FROM Comprobante c WHERE c.totalCompra = :totalCompra"),
    @NamedQuery(name = "Comprobante.findByPorcentajeDescuento", query = "SELECT c FROM Comprobante c WHERE c.porcentajeDescuento = :porcentajeDescuento"),
    @NamedQuery(name = "Comprobante.findByDescripcionCompra", query = "SELECT c FROM Comprobante c WHERE c.descripcionCompra = :descripcionCompra"),
    @NamedQuery(name = "Comprobante.findByPagaPuntos", query = "SELECT c FROM Comprobante c WHERE c.pagaPuntos = :pagaPuntos")})
public class Comprobante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_comprobante")
    private Integer idComprobante;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "num_comprobante")
    private String numComprobante;
    @Size(max = 15)
    @Column(name = "num_documento")
    private String numDocumento;
    @Column(name = "puntos_transaccion")
    private Integer puntosTransaccion;
    @Column(name = "puntos_ganados")
    private Integer puntosGanados;
    @Column(name = "fecha_comprobante")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaComprobante;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor_compra")
    private BigDecimal valorCompra;
    @Column(name = "valor_iva")
    private BigDecimal valorIva;
    @Column(name = "total_compra")
    private BigDecimal totalCompra;
    @Column(name = "porcentaje_descuento")
    private BigDecimal porcentajeDescuento;
    @Size(max = 150)
    @Column(name = "descripcion_compra")
    private String descripcionCompra;
    @Column(name = "paga_puntos")
    private Boolean pagaPuntos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idComprobante")
    private List<ComprobanteFormaPago> comprobanteFormaPagoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idComprobante")
    private List<ComprobanteItem> comprobanteItemList;
    
     //bi-directional many-to-one association to Actor
    @ManyToOne
    @JoinColumn(name="id_cliente")
    private Actor cliente;
    
    //bi-directional many-to-one association to Actor
    @ManyToOne
    @JoinColumn(name="id_local")
    private Actor localVenta;

    public Comprobante() {
        pagaPuntos = Boolean.FALSE;
        valorIva = new BigDecimal(0);
        valorCompra = new BigDecimal(0);
        totalCompra = new BigDecimal(0);
    }

    public Comprobante(Integer idComprobante) {
        this.idComprobante = idComprobante;
    }

    public Comprobante(Integer idComprobante, String numComprobante) {
        this.idComprobante = idComprobante;
        this.numComprobante = numComprobante;
    }

    public Integer getIdComprobante() {
        return idComprobante;
    }

    public void setIdComprobante(Integer idComprobante) {
        this.idComprobante = idComprobante;
    }

    public String getNumComprobante() {
        return numComprobante;
    }

    public void setNumComprobante(String numComprobante) {
        this.numComprobante = numComprobante;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
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

    public Date getFechaComprobante() {
        return fechaComprobante;
    }

    public void setFechaComprobante(Date fechaComprobante) {
        this.fechaComprobante = fechaComprobante;
    }

    public BigDecimal getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(BigDecimal valorCompra) {
        this.valorCompra = valorCompra;
    }

    public BigDecimal getValorIva() {
        return valorIva;
    }

    public void setValorIva(BigDecimal valorIva) {
        this.valorIva = valorIva;
    }

    public BigDecimal getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(BigDecimal totalCompra) {
        this.totalCompra = totalCompra;
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

    public Boolean getPagaPuntos() {
        return pagaPuntos;
    }

    public void setPagaPuntos(Boolean pagaPuntos) {
        this.pagaPuntos = pagaPuntos;
    }

    public Actor getCliente() {
        return cliente;
    }

    public void setCliente(Actor cliente) {
        this.cliente = cliente;
    }

    public Actor getLocalVenta() {
        return localVenta;
    }

    public void setLocalVenta(Actor localVenta) {
        this.localVenta = localVenta;
    }
    
    

    @XmlTransient
    public List<ComprobanteFormaPago> getComprobanteFormaPagoList() {
        return comprobanteFormaPagoList;
    }

    public void setComprobanteFormaPagoList(List<ComprobanteFormaPago> comprobanteFormaPagoList) {
        this.comprobanteFormaPagoList = comprobanteFormaPagoList;
    }

    @XmlTransient
    public List<ComprobanteItem> getComprobanteItemList() {
        return comprobanteItemList;
    }

    public void setComprobanteItemList(List<ComprobanteItem> comprobanteItemList) {
        this.comprobanteItemList = comprobanteItemList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idComprobante != null ? idComprobante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comprobante)) {
            return false;
        }
        Comprobante other = (Comprobante) object;
        if ((this.idComprobante == null && other.idComprobante != null) || (this.idComprobante != null && !this.idComprobante.equals(other.idComprobante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cashback.model.Comprobante[ idComprobante=" + idComprobante + " ]";
    }
    
}
