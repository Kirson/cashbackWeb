package com.app.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import com.cashback.controller.Controladores;
import com.cashback.interfaces.Globales;
import com.cashback.interfaces.IActor;
import com.cashback.interfaces.IActorReferencia;
import com.cashback.interfaces.IActorRol;
import com.cashback.interfaces.ICategoria;
import com.cashback.model.Actor;
import com.cashback.model.CatalogoGen;
import com.cashback.model.Categoria;
import com.cashback.interfaces.ICatalogoGen;
import com.cashback.interfaces.ILocalidad;

@SessionScoped
@ManagedBean
public class ActorCat05Ctrl extends Controladores {
	private String catIdSeleccionada = "05";
	private List<Actor> actorList;
	private CatalogoGen rolNegocio;
	private List<SelectItem> categoriaListItem;
	private Categoria categoria;

	@EJB
	private ICategoria sCategoria;
	@EJB
	private IActorRol sActorRol;
	@EJB
	private IActor sActor;
	@EJB
	private ICatalogoGen sCatalogoGen;
	@EJB
	private IActorReferencia sActoReferencia;
	@EJB
	private ILocalidad sLocalidad;

	@PostConstruct
	public void inicio() {
		categoria = sCategoria.recuperarCategoria(catIdSeleccionada);
		rolNegocio = sCatalogoGen.recuperarCatalogoGen(Globales.ROL_NEGOCIO,
				Globales.NIVEL_GRUPO_EMPRESARIAL);
		recuperarActorList();
		categoriaListItem = recuperarCategoriaListItem(catIdSeleccionada);
	}

	public void recuperarTodo() {
		catIdSeleccionada = "05";
		recuperarActorList();
	}

	public void recuperarActorList() {
		palabraClaveAct = null;
		actorList = new ArrayList<Actor>();
		actorList = findAllActores("", catIdSeleccionada);
		if (actorList.size() == 0) {
			mostrarErrorSummary("Categorias",
					"No existen registros en esta categoria");
			return;
		}
	}

	public void recuperarLocalVentaList3() {
		if (palabraClaveAct.trim().length() == 0) {
			mostrarInfoSummary("Palabra Clave",
					"Debes ingresar una palabra clave para realizar la b�squeda");
			return;
		}
		actorList = findAllActores(palabraClaveAct, "05");
		if (actorList.size() == 0) {
			mostrarErrorSummary("Palabra Clave",
					"La palabra que buscas no esta disponible en esta categoria");
			return;
		}
	}

	private List<Actor> findAllActores(String palabraClave, String catId) {
		List<Actor> actores = sActor
				.findAllByCategoriaInHijosFromRolNegocio(rolNegocio, catId,
						Globales.EST_OK, Globales.EST_OK, palabraClave);
		Collections.shuffle(actores);
		return actores;

	}

	public List<Actor> getActorList() {
		return actorList;
	}

	public void setActorList(List<Actor> actorList) {
		this.actorList = actorList;
	}

	public List<SelectItem> getCategoriaListItem() {
		return categoriaListItem;
	}

	public void setCategoriaListItem(List<SelectItem> categoriaListItem) {
		this.categoriaListItem = categoriaListItem;
	}

	public String getCatIdSeleccionada() {
		return catIdSeleccionada;
	}

	public void setCatIdSeleccionada(String catIdSeleccionada) {
		this.catIdSeleccionada = catIdSeleccionada;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
}