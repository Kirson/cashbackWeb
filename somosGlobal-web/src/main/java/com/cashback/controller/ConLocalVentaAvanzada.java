package com.cashback.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.ws.rs.Produces;

import org.primefaces.event.SelectEvent;

import com.cashback.enums.AppMensajes;
import com.cashback.interfaces.Globales;
import com.cashback.interfaces.IActor;
import com.cashback.interfaces.ILocalVenta;
import com.cashback.interfaces.ITextoClave;
import com.cashback.model.Actor;
import com.cashback.model.CatalogoGen;
import com.cashback.model.ICatalogoGen;
import com.cashback.model.TextoClave;
import com.google.gson.Gson;

@SessionScoped
@ManagedBean
public class ConLocalVentaAvanzada extends Controladores {
	private List<Actor> actorList;
	private String lvPalabrasClave = "", ubiPalabrasClave = "";
	private List<String> textoClaveUbiList, textoClaveUbiFilterList;
	private List<String> textoClaveLvList, textoClaveLvFilterList;
	private String testResult;

	@EJB
	private ILocalVenta sLocalVenta;
	@EJB
	private ITextoClave sTextoClave;
	@EJB
	private IActor sActor;
	@EJB
	private ICatalogoGen sCatalogoGen;

	public ConLocalVentaAvanzada() {

	}

	@PostConstruct
	public void inicio() {
		nuevaBusqueda();
	}

	public String nuevaBusqueda() {
		actorList = new ArrayList<Actor>();
		lvPalabrasClave = "";
		ubiPalabrasClave = "";
		List<TextoClave> tcList = sTextoClave.recuperarTextoClaveList("", "");
		textoClaveUbiList = new ArrayList<String>();
		textoClaveLvList = new ArrayList<String>();
		for (TextoClave tc : tcList) {
			if (tc.getTcTipo().compareTo(Globales.TC_TIPO_UBICACION) == 0) {
				textoClaveUbiList.add(tc.getTcTexto());
			}
			if (tc.getTcTipo().compareTo(Globales.TC_TIPO_LOCAL) == 0) {
				textoClaveLvList.add(tc.getTcTexto());
			}
		}
		return null;
	}

	@Produces("application/json")
	public List<String> completeUbiPalabrasClave(String query1) {
		textoClaveUbiFilterList = new ArrayList<String>();
		for (String s : textoClaveUbiList) {
			if (s.toLowerCase().contains(query1.toLowerCase())) {
				textoClaveUbiFilterList.add(s);
			}
		}
		return textoClaveUbiFilterList;
	}

	public List<String> completeLvPalabrasClave(String query2) {
		textoClaveLvFilterList = new ArrayList<String>();
		for (String s : textoClaveLvList) {
			if (s.toLowerCase().contains(query2.toLowerCase())) {
				textoClaveLvFilterList.add(s);
			}
		}
		return textoClaveLvFilterList;
	}

	public void handleSelect(SelectEvent event) {
		Object item = event.getObject();
		ubiPalabrasClave = item.toString();
	}

	public String findAllActorByPalabraClave() {
		if (lvPalabrasClave.trim().length() == 0
				&& ubiPalabrasClave.trim().length() == 0) {
			mostrarInfo(AppMensajes.INF_NO_RESULTADOS);
			return null;
		}
		CatalogoGen rolNegocio = sCatalogoGen.recuperarCatalogoGen(
				Globales.ROL_NEGOCIO, Globales.NIVEL_GRUPO_EMPRESARIAL);
		actorList = sActor.findAllByCategoriaInHijosFromRolNegocio(rolNegocio,
				"", Globales.EST_OK, Globales.EST_OK, lvPalabrasClave);
		Collections.shuffle(actorList);
		return null;
	}

	public void test() {
		List<TextoClave> tcList = sTextoClave.recuperarTextoClaveList("", "");

		for (TextoClave tc : tcList) {
			if (tc.getTcTipo().compareTo(Globales.TC_TIPO_UBICACION) == 0) {
				textoClaveUbiList.add(tc.getTcTexto());
			}
			if (tc.getTcTipo().compareTo(Globales.TC_TIPO_LOCAL) == 0) {
				textoClaveLvList.add(tc.getTcTexto());
			}
		}

		testResult = new Gson().toJson(textoClaveLvList);

	}

	public String getLvPalabrasClave() {
		return lvPalabrasClave;
	}

	public void setLvPalabrasClave(String lvPalabrasClave) {
		this.lvPalabrasClave = lvPalabrasClave;
	}

	public String getUbiPalabrasClave() {
		return ubiPalabrasClave;
	}

	public void setUbiPalabrasClave(String ubiPalabrasClave) {
		this.ubiPalabrasClave = ubiPalabrasClave;
	}

	public List<String> getTextoClaveUbiList() {
		return textoClaveUbiList;
	}

	public void setTextoClaveUbiList(List<String> textoClaveUbiList) {
		this.textoClaveUbiList = textoClaveUbiList;
	}

	public List<String> getTextoClaveLvList() {
		return textoClaveLvList;
	}

	public void setTextoClaveLvList(List<String> textoClaveLvList) {
		this.textoClaveLvList = textoClaveLvList;
	}

	public List<String> getTextoClaveUbiFilterList() {
		return textoClaveUbiFilterList;
	}

	public void setTextoClaveUbiFilterList(List<String> textoClaveUbiFilterList) {
		this.textoClaveUbiFilterList = textoClaveUbiFilterList;
	}

	public List<String> getTextoClaveLvFilterList() {
		return textoClaveLvFilterList;
	}

	public void setTextoClaveLvFilterList(List<String> textoClaveLvFilterList) {
		this.textoClaveLvFilterList = textoClaveLvFilterList;
	}

	public String getTestResult() {
		return testResult;
	}

	public void setTestResult(String testResult) {
		this.testResult = testResult;
	}

	public List<Actor> getActorList() {
		return actorList;
	}

	public void setActorList(List<Actor> actorList) {
		this.actorList = actorList;
	}

}
