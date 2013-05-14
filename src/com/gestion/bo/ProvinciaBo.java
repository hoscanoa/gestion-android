package com.gestion.bo;

import java.util.ArrayList;
import java.util.List;

import com.gestion.dto.Provincia;



public class ProvinciaBo {

	 public Provincia prov;
	
	
	public ArrayList<Provincia> devolverProvincia() {
ArrayList<Provincia> provincias = new ArrayList<Provincia>();
		
		prov = new Provincia();
		prov.setId(1);
		prov.setNombre("Corrientes");
		provincias.add(prov);
		prov = new Provincia();
		prov.setId(2);
		prov.setNombre("Chaco");
		provincias.add(prov);
		prov = new Provincia();
		prov.setId(3);
		prov.setNombre("Formosa");
		provincias.add(prov);
		prov = new Provincia();
		prov.setId(4);
		prov.setNombre("Misiones");
		provincias.add(prov);
		
				
		return provincias; 
	}

	
	}

