package com.gestion.bo;

import java.util.ArrayList;
import java.util.List;

import com.gestion.R;
import com.gestion.dao.DaoFactory;
import com.gestion.dao.IArticuloDao;
import com.gestion.dao.IUsuarioDao;
import com.gestion.dto.Articulo;
import com.gestion.dto.Cliente;

public class ArticuloBo {
	private DaoFactory daoFactory = DaoFactory.getFactory(DaoFactory.SQLITE);
	private IArticuloDao articuloDao = daoFactory.getArticuloDao();

	public List<Articulo> getListado() {
		// busco en la bd todos los articulos
		try {
			return articuloDao.retrieveAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
	
	public void guardarArticulo(Articulo articulo){
		try {
			articuloDao.create(articulo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
