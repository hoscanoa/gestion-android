package com.gestion.dao.sqlite;

import java.util.List;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.gestion.dao.IUsuarioDao;
import com.gestion.dto.Usuario;

public class UsuarioSqliteDao implements IUsuarioDao {

	@Override
	public void create(Usuario entity) throws Exception {
		SqliteDaoFactory daoFactory = new SqliteDaoFactory();
		SQLiteDatabase database = daoFactory.abrir();
		ContentValues values = new ContentValues();
		values.put("id", entity.getId());
		values.put("nombreusuario", entity.getNombreusuario());
		values.put("clave", entity.getClave());
		database.insert("Usuario", null, values);

	}

	@Override
	public Usuario retriveById(Long id) throws Exception {
		return null;
	}

	@Override
	public List<Usuario> retrieveAll() throws Exception {
		SqliteDaoFactory daoFactory = new SqliteDaoFactory();
		SQLiteDatabase database = daoFactory.abrir();
	    Cursor cursor = database.query("Usuario", null,null,null, null, null, null);
	    if (cursor.moveToFirst()){
			do {
				
			} while (cursor.moveToNext());
		}
		return null;
	}

	@Override
	public void update(Usuario entity) throws Exception {
		SqliteDaoFactory daoFactory = new SqliteDaoFactory();
		SQLiteDatabase database = daoFactory.abrir();
		ContentValues values = new ContentValues();
		values.put("nombreusuario", entity.getNombreusuario());
		values.put("clave", entity.getClave());

		database.update("usuario", values, "id = ?",
				new String[] { String.valueOf(entity.getId()) });

	}

	@Override
	public void delete(Usuario entity) throws Exception {
		SqliteDaoFactory daoFactory = new SqliteDaoFactory();
		SQLiteDatabase database = daoFactory.abrir();

		database.delete("usuario", "IdUsuario = ?",
				new String[] { String.valueOf(entity.getId()) });

	}

	@Override
	public Usuario login(String nombreUsuario, String clave) throws Exception {
		SqliteDaoFactory daoFactory = new SqliteDaoFactory();
		SQLiteDatabase database = daoFactory.abrir();
		
		Cursor cursor = database.query("Usuario", null,"nombreusuario = ? and clave = ?", new String[]{nombreUsuario,clave}, null, null, null);
		if (cursor.moveToFirst()){
			int indexId = cursor.getColumnIndex("IdUsuario");
			Long id = cursor.getLong(indexId);
			Usuario usuario = new Usuario();
			usuario.setId(id);
			return usuario;
		}else{
			return null;
		}
		
	}

}
