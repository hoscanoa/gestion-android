package com.gestion.dao.sqlite;

import android.database.sqlite.SQLiteDatabase;

import com.gestion.dao.DaoFactory;
import com.gestion.dao.IArticuloDao;
import com.gestion.dao.IClienteDao;
import com.gestion.dao.IDetalleDao;
import com.gestion.dao.IUsuarioDao;
import com.gestion.dao.IVentaDao;

public class SqliteDaoFactory extends DaoFactory {
	private SQLiteDatabase database;

	@Override
	public SQLiteDatabase abrir() {
		if (database == null || !database.isOpen()) {
			String dbPath = "mnt/sdcard/curso/GestionN.sqlite";
			database = SQLiteDatabase.openDatabase(dbPath, null,
					SQLiteDatabase.OPEN_READWRITE
							| SQLiteDatabase.NO_LOCALIZED_COLLATORS);

		}
		return database;
	}

	@Override
	public void cerrar() {
		database.close();

	}

	@Override
	public void iniciarTransaccion() {
	   database.beginTransaction();

	}

	@Override
	public void commit() {
		database.setTransactionSuccessful();
		database.endTransaction();

	}

	@Override
	public void rollback() {
		// TODO Auto-generated method stub

	}

	@Override
	public void backup() {
		// TODO Auto-generated method stub

	}

	@Override
	public void restore() {
		// TODO Auto-generated method stub

	}

	@Override
	public IUsuarioDao getUsuarioDao() {
				
		return new UsuarioSqliteDao();
	}

	@Override
	public IArticuloDao getArticuloDao() {
		return new ArticuloSqliteDao();
	}
	public IClienteDao getClienteDao() {
		return new ClienteSqliteDao();
	}

	@Override
	public IVentaDao getVentaDao() {
		// TODO Auto-generated method stub
		return  new VentaSqliteDao();
	}

	@Override
	public IDetalleDao getDetalleDao() {
		// TODO Auto-generated method stub
		return  new DetalleSqliteDao();
	}

}
