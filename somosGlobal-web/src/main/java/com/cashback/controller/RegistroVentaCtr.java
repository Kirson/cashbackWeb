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
import com.cashback.interfaces.IFormaPago;
import com.cashback.interfaces.IItemGlo;
import com.cashback.interfaces.IItemLoc;
import com.cashback.interfaces.ISecuencia;
import com.cashback.interfaces.ITransaccionesActor;
import com.cashback.model.Actor;
import com.cashback.model.ActorRol;
import com.cashback.model.CatalogoGen;

import com.cashback.model.ComprobanteFormaPago;
import com.cashback.model.ComprobanteItem;
import com.cashback.model.FormaPago;
import com.cashback.model.ItemGlo;
import com.cashback.model.ItemLoc;
import com.cashback.model.PuntosActor;
import com.cashback.model.Secuencia;
import com.cashback.model.TransaccionesActor;
import com.cashback.model.Usuario;
import com.cashback.utilidades.DateUtil;
import com.cashback.utilidades.NumberUtil;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.interceptor.Interceptors;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
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
    private List<FormaPago> listaFormaPago;
    private FormaPago formaPagoSeleccionada;
    private Boolean disable = false;
    private String mensajePuntos;
    private ComprobanteItem comprobanteItem;
    private ComprobanteFormaPago comprobanteFormaPago;

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

    @EJB
    private IFormaPago sFormaPago;

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

    public List<FormaPago> getListaFormaPago() {
        return listaFormaPago;
    }

    public void setListaFormaPago(List<FormaPago> listaFormaPago) {
        this.listaFormaPago = listaFormaPago;
    }

    public FormaPago getFormaPagoSeleccionada() {
        return formaPagoSeleccionada;
    }

    public void setFormaPagoSeleccionada(FormaPago formaPagoSeleccionada) {
        this.formaPagoSeleccionada = formaPagoSeleccionada;
    }

    public Boolean getDisable() {
        return disable;
    }

    public void setDisable(Boolean disable) {
        this.disable = disable;
    }

    public String getMensajePuntos() {
        return mensajePuntos;
    }

    public void setMensajePuntos(String mensajePuntos) {
        this.mensajePuntos = mensajePuntos;
    }


    public ComprobanteItem getComprobanteItem() {
        return comprobanteItem;
    }

    public void setComprobanteItem(ComprobanteItem comprobanteItem) {
        this.comprobanteItem = comprobanteItem;
    }

    public ComprobanteFormaPago getComprobanteFormaPago() {
        return comprobanteFormaPago;
    }

    public void setComprobanteFormaPago(ComprobanteFormaPago comprobanteFormaPago) {
        this.comprobanteFormaPago = comprobanteFormaPago;
    }


    @PostConstruct
    @SuppressWarnings("Convert2Diamond")
    public void inicio() {
        obtenerSecuencia();
        comprobanteBean = new ComprobanteBean();
        clienteBean = new ClienteBean();
        actorRolList = new ArrayList<ActorRol>();
        actorSearch = new ActorSearch();
        actorRol = new ActorRol();
        itemsGlobal = new ArrayList<ItemGlo>();
        itemsLocal = new ArrayList<ItemLoc>();
        comprobanteItem = new ComprobanteItem();
        comprobanteFormaPago = new ComprobanteFormaPago();
        mensajePuntos = "";

        itemsGlobal = sItemGlo.getAll();

        usuario = (Usuario) FacesContext.getCurrentInstance()
                .getExternalContext().getSessionMap().get("usuario");

        determinarLocal();

        if (local != null) {
            itemsLocal = sItemLoc.findByLocal(local);

            //solo por desarrollo
            if (itemsLocal == null || itemsLocal.isEmpty()) {
                itemsLocal = sItemLoc.getAll();
            }
        } else {
            itemsLocal = sItemLoc.getAll();

        }

        itemSeleccionado = new ItemLoc();

        transaccionActor = new TransaccionesActor();
        puntosActor = new PuntosActor();

        listaFormaPago = new ArrayList<FormaPago>();

        listaFormaPago = sFormaPago.getAll();

        formaPagoSeleccionada = new FormaPago();

        disable = false;
    }

    private void obtenerSecuencia() {
        secuencia = sSecuencia.obtenerSecuencia("Comprobante");
        if (secuencia != null) {
            numeroSecuencia = formatSecuence(secuencia);
        }

    }

    private void determinarLocal() {
        if (usuario != null) {
            local = usuario.getActor();
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

    public void addItem() {
        this.comprobanteBean.getItems().add(comprobanteItem);
        actualizarTotales();
    }

    public void addFormaPago() {

        ComprobanteFormaPago cfp = new ComprobanteFormaPago();

        this.comprobanteBean.getListaFormaPago().add(cfp);

    }
    
    public void newFP(){
        comprobanteFormaPago = new ComprobanteFormaPago();
        formaPagoSeleccionada = new FormaPago();
    }
    
    public void addFP(){
        comprobanteBean.getListaFormaPago().add(comprobanteFormaPago);
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

    public void buscarConsumidor() {
        if (clienteBean.getDocumento() != null) {
            CatalogoGen catalogoGen = sCatalogoGen.recuperarCatalogoGen(
                    Globales.ROL_NEGOCIO, Globales.NIVEL_CONSUMIDOR);
            consumidor = sActor.recuperarActorByCedRucPas(clienteBean.getDocumento());
            if (consumidor == null) {
                ponerMensajeInfo("", "No existe el cliente con documento " + clienteBean.getDocumento() + " registrado en la base de datos. Al registrar la compra el cliente quedará almacenado en el sistema");
                consumidor = new Actor();
            } else {
                actorRol = sActorRol.recuperarActorRol(consumidor, catalogoGen, "");
                clienteBean.setNombre(consumidor.getNombresAct());
                clienteBean.setApellido(consumidor.getApellidosAct());
                clienteBean.setDocumento(consumidor.getCedrucpasAct());
                clienteBean.setFechaNacimiento(consumidor.getFecNacAct());
                clienteBean.setEmail(consumidor.getMailAct());
                clienteBean.setTelefono(consumidor.getTelefonoPrincipal());
                if (consumidor.getTelefonosActor() != null && !consumidor.getTelefonosActor().isEmpty()) {
                    clienteBean.setCelular(consumidor.getTelefonosActor().get(0).getVal1Ar());
                }
                consumidor.setEncontrado(Boolean.TRUE);

                PuntosActor puntosConsulta = sPuntosActor.recuperarPuntos(consumidor);
                int puntos = 0;
                if (puntosConsulta != null) {
                    puntos = puntosConsulta.getTotalPuntos();
                }
                clienteBean.setPuntos(puntos);

                mensajePuntos = "El usuario " + consumidor.getNombresAct() + "  " + consumidor.getApellidosAct() + " dispone de " + puntos + " puntos";
            }
        }
    }

    public void establecerConsumidor() {

        try {
            consumidor = sActor.recuperarActorByCedRucPas(clienteBean.getDocumento());

            if (consumidor != null) {
                consumidor.setEncontrado(Boolean.TRUE);
                CatalogoGen catalogoGen = sCatalogoGen.recuperarCatalogoGen(
                        Globales.ROL_NEGOCIO, Globales.NIVEL_CONSUMIDOR);

                actorRol = sActorRol.recuperarActorRol(consumidor, catalogoGen, "");

                consumidor.setNombresAct(clienteBean.getNombre());
                consumidor.setApellidosAct(clienteBean.getApellido());
                consumidor.setCedrucpasAct(clienteBean.getDocumento());
                consumidor.setMailAct(clienteBean.getEmail());
                consumidor.setEstadoAct("OK");
                consumidor.setFecNacAct(clienteBean.getFechaNacimiento());
                consumidor.setTelefonoPrincipal(clienteBean.getTelefono());

                sActor.actualizarActor(consumidor);

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
                consumidor.setTelefonoPrincipal(clienteBean.getTelefono());
                crearConsumidor();
            }
        } catch (Exception ex) {
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
                    if (local != null) {
                        actorRolLocal = sActorRol.recuperarActorRol(local, catalogoGen, "");
                        actorRol.setActorRol(actorRolLocal);
                    }
                    sActorRol.crearActorRol(actorRol);
                } catch (ExcGuardarRegistro ex) {
                    Logger.getLogger(RegistroVentaCtr.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                CatalogoGen catalogoGen = sCatalogoGen.recuperarCatalogoGen(
                        Globales.ROL_NEGOCIO, Globales.NIVEL_CONSUMIDOR);

                actorRol = sActorRol.recuperarActorRol(consumidor, catalogoGen, "");
            }
        }

    }

    @SuppressWarnings("Convert2Diamond")
    public void limpiar() {
        limpiarDatos();
        comprobanteBean = new ComprobanteBean();
        disable = false;
        clienteBean = new ClienteBean();
        obtenerSecuencia();
        mensajePuntos = "";
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
            clienteBean.setCelular(consumidor.getTelefonoPrincipal());
            consumidor.setEncontrado(Boolean.TRUE);
        }
        return "OK";
    }

    public void handleProductChange() {

        if (itemSeleccionado != null) {
            System.out.println("Existe elemento seleccionado ");
            comprobanteItem.setItem(itemSeleccionado);
            comprobanteItem.setValorItem(new BigDecimal(itemSeleccionado.getCosUniIl()));
            comprobanteItem.setDescripcionItem(itemSeleccionado.getNombreIl());

            if (comprobanteItem.getCantidad() != null) {
                comprobanteItem.setValorTotal(new BigDecimal(itemSeleccionado.getCosUniIl() * comprobanteItem.getCantidad()));
            } else {
                comprobanteItem.setValorTotal(new BigDecimal(itemSeleccionado.getCosUniIl()));
            }

            actualizarTotales();
        } else {
            this.ponerMensajeInfo("", "Debe seleccionar un producto");
        }

    }

    public void handleChange(ComprobanteItem item) {
        if (item != null) {
            System.out.println("Item no es nulo");

            if (itemSeleccionado != null) {
                System.out.println("Existe elemento seleccionado ");
                //comprobanteBean.getItems().remove(item);
                item.setItem(itemSeleccionado);
                item.setValorItem(new BigDecimal(itemSeleccionado.getCosUniIl()));
                item.setDescripcionItem(itemSeleccionado.getNombreIl());
                if (item.getCantidad() != null) {
                    item.setValorTotal(new BigDecimal(itemSeleccionado.getCosUniIl() * item.getCantidad()));
                } else {
                    item.setValorTotal(new BigDecimal(itemSeleccionado.getCosUniIl()));
                }

            }
        } else {
            System.out.println("Item es nulo");
        }

        actualizarTotales();
    }

    public void handlePayWay(ComprobanteFormaPago formaPago) {
        if (formaPago != null) {
            System.out.println("FormaPago no es nulo");

            if (formaPagoSeleccionada != null) {
                System.out.println("Existe elemento seleccionado ");
                formaPago.setFormaPago(formaPagoSeleccionada);
                formaPago.setDescripcionFormaPago(formaPagoSeleccionada.getNombreForPag());
                formaPago.setValorFormaPago(comprobanteBean.getComprobante().getTotalCompra());
            }
        } else {
            System.out.println("FormaPago es nulo");
        }

    }
    
    
    
    
    public void pagarConPuntos() throws ExcGuardarRegistro{
        Integer puntosTotales = new Double(comprobanteBean.getComprobante().getTotalCompra().doubleValue() * 100).intValue();
        PuntosActor puntosConsulta = sPuntosActor.recuperarPuntos(consumidor);
        if(puntosConsulta.getTotalPuntos()>puntosTotales){
            Integer temPuntos = puntosConsulta.getTotalPuntos() - puntosTotales;
            puntosConsulta.setTotalPuntos(temPuntos);
            sPuntosActor.actualizarPuntos(puntosActor);
            
            TransaccionesActor transActor = new TransaccionesActor();
            transActor.setConsumidor(consumidor);
            transActor.setNumDocumentoActor(consumidor.getCedrucpasAct());
            transActor.setPorcentajeDescuento(actorRol.getPrcArol());
            transActor.setFechaTransaccion(new Date());
            transActor.setLocalVenta(local);
            transActor.setValorCompra(comprobanteBean.getComprobante().getTotalCompra());
            transActor.setPuntosTransaccion(puntosTotales);
            transActor.setUsuario(usuario);
            transActor.setSigno("NEGATIVO");
            transActor.setTipo("PAGO");
            transActor.setNumeroComprobante(comprobanteBean.getComprobante().getNumComprobante());

            sTransaccionesActor.crearTransaccion(transActor);
            this.ponerMensajeInfo("", "Pago con puntos realizado exitosamente. Se debitaron " + puntosTotales +" puntos.");
            
        }else{
            this.ponerMensajeInfo("", "No cuenta con puntos suficientes para el pago");
        }
    }
    
    public void handlePW() {
          if (formaPagoSeleccionada != null) {
                System.out.println("Existe elemento forma de pago seleccionado ");
                comprobanteFormaPago.setFormaPago(formaPagoSeleccionada);
                comprobanteFormaPago.setDescripcionFormaPago(formaPagoSeleccionada.getNombreForPag());
          }else{
              this.ponerMensajeInfo("", "Debe seleccionar una forma de pago");
          }
        

    }

    @SuppressWarnings("UnusedAssignment")
    public void actualizarTotales() {

        Double iva = 0D;
        Double subTotal = 0D;
        Double total = 0D;
        for (ComprobanteItem ci : comprobanteBean.getItems()) {
            Double itemSubTotal = 0D;
            if (ci.getValorItem() != null) {
                itemSubTotal = ci.getCantidad() * ci.getValorItem().doubleValue();
                itemSubTotal = NumberUtil.round(itemSubTotal);
                subTotal = subTotal + itemSubTotal;
                ci.setValorTotal(new BigDecimal(itemSubTotal));
            }

            subTotal = NumberUtil.round(subTotal);
        }

        subTotal = NumberUtil.round(subTotal);

        iva = subTotal * 14 / 100;

        iva = NumberUtil.round(iva);

        total = subTotal + iva;

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

            if (local != null) {
                consumidor.setActorPadre(local);
            }

            comprobanteBean.getComprobante().setCliente(consumidor);
            comprobanteBean.getComprobante().setLocalVenta(local);
            comprobanteBean.getComprobante().setNumDocumento(consumidor.getCedrucpasAct());
            comprobanteBean.getComprobante().setNumComprobante(this.numeroSecuencia + "");
            comprobanteBean.getComprobante().setFechaComprobante(new Date());
            comprobanteBean.getComprobante().setFecha(DateUtil.fromDateToString(new Date()));
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
            transaccionActor.setUsuario(usuario);
            transaccionActor.setNumeroComprobante(comprobanteBean.getComprobante().getNumComprobante());

            sTransaccionesActor.crearTransaccion(transaccionActor);

            PuntosActor puntosConsulta = sPuntosActor.recuperarPuntos(consumidor);
            PuntosActor puntosConsumidor = new PuntosActor();
            if (puntosConsulta != null) {
                puntosConsumidor = puntosConsulta;
                Integer puntosActuales = puntosConsumidor.getTotalPuntos();
                puntosConsumidor.setTotalPuntos(transaccionActor.getPuntosTransaccion() + puntosActuales);
                sPuntosActor.actualizarPuntos(puntosConsumidor);
            } else {
                puntosConsumidor.setActor(consumidor);
                puntosConsumidor.setNumDocumentoActor(consumidor.getCedrucpasAct());
                puntosConsumidor.setTotalPuntos(transaccionActor.getPuntosTransaccion());
                puntosConsumidor.setUsuario(usuario);
                sPuntosActor.crearPuntos(puntosConsumidor);
            }

            actualizarPuntosCadena(cvb, transaccionActor);

            disable = true;

            
            if(comprobanteBean.getPagaConPuntos()){
                pagarConPuntos();
            }


        } catch (Exception e) {
            ponerMensajeError("", "Error al registrar comprobante");
            Logger.getLogger(RegistroVentaCtr.class.getName()).log(Level.SEVERE, null, e);
            System.out.println("Error al guardar comprobante " + e.getMessage());
            e.printStackTrace();
            disable = false;
        }
        return result;

    }

    public void newItem() {
        comprobanteItem = new ComprobanteItem();
        itemSeleccionado = new ItemLoc();
    }

    @SuppressWarnings("CallToPrintStackTrace")
    protected CadenaValorBean formarCadenaValor(Actor actor) {
        CadenaValorBean cvb = new CadenaValorBean();

        try {

            CatalogoGen catalogoGen = sCatalogoGen.recuperarCatalogoGen(
                    Globales.ROL_NEGOCIO, Globales.NIVEL_CONSUMIDOR);

            ActorRol consumidorRol = sActorRol.recuperarActorRol(actor, catalogoGen, "");

            cvb.getActores().add(actor);

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
        transaccion.setPuntosGanados(puntos);

        return transaccion;
    }

    protected void actualizarPuntosCadena(CadenaValorBean cadenaValor, TransaccionesActor transaccion) throws ExcGuardarRegistro {

        if (cadenaValor.getActores() != null && !cadenaValor.getActores().isEmpty()) {
            for (Actor actor : cadenaValor.getActores()) {
                if (!actor.equals(consumidor)) {
                    try {
                        PuntosActor puntosConsulta = sPuntosActor.recuperarPuntos(actor);
                        PuntosActor puntosCadena = new PuntosActor();
                        if (puntosConsulta != null) {
                            puntosCadena = puntosConsulta;
                            puntosCadena.setTotalPuntos(puntosCadena.getTotalPuntos() + transaccion.getPuntosGanados());
                            sPuntosActor.actualizarPuntos(puntosCadena);
                        } else {
                            puntosCadena.setTotalPuntos(transaccion.getPuntosGanados());
                            puntosCadena.setActor(actor);
                            sPuntosActor.crearPuntos(puntosCadena);
                        }

                        TransaccionesActor transaccionCadena = new TransaccionesActor();
                        transaccionCadena.setConsumidor(actor);
                        transaccionCadena.setNumDocumentoActor(actor.getCedrucpasAct());
                        transaccionCadena.setPorcentajeDescuento(actor.getPorcentaje());
                        transaccionCadena.setFechaTransaccion(new Date());
                        transaccionCadena.setLocalVenta(local);
                        transaccionCadena.setValorCompra(comprobanteBean.getComprobante().getTotalCompra());
                        transaccionCadena = this.calcularPuntos(transaccionCadena);
                        transaccionCadena.setNumeroComprobante(comprobanteBean.getComprobante().getNumComprobante());
                        transaccionCadena.setUsuario(usuario);
                        System.out.println("porDesc" + actor.getPorcentaje());
                        System.out.println("totalCompra" + comprobanteBean.getComprobante().getTotalCompra());
                        
                        sTransaccionesActor.crearTransaccion(transaccionCadena);
                    } catch (EJBException e) {
                        @SuppressWarnings("ThrowableResultIgnored")
                        Exception cause = e.getCausedByException();
                        if (cause instanceof ConstraintViolationException) {
                            @SuppressWarnings("ThrowableResultIgnored")
                            ConstraintViolationException cve = (ConstraintViolationException) e.getCausedByException();
                            for (ConstraintViolation<? extends Object> v : cve.getConstraintViolations()) {
                                System.err.println(v);
                                System.err.println("==>>" + v.getMessage());
                            }
                        }
                        System.err.println("ejb exception");
                    }


                    TransaccionesActor transaccionCadena = new TransaccionesActor();
                    transaccionCadena.setConsumidor(actor);
                    transaccionCadena.setNumDocumentoActor(actor.getCedrucpasAct());
                    transaccionCadena.setPorcentajeDescuento(actor.getPorcentaje());
                    transaccionCadena.setFechaTransaccion(new Date());
                    transaccionCadena.setLocalVenta(local);
                    transaccionCadena.setValorCompra(comprobanteBean.getComprobante().getTotalCompra());
                    transaccionCadena = this.calcularPuntos(transaccionCadena);
                    transaccionCadena.setNumeroComprobante(comprobanteBean.getComprobante().getNumComprobante());
                    transaccionCadena.setUsuario(usuario);
                    sTransaccionesActor.crearTransaccion(transaccionCadena);

                }//fin de actor no es consumidor

            }//fin de for
        }//fin de cadena de valor

    }

}
