package com.gestion.bo;

import com.gestion.dao.DaoFactory;
import com.gestion.dao.IVentaDao;


public class VentaBo {
	private DaoFactory daoFactory = DaoFactory.getFactory(DaoFactory.SQLITE);
	private IVentaDao ventaDao = daoFactory.getVentaDao();
}
