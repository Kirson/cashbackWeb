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
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author somosGlobal
 */
@Stateless
public class SComprobante extends AbstractService implements IComprobante {

    @Override
    public ComprobanteBean guardarComprobante(ComprobanteBean comprobanteBean) {
        String resultado = "OK";
        try{
            Comprobante c = comprobanteBean.getComprobante();
            emCashback.persist(c);
            
            List<ComprobanteItem> items = comprobanteBean.getItems();
            
            if(items!=null && !items.isEmpty()){
                for(ComprobanteItem ci:items){
                    ci.setIdComprobante(c);
                    emCashback.persist(ci);
                }
            }
            
            List<ComprobanteFormaPago> listaFP = comprobanteBean.getListaFormaPago();
            
            if(listaFP!=null && !listaFP.isEmpty()){
                for(ComprobanteFormaPago fp:listaFP){
                    fp.setIdComprobante(c);
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
        String jpql = "SELECT c FROM Comprobante c WHERE c.local =:local";
	Query q = emCashback.createQuery(jpql);
	q.setParameter("local", local);
	@SuppressWarnings("unchecked")
	List<Comprobante> list = (List<Comprobante>) q.getResultList();
        return list;
    }
    
}
