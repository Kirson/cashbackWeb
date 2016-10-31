package com.app.controller;

import java.util.Collections;
import java.util.List;

import javax.ejb.EJB;

import com.cashback.interfaces.Globales;
import com.cashback.interfaces.IActor;
import com.cashback.model.Actor;
import com.cashback.model.CatalogoGen;
import com.cashback.model.ICatalogoGen;

public class BusquedaAvanzadaCtrl {

	private String palabraClave;
	private List<Actor> actorList;

	@EJB
	private IActor sActor;
	@EJB
	private ICatalogoGen sCatalogoGen;

	public void findAllActoresByPalabraClave() {
	
	}

	public List<Actor> getActorList() {
		return actorList;
	}

	public void setActorList(List<Actor> actorList) {
		this.actorList = actorList;
	}

	public String getPalabraClave() {
		return palabraClave;
	}

	public void setPalabraClave(String palabraClave) {
		this.palabraClave = palabraClave;
	}

}
