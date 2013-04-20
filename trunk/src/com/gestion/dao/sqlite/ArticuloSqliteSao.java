package com.gestion.dao.sqlite;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.gestion.dao.IArticuloDao;
import com.gestion.dto.Articulo;

public class ArticuloSqliteSao implements IArticuloDao {

	@Override
	public void create(Articulo entity) throws Exception {
		SqliteDaoFactory daoFactory = new SqliteDaoFactory();
		SQLiteDatabase database = daoFactory.abrir();
		ContentValues values = new ContentValues();
		values.put("nombre", entity.getNombre());
		values.put("codigo", entity.getCodigo());
		values.put("descripcion", entity.getDescripcion());
		values.put("precio", entity.getCosto());
		values.put("cantidad", entity.getCantidad());
		database.insert("Articulos", null, values);

	}

	@Override
	public Articulo retriveById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Articulo> retrieveAll() throws Exception {
		SqliteDaoFactory daoFactory = new SqliteDaoFactory();
		SQLiteDatabase database = daoFactory.abrir();
		Cursor cursor = database.query("Articulos", null, null, null, null,
				null, null);
		List<Articulo> articulos = new ArrayList<Articulo>();
		Articulo articulo;
		if (cursor.moveToFirst()) {
			do {
				articulo = new Articulo();
				int indexId = cursor.getColumnIndex("id");
				int id = cursor.getInt(indexId);
				articulo.setId(id);
				
				int indexCodigo = cursor.getColumnIndex("codigo");
				String codigo = cursor.getString(indexCodigo);
				articulo.setCodigo(codigo);
				
				int indexNombre = cursor.getColumnIndex("nombre");
				String nombre = cursor.getString(indexNombre);
				articulo.setNombre(nombre);

				int indexDescripcion = cursor.getColumnIndex("descripcion");
				String descripcion = cursor.getString(indexDescripcion);
				articulo.setDescripcion(descripcion);

				int indexPrecio = cursor.getColumnIndex("precio");
				int precio = cursor.getInt(indexPrecio);
				articulo.setCosto(precio);

				int indexCantidad = cursor.getColumnIndex("cantidad");
				int cantidad = cursor.getInt(indexCantidad);
				articulo.setCantidad(cantidad);
				articulos.add(articulo);
			} while (cursor.moveToNext());
		}
		return articulos;
	}

	@Override
	public void update(Articulo entity) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Articulo entity) throws Exception {
		// TODO Auto-generated method stub

	}

}
