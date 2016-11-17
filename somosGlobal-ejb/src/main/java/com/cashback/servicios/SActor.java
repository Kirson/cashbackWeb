package com.cashback.servicios;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.cashback.enums.AppMensajes;
import com.cashback.excepciones.ExcGuardarRegistro;
import com.cashback.interfaces.Globales;
import com.cashback.interfaces.IActor;
import com.cashback.interfaces.IActorReferencia;
import com.cashback.interfaces.IActorRol;
import com.cashback.interfaces.IPerfil;
import com.cashback.interfaces.IUsuario;
import com.cashback.model.Actor;
import com.cashback.model.ActorReferencia;
import com.cashback.model.ActorRol;
import com.cashback.model.CatalogoGen;
import com.cashback.interfaces.ICatalogoGen;
import com.cashback.interfaces.ILocalidad;
import com.cashback.model.Perfil;
import com.cashback.model.Usuario;

@Stateless
public class SActor extends AbstractService implements IActor {

	@EJB
	private IPerfil SPerfil;
	@EJB
	private IUsuario sUsuario;
	@EJB
	private IActorRol sActorRol;
	@EJB
	private IActorReferencia sActorReferencia;
	@EJB
	private ILocalidad sLocalidad;
	@EJB
	private ICatalogoGen sCatalogoGen;

	@Override
	public Actor actualizarActor(Actor actor) {
		actor.setFecModAct(new Date());
		return emCashback.merge(actor);
	}

	@Override
	public boolean crearActor(Actor actor) throws ExcGuardarRegistro {
		if (recuperarActorByCedRucPas(actor.getCedrucpasAct()) != null) {
			throw new ExcGuardarRegistro(AppMensajes.ERR_REGISTRO_YA_EXISTE,
					"Actor");
		}
		actor.setFecCreaAct(new Date());
		if (actor.getRazonSocialAct() == null) {
			actor.setRazonSocialAct("");
		}
		if (actor.getNombresAct() == null) {
			actor.setNombresAct("");
		}
		if (actor.getApellidosAct() == null) {
			actor.setApellidosAct("");
		}
		emCashback.persist(actor);
		return true;
	}

	@Override
	public List<Actor> recuperarActorList(String tipoAct, String nombresAct,
			String apellidosAct, String cedrucpasAct, String estadoAct) {
		Query q = emCashback
				.createNamedQuery("Actor.findByTipoNombresApellidosCedula");
		q.setParameter("tipoAct", tipoAct + "%");
		q.setParameter("nombresAct", "%" + nombresAct + "%");
		q.setParameter("apellidosAct", "%" + apellidosAct + "%");
		q.setParameter("cedrucpasAct", cedrucpasAct + "%");
		q.setParameter("estadoAct", estadoAct + "%");
		@SuppressWarnings("unchecked")
		List<Actor> actorList = (List<Actor>) q.getResultList();
		return actorList;
	}

	@Override
	public Actor recuperarActor(int idAct) {
		Actor actor = emCashback.find(Actor.class, idAct);
		return actor;
	}

