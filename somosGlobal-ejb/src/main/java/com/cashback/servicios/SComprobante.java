/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashback.servicios;

import com.cashback.beans.ComprobanteBean;
import com.cashback.interfaces.IComprobante;
import com.cashback.model.Actor;
import com.cashback.model.Comprobante;
import com.cashback.model.ComprobanteFormaPago;
import com.cashback.model.ComprobanteItem;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.transaction.Transactional;

/**
 *
 * @author somosGlobal
 */
@Stateless
public class SComprobante extends AbstractService implements IComprobante {

    @Override
    @Transactional
    public ComprobanteBean guardarComprobante(ComprobanteBean comprobanteBean) {
        String resultado = "OK";
        try{
            Comprobante c = comprobanteBean.getComprobante();
            emCashback.persist(c);
            
            List<ComprobanteItem> items = comprobanteBean.getItems();
            
            if(items!=null && !items.isEmpty()){
                for(ComprobanteItem ci:items){
                    ci.setIdComprobante(c);
                    ci.setNumComprobante(c.getNumComprobante());
                    emCashback.persist(ci);
                }
            }
            
            List<ComprobanteFormaPago> listaFP = comprobanteBean.getListaFormaPago();
            
            if(listaFP!=null && !listaFP.isEmpty()){
                for(ComprobanteFormaPago fp:listaFP){
                    fp.setIdComprobante(c);
                    fp.setNumComprobante(c.getNumComprobante());
                    emCashback.persist(fp);
                }
            }
            
            comprobanteBean.setComprobante(c);
            
        }catch(Exception e){
            resultado = "ERROR";
        }
        
        comprobanteBean.setResultado(resultado);
        
        return comprobanteBean;
    }

    @Override
    public void crearComprobante(Comprobante comprobante) {
        emCashback.persist(comprobante);
    }

    @Override
    public List<Comprobante> listarComprobantesActor(Actor cliente) {
        String jpql = "SELECT c FROM Comprobante c WHERE c.cliente =:cliente";
	Query q = emCashback.createQuery(jpql);
	q.setParameter("cliente", cliente);
	@SuppressWarnings("unchecked")
	List<Comprobante> list = (List<Comprobante>) q.getResultList();
        return list;
    }

    @Override
    public List<Comprobante> listarComprobantesLocal(Actor local) {
        String jpql = "SELECT c FROM Comprobante c WHERE c.localVenta =:local";
	Query q = emCashback.createQuery(jpql);
	q.setParameter("local", local);
	@SuppressWarnings("unchecked")
	List<Comprobante> list = (List<Comprobante>) q.getResultList();
        return list;
    }

    @Override
    public List<Comprobante> listarComprobantesLocalFecha(Actor local, String fecha) {
        String jpql = "SELECT c FROM Comprobante c WHERE c.localVenta =:local and c.fecha =:fecha";
	Query q = emCashback.createQuery(jpql);
	q.setParameter("local", local);
        q.setParameter("fecha", fecha);
	@SuppressWarnings("unchecked")
	List<Comprobante> list = (List<Comprobante>) q.getResultList();
        return list;
    }
    
    @Override
    public List<Comprobante> listarComprobantesLocalFechaComprobante(Actor local, Date fechaComprobante) {
        String jpql = "SELECT c FROM Comprobante c WHERE c.localVenta =:local and c.fechaComprobante =:fechaComprobante";
	Query q = emCashback.createQuery(jpql);
	q.setParameter("local", local);
        q.setParameter("fechaComprobante", fechaComprobante);
	@SuppressWarnings("unchecked")
	List<Comprobante> list = (List<Comprobante>) q.getResultList();
        return list;
    }
    
}
