package com.gestion.dao;

import com.gestion.dao.sqlite.SqliteDaoFactory;

public abstract class DaoFactory {

	public static final int SQLITE = 0;

	public static final DaoFactory getFactory(int factory) {
		switch (factory) {
		case SQLITE:
			return new SqliteDaoFactory();
		default:
			break;
		}
		return null;
	}

	public abstract Object abrir();

	public abstract void cerrar();

	public abstract void iniciarTransaccion();

	public abstract void commit();

	public abstract void rollback();

	public abstract void backup();

	public abstract void restore();
	
	public abstract IUsuarioDao getUsuarioDao();
	
	public abstract IArticuloDao getArticuloDao();
	
	public abstract IVentaDao getVentaDao();
	
	public abstract IDetalleDao getDetalleDao();
	
	public abstract IClienteDao getClienteDao();

}
