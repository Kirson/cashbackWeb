/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashback.controller;

import com.cashback.bean.CadenaValorBean;
import com.cashback.bean.PuntosActorBean;
import com.cashback.excepciones.ExcGuardarRegistro;
import com.cashback.interfaces.Globales;
import com.cashback.interfaces.IActor;
import com.cashback.interfaces.ITransaccionesActor;
import com.cashback.model.Actor;
import com.cashback.model.ActorRol;
import com.cashback.model.CatalogoGen;
import com.cashback.model.PuntosActor;
import com.cashback.model.TransaccionesActor;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author somosGlobal
 */
@SessionScoped
@ManagedBean
public class RegistroPuntosCtr extends Controladores {

    private PuntosActorBean puntosBean;
    private List<Actor> consumidores;
    private List<Actor> locales;
    private CatalogoGen rolNegocio;

    private Actor consumidor;
    private Actor local;
    private PuntosActor puntosActor;
    private TransaccionesActor transaccionActor;

    @EJB
    private IActor sActor;

   

    @EJB
    private ITransaccionesActor sTransaccionesActor;

   

    public PuntosActorBean getPuntosBean() {
        return puntosBean;
    }

    public void setPuntosBean(PuntosActorBean puntosBean) {
        this.puntosBean = puntosBean;
    }

    public List<Actor> getConsumidores() {
        return consumidores;
    }

    public void setConsumidores(List<Actor> consumidores) {
        this.consumidores = consumidores;
    }

    public List<Actor> getLocales() {
        return locales;
    }

    public void setLocales(List<Actor> locales) {
        this.locales = locales;
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

    public CatalogoGen getRolNegocio() {
        return rolNegocio;
    }

    public void setRolNegocio(CatalogoGen rolNegocio) {
        this.rolNegocio = rolNegocio;
    }

    public Actor getConsumidor() {
        return consumidor;
    }

    public void setConsumidor(Actor consumidor) {
        this.consumidor = consumidor;
    }
    
    

    public RegistroPuntosCtr() {
        super();
    }

    @PostConstruct
    public void inicio() {
        rolNegocio = sCatalogoGen.recuperarCatalogoGen(Globales.ROL_NEGOCIO,
                Globales.NIVEL_GRUPO_EMPRESARIAL);
        locales = sActorRol.findAllByPalabraClaveAndRolNegocio(
                "", rolNegocio);
        consumidores = sActorRol.findAllByPalabraClaveAndRolNegocio(
                "", rolNegocio);
        puntosActor = new PuntosActor();
        transaccionActor = new TransaccionesActor();
    }
    
    public void guardar(){
        
        
        try {
            transaccionActor = calcularPuntos(transaccionActor);
            if(consumidor!=null){
                List<PuntosActor> listaPuntos = sPuntosActor.recuperarPuntos(consumidor);
                if(listaPuntos!=null && !listaPuntos.isEmpty()){
                    puntosActor = listaPuntos.get(0);
                    puntosActor.setTotalPuntos(puntosActor.getTotalPuntos()+transaccionActor.getPuntosGanados());
                }else{
                    puntosActor.setTotalPuntos(transaccionActor.getPuntosGanados());
                    puntosActor.setActor(consumidor);
                }
                
                sPuntosActor.crearPuntos(puntosActor);
            }
            transaccionActor.setConsumidor(consumidor);
            sTransaccionesActor.crearTransaccion(transaccionActor);
            CadenaValorBean cvb = formarCadenaValor(consumidor);
                actualizarPuntosCadena(cvb,transaccionActor);
            
            ponerMensajeInfo("", "Puntos registrados");
        } catch (ExcGuardarRegistro ex) {
            ponerMensajeError("", "Error registrando puntos");
            Logger.getLogger(RegistroPuntosCtr.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("CallToPrintStackTrace")
    protected CadenaValorBean formarCadenaValor(Actor actor) {
        CadenaValorBean cvb = new CadenaValorBean();

        try {

            CatalogoGen catalogoGen = sCatalogoGen.recuperarCatalogoGen(
                    Globales.ROL_NEGOCIO, Globales.NIVEL_CONSUMIDOR);

            cvb.getActores().add(actor);
            
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
        transaccion.setPuntosGanados(puntos);

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
