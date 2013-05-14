package com.gestion.bo;

import java.util.ArrayList;

import com.gestion.dto.Localidad;

public class LocalidadBo {
	public Localidad localidad;

	public ArrayList<Localidad> devolverLocalidad() {
		ArrayList<Localidad> localidades = new ArrayList<Localidad>();

		localidad = new Localidad();

		localidad.setId(1);
		localidad.setDescripcion("Corrientes");
		localidad.setCodigoPostal("3400");

		localidades.add(localidad);

		localidad = new Localidad();

		localidad.setId(2);
		localidad.setDescripcion("resistencia");
		localidad.setCodigoPostal("3402");

		localidades.add(localidad);

		localidad = new Localidad();
		localidad.setId(3);
		localidad.setDescripcion("Paso de la Patria");
		localidad.setCodigoPostal("3405");

		localidades.add(localidad);

		localidad = new Localidad();
		localidad.setId(4);
		localidad.setDescripcion("Posadas");
		localidad.setCodigoPostal("3400");

		localidades.add(localidad);

		localidad = new Localidad();
		localidad.setId(5);
		localidad.setDescripcion("Clorinda");
		localidad.setCodigoPostal("3444");

		localidades.add(localidad);

		return localidades;
	}
}