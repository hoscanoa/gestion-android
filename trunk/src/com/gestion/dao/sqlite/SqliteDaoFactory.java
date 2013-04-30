package com.gestion.dao.sqlite;

import android.database.sqlite.SQLiteDatabase;

import com.gestion.dao.DaoFactory;
import com.gestion.dao.IArticuloDao;
import com.gestion.dao.IClienteDao;
import com.gestion.dao.IUsuarioDao;

public class SqliteDaoFactory extends DaoFactory {
	private SQLiteDatabase database;

	@Override
	public SQLiteDatabase abrir() {
		if (database == null || !database.isOpen()) {
			String dbPath = "mnt/sdcard/curso/gestion.sqlite";
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
		return new ArticuloSqliteSao();
	}

	@Override
	public IClienteDao getClienteDao() {
		// TODO Auto-generated method stub
		return null;
	}

}
