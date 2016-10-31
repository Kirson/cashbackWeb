package com.app.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.cashback.controller.Controladores;
import com.cashback.interfaces.IActor;
import com.cashback.model.Actor;

@SessionScoped
@ManagedBean
public class PlantillaConsultaCtrl extends Controladores {
	private String latitud, longitud;
	private List<Actor> locales;

	@EJB
	private IActor sActor;

	public void nuevaBusqueda() {
		locales = new ArrayList<Actor>();
	}

	public void lectura(String catId) {
		locales = sActor.findAllCercanosByCategoria(catId, new BigDecimal(
				latitud), new BigDecimal(longitud));
		if (locales.size() == 0) {
			mostrarInfoSummary("Lo Sentimos...", "No encontramos locales cerca");
		}
	}

	public String getLatitud() {
		return latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public String getLongitud() {
		return longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	public List<Actor> getLocales() {
		return locales;
	}

	public void setLocales(List<Actor> locales) {
		this.locales = locales;
	}

}
