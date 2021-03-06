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
@Table(name = "comprobante_forma_pago")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ComprobanteFormaPago.findAll", query = "SELECT c FROM ComprobanteFormaPago c"),
    @NamedQuery(name = "ComprobanteFormaPago.findByIdFp", query = "SELECT c FROM ComprobanteFormaPago c WHERE c.idFp = :idFp"),
    @NamedQuery(name = "ComprobanteFormaPago.findByNumComprobante", query = "SELECT c FROM ComprobanteFormaPago c WHERE c.numComprobante = :numComprobante")})
public class ComprobanteFormaPago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_fp")
    private Integer idFp;
    @Size(max = 15)
    @Column(name = "num_comprobante")
    private String numComprobante;
    @JoinColumn(name = "id_comprobante", referencedColumnName = "id_comprobante")
    @ManyToOne(optional = false)
    private Comprobante idComprobante;
    @Column(name = "descripcion_forma_pago")
    private String descripcionFormaPago;
    @Column(name = "valor_forma_pago")
    private BigDecimal valorFormaPago;
    @JoinColumn(name = "id_for_pag", referencedColumnName = "id_for_pag")
    @ManyToOne(optional = false)
    private FormaPago formaPago;
    
    public ComprobanteFormaPago() {
    }

    public ComprobanteFormaPago(Integer idFp) {
        this.idFp = idFp;
    }

    public Integer getIdFp() {
        return idFp;
    }

    public void setIdFp(Integer idFp) {
        this.idFp = idFp;
    }

    public String getNumComprobante() {
        return numComprobante;
    }

    public void setNumComprobante(String numComprobante) {
        this.numComprobante = numComprobante;
    }

    public Comprobante getIdComprobante() {
        return idComprobante;
    }

    public void setIdComprobante(Comprobante idComprobante) {
        this.idComprobante = idComprobante;
    }

    public String getDescripcionFormaPago() {
        return descripcionFormaPago;
    }

    public void setDescripcionFormaPago(String descripcionFormaPago) {
        this.descripcionFormaPago = descripcionFormaPago;
    }

    public BigDecimal getValorFormaPago() {
        return valorFormaPago;
    }

    public void setValorFormaPago(BigDecimal valorFormaPago) {
        this.valorFormaPago = valorFormaPago;
    }

    public FormaPago getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFp != null ? idFp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComprobanteFormaPago)) {
            return false;
        }
        ComprobanteFormaPago other = (ComprobanteFormaPago) object;
        return !((this.idFp == null && other.idFp != null) || (this.idFp != null && !this.idFp.equals(other.idFp)));
    }

    @Override
    public String toString() {
        return "com.cashback.model.ComprobanteFormaPago[ idFp=" + idFp + " ]";
    }
    
}
