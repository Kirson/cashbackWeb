/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashback.controller;

import com.cashback.bean.CadenaValorBean;
import com.cashback.beans.ActorSearch;
import com.cashback.beans.ClienteBean;
import com.cashback.beans.ComprobanteBean;
import com.cashback.ejb.interceptor.TracingInterceptor;
import com.cashback.excepciones.ExcGuardarRegistro;
import com.cashback.interfaces.Globales;
import com.cashback.interfaces.IActor;
import com.cashback.interfaces.IComprobante;
import com.cashback.interfaces.IItemGlo;
import com.cashback.interfaces.IItemLoc;
import com.cashback.interfaces.ISecuencia;
import com.cashback.interfaces.ITransaccionesActor;
import com.cashback.model.Actor;
import com.cashback.model.ActorRol;
import com.cashback.model.CatalogoGen;

import com.cashback.model.ComprobanteFormaPago;
import com.cashback.model.ComprobanteItem;
import com.cashback.model.ItemGlo;
import com.cashback.model.ItemLoc;
import com.cashback.model.PuntosActor;
import com.cashback.model.Secuencia;
import com.cashback.model.TransaccionesActor;
import com.cashback.model.Usuario;
import com.cashback.utilidades.NumberUtil;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.interceptor.Interceptors;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author somosGlobal
 */
@Interceptors(TracingInterceptor.class)
@SessionScoped
@ManagedBean
public class RegistroVentaCtr extends Controladores {

    private Actor consumidor;
    private Actor local;
    private PuntosActor puntosActor;
    private TransaccionesActor transaccionActor;
    private ComprobanteBean comprobanteBean;
    private Secuencia secuencia;
    private String numeroSecuencia;
    private ClienteBean clienteBean;
    private ActorSearch actorSearch;
    private List<ActorRol> actorRolList;
    private ActorRol actorRol;
    private ActorRol actorRolLocal;
    private List<ItemGlo> itemsGlobal;
    private List<ItemLoc> itemsLocal;
    private ItemLoc itemSeleccionado;
   

    @EJB
    private IActor sActor;


    @EJB
    private ITransaccionesActor sTransaccionesActor;

    @EJB
    private IComprobante sComprobante;

   
    @EJB
    private ISecuencia sSecuencia;

    @EJB
    private IItemGlo sItemGlo;

    @EJB
    private IItemLoc sItemLoc;

    public Actor getConsumidor() {
        return consumidor;
    }

    public void setConsumidor(Actor consumidor) {
        this.consumidor = consumidor;
    }

    public Actor getLocal() {
        return local;
    }

    public void setLocal(Actor local) {
        this.local = local;
    }

    public PuntosActor getPuntosActor() {
        return puntosActor;
    }

    public void setPuntosActor(PuntosActor puntosActor) {
        this.puntosActor = puntosActor;
    }

    public TransaccionesActor getTransaccionActor() {
        return transaccionActor;
    }

    public void setTransaccionActor(TransaccionesActor transaccionActor) {
        this.transaccionActor = transaccionActor;
    }

    public ComprobanteBean getComprobanteBean() {
        return comprobanteBean;
    }

    public void setComprobanteBean(ComprobanteBean comprobanteBean) {
        this.comprobanteBean = comprobanteBean;
    }

    public Secuencia getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(Secuencia secuencia) {
        this.secuencia = secuencia;
    }

    public String getNumeroSecuencia() {
        return numeroSecuencia;
    }

    public void setNumeroSecuencia(String numeroSecuencia) {
        this.numeroSecuencia = numeroSecuencia;
    }

    public ClienteBean getClienteBean() {
        return clienteBean;
    }

    public void setClienteBean(ClienteBean clienteBean) {
        this.clienteBean = clienteBean;
    }

    public ActorSearch getActorSearch() {
        return actorSearch;
    }

    public void setActorSearch(ActorSearch actorSearch) {
        this.actorSearch = actorSearch;
    }

    public List<ActorRol> getActorRolList() {
        return actorRolList;
    }

    public void setActorRolList(List<ActorRol> actorRolList) {
        this.actorRolList = actorRolList;
    }

    public ActorRol getActorRol() {
        return actorRol;
    }

    public void setActorRol(ActorRol actorRol) {
        this.actorRol = actorRol;
    }

    public List<ItemGlo> getItemsGlobal() {
        return itemsGlobal;
    }

    public void setItemsGlobal(List<ItemGlo> itemsGlobal) {
        this.itemsGlobal = itemsGlobal;
    }

    public List<ItemLoc> getItemsLocal() {
        return itemsLocal;
    }