	@Override
	public Actor recuperarActorByCedRucPas(String cedrucpasAct) {
		Query q = emCashback.createNamedQuery("Actor.findByCedrucpasAct");
		q.setParameter("cedrucpasAct", cedrucpasAct);
		try {
			return (Actor) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public boolean crearActorActorRolUsuairo(Actor actor, ActorRol actorRol)
			throws ExcGuardarRegistro {
		crearActor(actor);
		actorRol.setFecCreaArol(new Date());
		emCashback.persist(actorRol);

		Usuario usuario = new Usuario();
		usuario.setActor(actor);
		Perfil perfil = null;
		if (actorRol.getCatalogoGen().getRefCg()
				.compareTo(Globales.NIVEL_CONSUMIDOR) == 0) {
			perfil = SPerfil.recuperarPerfil(Globales.CODIGO_PERFIL_CONSUMIDOR);
		} else {
			perfil = SPerfil.recuperarPerfil(Globales.CODIGO_PERFIL_ACTOR);
		}
		usuario.setPerfil(perfil);
		usuario.setUsrEstado(Globales.EST_OK);
		usuario.setUsrCreadoPor(actor.getUsrCreaAct());
		usuario.setUsrNombre(actor.getCedrucpasAct());
		usuario.setUsrNombre2(actor.getRazonSocialAct() + ""
				+ actor.getNombresAct() + " " + actor.getApellidosAct());
		usuario.setUsrCambiaPassword("S");
		String iden = actor.getCedrucpasAct();
		String pwd = iden.substring(iden.length() - 4, iden.length());
		usuario.setUsrPassword(usuario.passwordToMd5(pwd));
		sUsuario.crearUsuario(usuario);
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Actor> findAllByRolNegocioAndCategoria(CatalogoGen rolNegocio,
			String estadoArol, String catId, boolean recuperarHijos) {
		Query q = emCashback.createNamedQuery("Actor.findAllByRolNegocio");
		q.setParameter("rolNegocio", rolNegocio);
		q.setParameter("estadoArol", estadoArol + "%");
		List<Actor> actorList = (List<Actor>) q.getResultList();
		if (recuperarHijos) {
			List<Actor> actores = new ArrayList<Actor>();
			for (Actor actorPadre : actorList) {
				Query q2 = emCashback
						.createNamedQuery("Actor.findAllByPadreInRolNegocioAndCategoria");
				q2.setParameter("actor", actorPadre);
				q2.setParameter("catId", catId + "%");
				q2.setParameter("estadoArol", estadoArol + "%");
				List<Actor> actoresHijos = new ArrayList<Actor>();

				for (Actor actorHijo : (List<Actor>) q2.getResultList()) {
					actorHijo.setActorReferencias(sActorReferencia
							.findAllByActor(actorHijo));
					actoresHijos.add(actorHijo);
				}

				actorPadre.setActoresHijos(actoresHijos);
				actores.add(actorPadre);

			}
			return actores;
		} else {
			return actorList;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Actor> findAllByCategoriaInHijosFromRolNegocio(
			CatalogoGen rolNegocio, String catId, String estadoAct,
			String estadoArol, String palabraClave) {

		Query q = emCashback
				.createNamedQuery("Actor.findAllByCategoriaInHijosFromRolNegocio");
		q.setParameter("rolNegocio", rolNegocio);
		q.setParameter("catId", catId + "%");
		q.setParameter("estadoAct", estadoAct + "%");
		q.setParameter("estadoArol", estadoArol);
		q.setParameter("palabraClave", "%" + palabraClave + "%");

		List<Actor> actores = new ArrayList<Actor>();
		List<Actor> actoresPadreTemp = (List<Actor>) q.getResultList();

		for (Actor actorPadre : actoresPadreTemp) {
			Query q2 = emCashback
					.createNamedQuery("Actor.findAllByPadreInRolNegocioAndCategoria");
			q2.setParameter("actor", actorPadre);
			q2.setParameter("catId", catId + "%");
			q2.setParameter("estadoArol", estadoArol + "%");

			List<Actor> actoresHijos = new ArrayList<Actor>();
			List<Actor> actoresHijosTemp = (List<Actor>) q2.getResultList();

			for (Actor actorHijo : actoresHijosTemp) {
				actorHijo.getActorReferencias().size();
				List<ActorReferencia> telefonosActor = new ArrayList<ActorReferencia>();
				List<ActorReferencia> direccionesActor = new ArrayList<ActorReferencia>();
				List<ActorReferencia> horariosActor = new ArrayList<ActorReferencia>();
				List<ActorReferencia> correosActor = new ArrayList<ActorReferencia>();
				List<ActorReferencia> galeriaImgActor = new ArrayList<ActorReferencia>();
				List<ActorReferencia> contactosDigitalesActor = new ArrayList<ActorReferencia>();
				List<ActorReferencia> promocionImgActor = new ArrayList<ActorReferencia>();
				List<ActorReferencia> serviciosActor = new ArrayList<ActorReferencia>();

				for (ActorReferencia ar : actorHijo.getActorReferencias()) {
					String tipoCatalogo = ar.getCatalogoGen().getCatalogoGen()
							.getTipoCg();
					if (tipoCatalogo.compareTo(Globales.TELEFONO) == 0) {
						telefonosActor.add(ar);
					}

					if (tipoCatalogo.compareTo(Globales.DIRECCION) == 0) {
						ar.setLocalidad(sLocalidad.recuperarLocalidad(Integer
								.parseInt(ar.getVal1Ar())));
						direccionesActor.add(ar);
					}

					if (tipoCatalogo.compareTo(Globales.DIAS_TIPO_CATALOGO) == 0) {
						horariosActor.add(ar);
					}

					if (tipoCatalogo.compareTo(Globales.CORREO_ELECTRONICO) == 0) {
						correosActor.add(ar);
					}

					if (tipoCatalogo.compareTo(Globales.IMAGEN_TIPO_CATALOGO) == 0) {
						if (ar.getCatalogoGen().getRefCg()
								.compareTo(Globales.IMAGEN_PROMOCION) == 0) {
							promocionImgActor.add(ar);
						}
						if (ar.getCatalogoGen().getRefCg()
								.compareTo(Globales.IMAGEN_GALERIA) == 0) {
							galeriaImgActor.add(ar);
						}
					}
					if (tipoCatalogo.compareTo(Globales.CONTACTO_DIGITAL) == 0) {
						contactosDigitalesActor.add(ar);
					}
					if (tipoCatalogo
							.compareTo(Globales.SERVICIOS_TIPO_CATALOGO) == 0) {
						serviciosActor.add(ar);
					}
				}

				actorHijo.setTelefonosActor(telefonosActor);
				actorHijo.setDireccionesActor(direccionesActor);
				actorHijo.setHorariosActor(horariosActor);
				actorHijo.setCorreosActor(correosActor);
				actorHijo.setGaleriaImgActor(galeriaImgActor);
				actorHijo.setPromocionImgActor(promocionImgActor);
				actorHijo.setContactosDigitalesActor(contactosDigitalesActor);
				actorHijo.setServiciosActor(serviciosActor);
				actorHijo.setAbiertoCerrado("icon-cerrado.png");

				if (horariosActor.size() > 0) {
					Calendar fecActual = Calendar.getInstance();
					int diaActual = fecActual.get(Calendar.DAY_OF_WEEK);

					for (ActorReferencia horarioActor : horariosActor) {

						if (diaActual == Integer.parseInt(horarioActor
								.getCatalogoGen().getRef02Cg())) {
							int horaAbre = Integer.parseInt(horarioActor
									.getVal1Ar().substring(0, 2));
							int minutoAbre = Integer.parseInt(horarioActor
									.getVal1Ar().substring(3,
											horarioActor.getVal1Ar().length()));

							int horaCierra = Integer.parseInt(horarioActor
									.getVal2Ar().substring(0, 2));

							int minutoCierra = Integer.parseInt(horarioActor
									.getVal2Ar().substring(3,
											horarioActor.getVal2Ar().length()));

							Calendar insTiempoAbre = Calendar.getInstance();

							insTiempoAbre.set(Calendar.HOUR_OF_DAY, horaAbre);
							insTiempoAbre.set(Calendar.MINUTE, minutoAbre);
							insTiempoAbre.set(Calendar.SECOND, 0);

							Calendar insTiempoCierra = Calendar.getInstance();
							insTiempoCierra.set(Calendar.HOUR_OF_DAY,
									horaCierra);
							insTiempoCierra.set(Calendar.MINUTE, minutoCierra);

							if (horaCierra < horaAbre) {
								insTiempoCierra.add(Calendar.DATE, 1);
								insTiempoCierra.set(Calendar.HOUR_OF_DAY,
										horaCierra);
							}

							if (fecActual.after(insTiempoAbre)
									&& fecActual.before(insTiempoCierra)) {
								actorHijo.setAbiertoCerrado("icon-abierto.png");
							}
							break;
						}
					}
				}

				actoresHijos.add(actorHijo);
			}
			actorPadre.setActoresHijos(actoresHijos);
			actores.add(actorPadre);
		}
		return actores;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Actor> findAllByCedRucPasAndRazonSocialNombre(String cedRucPas,
			String razonSocialAct, String nombresAct, String apellidosAct,
			String estadoAct) {
		Query q = emCashback
				.createNamedQuery("Actor.findAllByCedRucPasAndRazonSocialNombre");
		q.setParameter("cedRucPas", cedRucPas + "%");
		q.setParameter("razonSocialAct", "%" + razonSocialAct + "%");
		q.setParameter("nombresAct", "%" + nombresAct + "%");
		q.setParameter("apellidosAct", "%" + apellidosAct + "%");
		q.setParameter("estadoAct", estadoAct + "%");
		return q.getResultList();
	}

	@Override
	public Actor findByIdAct(int idAct) {
		return recuperarActor(idAct);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Actor> findAllCercanosByCategoria(String catId,
			BigDecimal latitud, BigDecimal longitud) {
		String sql = "SELECT ar.id_ar, ar.id_act,"
				+ " (6371 * ACOS(SIN(RADIANS(latitud_ar)) * SIN(RADIANS(?))"
				+ " + COS(RADIANS(longitud_ar - ?)) * COS(RADIANS(latitud_ar))"
				+ " * COS(RADIANS(?)))) AS distance"
				+ " FROM actor_referencia ar, actor act"
				+ " WHERE act.cat_id LIKE ?" + " AND ar.id_act = act.id_act"
				+ " HAVING distance <= 1 ORDER BY distance ASC";
		Query q = emCashback.createNativeQuery(sql);
		q.setParameter(1, latitud);
		q.setParameter(2, longitud);
		q.setParameter(3, latitud);
		q.setParameter(4, catId + "%");
		q.getResultList();
		List<Object[]> objetos = q.getResultList();
		List<Actor> actores = new ArrayList<Actor>();

		for (Object[] obj : objetos) {
			Actor actor = new Actor();
			actor = emCashback.find(Actor.class, obj[1]);

			actor.setDistancia(new BigDecimal(obj[2].toString()).setScale(2,
					RoundingMode.HALF_EVEN));

			List<ActorReferencia> telefonosActor = new ArrayList<ActorReferencia>();
			List<ActorReferencia> direccionesActor = new ArrayList<ActorReferencia>();
			List<ActorReferencia> horariosActor = new ArrayList<ActorReferencia>();
			List<ActorReferencia> correosActor = new ArrayList<ActorReferencia>();
			List<ActorReferencia> galeriaImgActor = new ArrayList<ActorReferencia>();
			List<ActorReferencia> contactosDigitalesActor = new ArrayList<ActorReferencia>();
			List<ActorReferencia> promocionImgActor = new ArrayList<ActorReferencia>();
			List<ActorReferencia> serviciosActor = new ArrayList<ActorReferencia>();


			for (ActorReferencia ar : actor.getActorReferencias()) {

				String tipoCatalogo = ar.getCatalogoGen().getCatalogoGen()
						.getTipoCg();
				if (tipoCatalogo.compareTo(Globales.TELEFONO) == 0) {
					telefonosActor.add(ar);
				}

				if (tipoCatalogo.compareTo(Globales.DIRECCION) == 0) {
					ar.setLocalidad(sLocalidad.recuperarLocalidad(Integer
							.parseInt(ar.getVal1Ar())));
					direccionesActor.add(ar);
				}

				if (tipoCatalogo.compareTo(Globales.DIAS_TIPO_CATALOGO) == 0) {
					horariosActor.add(ar);
				}

				if (tipoCatalogo.compareTo(Globales.CORREO_ELECTRONICO) == 0) {
					correosActor.add(ar);
				}

				if (tipoCatalogo.compareTo(Globales.IMAGEN_TIPO_CATALOGO) == 0) {
					if (ar.getCatalogoGen().getRefCg()
							.compareTo(Globales.IMAGEN_PROMOCION) == 0) {
						promocionImgActor.add(ar);
					}
					if (ar.getCatalogoGen().getRefCg()
							.compareTo(Globales.IMAGEN_GALERIA) == 0) {
						galeriaImgActor.add(ar);
					}
				}
				if (tipoCatalogo.compareTo(Globales.CONTACTO_DIGITAL) == 0) {
					contactosDigitalesActor.add(ar);
				}
				
				if (tipoCatalogo
						.compareTo(Globales.SERVICIOS_TIPO_CATALOGO) == 0) {
					serviciosActor.add(ar);
				}
			}
			actor.setTelefonosActor(telefonosActor);
			actor.setDireccionesActor(direccionesActor);
			actor.setHorariosActor(horariosActor);
			actor.setCorreosActor(correosActor);
			actor.setGaleriaImgActor(galeriaImgActor);
			actor.setPromocionImgActor(promocionImgActor);
			actor.setContactosDigitalesActor(contactosDigitalesActor);
			actor.setServiciosActor(serviciosActor);
			actores.add(actor);
		}
		return actores;
	}
}
