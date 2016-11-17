package com.cashback.interfaces;

import com.cashback.model.Localidad;
import java.util.List;

public interface ILocalidad {

	List<Localidad> recuperarLocalidad(Localidad localidad);

	Localidad recuperarLocalidad(int locId);
}