    public void setItemsLocal(List<ItemLoc> itemsLocal) {
        this.itemsLocal = itemsLocal;
    }

    public ItemLoc getItemSeleccionado() {
        return itemSeleccionado;
    }

    public void setItemSeleccionado(ItemLoc itemSeleccionado) {
        this.itemSeleccionado = itemSeleccionado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public ActorRol getActorRolLocal() {
        return actorRolLocal;
    }

    public void setActorRolLocal(ActorRol actorRolLocal) {
        this.actorRolLocal = actorRolLocal;
    }
    
    

    @PostConstruct
    @SuppressWarnings("Convert2Diamond")
    public void inicio() {
        secuencia = sSecuencia.obtenerSecuencia("Comprobante");
        if (secuencia != null) {
            numeroSecuencia = formatSecuence(secuencia);
        }
        comprobanteBean = new ComprobanteBean();
        clienteBean = new ClienteBean();
        actorRolList = new ArrayList<ActorRol>();
        actorSearch = new ActorSearch();
        actorRol = new ActorRol();
        itemsGlobal = new ArrayList<ItemGlo>();
        itemsLocal = new ArrayList<ItemLoc>();

        itemsGlobal = sItemGlo.getAll();

        if (local != null) {
            itemsLocal = sItemLoc.findByLocal(local);
        } else {
            itemsLocal = sItemLoc.getAll();
        }

        itemSeleccionado = new ItemLoc();
        
        usuario = (Usuario) FacesContext.getCurrentInstance()
                .getExternalContext().getSessionMap().get("usuario");
    
        determinarLocal();
        
        transaccionActor = new TransaccionesActor();
        puntosActor = new PuntosActor();
    }
    
    private void determinarLocal(){
      if(usuario!=null){
          local=usuario.getActor();
      }
    }

    private String formatSecuence(Secuencia secuencia) {

        String num = secuencia.getSiguienteValor() + "";

        while (num.length() < secuencia.getLongitud()) {
            num = secuencia.getCaracter() + num;
        }

        return num;
    }

    public void addRow() {

        ComprobanteItem ci = new ComprobanteItem();

        this.comprobanteBean.getItems().add(ci);

    }

    public void addFormaPago() {

        ComprobanteFormaPago cfp = new ComprobanteFormaPago();

        this.comprobanteBean.getListaFormaPago().add(cfp);

    }

    public void onEditItem(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Item Edited", ((ComprobanteItem) event.getObject()).getDescripcionItem());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onCancelItem(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Item Cancelled");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        this.comprobanteBean.getItems().remove((ComprobanteItem) event.getObject());
    }

    public void onEditFP(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Forma Pago Edited", ((ComprobanteFormaPago) event.getObject()).getDescripcionFormaPago());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onCancelFP(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Forma Pago Cancelled");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        this.comprobanteBean.getListaFormaPago().remove((ComprobanteFormaPago) event.getObject());
    }

    public void buscarConsumidorLista() {
        actorRolList = sActorRol.findAllByDatosActor(actorSearch.getCedRucPasAct(),
        actorSearch.getRazonSocialAct(), actorSearch.getNombres(), actorSearch.getApellidos());
    }

    public void establecerConsumidor() {

        try{
            consumidor = sActor.recuperarActorByCedRucPas(clienteBean.getDocumento());

            if (consumidor != null) {
                consumidor.setEncontrado(Boolean.TRUE);
            } else {
                consumidor = new Actor();
                consumidor.setNombresAct(clienteBean.getNombre());
                consumidor.setApellidosAct(clienteBean.getApellido());
                consumidor.setCedrucpasAct(clienteBean.getDocumento());
                consumidor.setEncontrado(Boolean.FALSE);
                consumidor.setMailAct(clienteBean.getEmail());
                consumidor.setEstadoAct("OK");
                consumidor.setFecCreaAct(new Date());
                consumidor.setFecNacAct(clienteBean.getFechaNacimiento());
                crearConsumidor();
            }
        }catch(Exception ex){
            Logger.getLogger(RegistroVentaCtr.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al crear el consumidor");
        }
    }

    private void crearConsumidor() {

        if (consumidor != null) {
            if (!consumidor.getEncontrado()) {
                try {
                    sActor.crearActor(consumidor);
                    actorRol = new ActorRol();
                    actorRol.setActor(consumidor);
                    CatalogoGen catalogoGen = sCatalogoGen.recuperarCatalogoGen(Globales.ROL_NEGOCIO, Globales.NIVEL_CONSUMIDOR);
                    actorRol.setCatalogoGen(catalogoGen);
                    actorRol.setEstadoArol("OK");
                    actorRol.setFecCreaArol(new Date());
                    actorRol.setPrcArol(new BigDecimal(50));
                    
                    catalogoGen = sCatalogoGen.recuperarCatalogoGen(Globales.ROL_NEGOCIO, Globales.NIVEL_CONSUMIDOR);
                    if(local!=null){
                        actorRolLocal = sActorRol.recuperarActorRol(local, catalogoGen, "");
                        actorRol.setActorRol(actorRolLocal);
                    }
                    sActorRol.crearActorRol(actorRol);
                } catch (ExcGuardarRegistro ex) {
                    Logger.getLogger(RegistroVentaCtr.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    @SuppressWarnings("Convert2Diamond")
    public void limpiarDatos() {
        actorRolList = new ArrayList<ActorRol>();
        consumidor = new Actor();
        actorSearch = new ActorSearch();
        actorRol = new ActorRol();
        clienteBean = new ClienteBean();
    }

    public String seleccionarActor() {
        limpiarDatos();

        consumidor = actorRol.getActor();

        if (consumidor != null) {

            clienteBean.setNombre(consumidor.getNombresAct());
            clienteBean.setApellido(consumidor.getApellidosAct());
            clienteBean.setDocumento(consumidor.getCedrucpasAct());
            clienteBean.setFechaNacimiento(consumidor.getFecNacAct());
            clienteBean.setEmail(consumidor.getMailAct());
            clienteBean.setCelular("");
            consumidor.setEncontrado(Boolean.TRUE);
        }
        return "OK";
    }

    public void handleChange(ComprobanteItem item) {
        if(item!=null){
            System.out.println("Item no es nulo");
            
            
            if (itemSeleccionado != null) {
                System.out.println("Existe elemento seleccionado ");
                //comprobanteBean.getItems().remove(item);
                 item.setItem(itemSeleccionado);
                item.setValorItem(new BigDecimal(itemSeleccionado.getCosUniIl()));
                item.setDescripcionItem(itemSeleccionado.getNombreIl());
                if(item.getCantidad()!=null){
                    item.setValorTotal(new BigDecimal(itemSeleccionado.getCosUniIl()*item.getCantidad()));
                }else{
                    item.setValorTotal(new BigDecimal(itemSeleccionado.getCosUniIl()));
                }
                
            }
        }else{
            System.out.println("Item es nulo");
        }
        
        actualizarTotales();
    }
    
    @SuppressWarnings("UnusedAssignment")
    private void actualizarTotales(){
        
        Double iva=0D;
        Double subTotal=0D;
        Double total = 0D;
        for(ComprobanteItem ci:comprobanteBean.getItems()){
            if(ci.getValorTotal()!=null){
                subTotal = subTotal+ci.getValorTotal().doubleValue();
            }
      }
        
        subTotal = NumberUtil.round(subTotal);
        
        iva=subTotal*14/100;
        
        iva = NumberUtil.round(iva);
        
        total = subTotal+iva;
        
        total = NumberUtil.round(total);
        
        comprobanteBean.getComprobante().setValorIva(new BigDecimal(iva));
        comprobanteBean.getComprobante().setValorCompra(new BigDecimal(subTotal));
        comprobanteBean.getComprobante().setTotalCompra(new BigDecimal(total));
    }
    
    

    @SuppressWarnings("CallToPrintStackTrace")
    public String guardarComprobante() {

        String result = "OK";

        try {
            establecerConsumidor();
            
            if(local!=null){
                consumidor.setActorPadre(local);
            }

            comprobanteBean.getComprobante().setCliente(consumidor);
            comprobanteBean.getComprobante().setLocalVenta(local);
            comprobanteBean.getComprobante().setNumDocumento(consumidor.getCedrucpasAct());
            comprobanteBean.getComprobante().setNumComprobante(this.numeroSecuencia + "");

            sComprobante.guardarComprobante(comprobanteBean);

            ponerMensajeInfo("", "Comprobante registrado exitosamente");
            
            CadenaValorBean cvb = formarCadenaValor(consumidor);
            
            transaccionActor = new TransaccionesActor();
            transaccionActor.setConsumidor(consumidor);
            transaccionActor.setNumDocumentoActor(consumidor.getCedrucpasAct());
            transaccionActor.setPorcentajeDescuento(actorRol.getPrcArol());
            transaccionActor.setFechaTransaccion(new Date());
            transaccionActor.setLocalVenta(local);
            transaccionActor.setValorCompra(comprobanteBean.getComprobante().getTotalCompra());
            transaccionActor = this.calcularPuntos(transaccionActor);
            
            sTransaccionesActor.crearTransaccion(transaccionActor);
            
            actualizarPuntosCadena(cvb,transaccionActor);
            
        } catch (Exception e) {
            ponerMensajeError("", "Error al registrar comprobante");
            Logger.getLogger(RegistroVentaCtr.class.getName()).log(Level.SEVERE, null, e);
            System.out.println("Error al guardar comprobante "+e.getMessage());
            e.printStackTrace();
        }
        return result;

    }

     @SuppressWarnings("CallToPrintStackTrace")
    protected CadenaValorBean formarCadenaValor(Actor actor) {
        CadenaValorBean cvb = new CadenaValorBean();

        try {

            CatalogoGen catalogoGen = sCatalogoGen.recuperarCatalogoGen(
                    Globales.ROL_NEGOCIO, Globales.NIVEL_CONSUMIDOR);

            ActorRol consumidorRol = sActorRol.recuperarActorRol(actor, catalogoGen, "");

            if (consumidorRol != null) {
                Actor consumidorA = consumidorRol.getActor();
                consumidorA.setPorcentaje(consumidorRol.getPrcArol());
                cvb.getActores().add(consumidorA);
                cvb.getListaActorRol().add(consumidorRol);

                ActorRol localRol = consumidorRol.getActorRol();
                if (localRol != null) {
                    Actor localA = localRol.getActor();
                    localA.setPorcentaje(localRol.getPrcArol());
                    cvb.getActores().add(localA);
                    cvb.getListaActorRol().add(localRol);

                    ActorRol grupoEmpresarialRol = localRol.getActorRol();
                    if (grupoEmpresarialRol != null) {
                        Actor grupoEmpresarial = grupoEmpresarialRol.getActor();
                        grupoEmpresarial.setPorcentaje(grupoEmpresarialRol.getPrcArol());
                        cvb.getActores().add(grupoEmpresarial);
                        cvb.getListaActorRol().add(grupoEmpresarialRol);

                        ActorRol holdingRol = grupoEmpresarialRol.getActorRol();
                        if (holdingRol != null) {
                            Actor holding = holdingRol.getActor();
                            holding.setPorcentaje(holdingRol.getPrcArol());
                            cvb.getActores().add(holding);
                            cvb.getListaActorRol().add(holdingRol);

                            ActorRol supervisorHoldingRol = holdingRol.getActorRol();
                            if (supervisorHoldingRol != null) {
                                Actor supervisorHolding = supervisorHoldingRol.getActor();
                                supervisorHolding.setPorcentaje(supervisorHoldingRol.getPrcArol());
                                cvb.getActores().add(supervisorHolding);
                                cvb.getListaActorRol().add(supervisorHoldingRol);

                                ActorRol globalRol = supervisorHoldingRol.getActorRol();
                                if (globalRol != null) {
                                    Actor global = globalRol.getActor();
                                    global.setPorcentaje(globalRol.getPrcArol());
                                    cvb.getActores().add(global);
                                    cvb.getListaActorRol().add(globalRol);
                                }
                            }
                        }
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("Error formando cadena de valor " + e.getMessage());
            e.printStackTrace();
        }

        return cvb;

    }

    protected TransaccionesActor calcularPuntos(TransaccionesActor transaccion) {

        Double puntosPorcentaje = (transaccion.getPorcentajeDescuento().doubleValue() * transaccion.getValorCompra().doubleValue()) / 100;

        Integer puntos = new Double(puntosPorcentaje * 100).intValue();

        transaccion.setPuntosTransaccion(puntos);
        transaccion.setPuntosTransaccion(puntos);

        return transaccion;
    }

    protected void actualizarPuntosCadena(CadenaValorBean cadenaValor, TransaccionesActor transaccion) throws ExcGuardarRegistro {

        if (cadenaValor.getActores() != null && !cadenaValor.getActores().isEmpty()) {
            for (Actor actor : cadenaValor.getActores()) {
                List<PuntosActor> listaPuntos = sPuntosActor.recuperarPuntos(actor);
                PuntosActor puntosCadena = new PuntosActor();
                if (listaPuntos != null && !listaPuntos.isEmpty()) {
                    puntosCadena = listaPuntos.get(0);
                    puntosCadena.setTotalPuntos(puntosCadena.getTotalPuntos() + transaccion.getPuntosGanados());
                } else {
                    puntosCadena.setTotalPuntos(transaccion.getPuntosGanados());
                    puntosCadena.setActor(actor);
                }
                sPuntosActor.crearPuntos(puntosCadena);
            }

        }

    }

}
