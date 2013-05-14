package com.gestion.dao.sqlite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.gestion.bo.LocalidadBo;
import com.gestion.dao.IClienteDao;
import com.gestion.dto.Articulo;
import com.gestion.dto.Cliente;
import com.gestion.dto.Localidad;
import com.gestion.dto.Provincia;

public class ClienteSqliteDao implements IClienteDao {



	@Override
	public void create(Cliente entity) throws Exception {
		SqliteDaoFactory daoFactory = new SqliteDaoFactory();
		SQLiteDatabase database = daoFactory.abrir();
		ContentValues values = new ContentValues();
		
		values.put("nombre", entity.getNombre());
		values.put("apellido", entity.getApellido());
		values.put("email", entity.getEmail());
		values.put("cuit", entity.getCuit());
		values.put("razonsocial", entity.getRazonSocial());
		values.put("telefono", entity.getTelefono());
		values.put("localidaId", entity.getLocalidad().getId());
		values.put("domicilio", entity.getDomicilioValue());
		values.put("estado", 1);
		database.insert("Cliente", null, values);
		database.close();
	}

	@Override
	public Cliente retriveById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> retrieveAll() throws Exception {
		SqliteDaoFactory daoFactory = new SqliteDaoFactory();
		SQLiteDatabase database = daoFactory.abrir();

		Cursor cursor = database.query("Cliente", null, null, null, null, null,
				null);

		List<Cliente> clientess = new ArrayList<Cliente>();

		Cliente cliente;
		boolean estado;
		Localidad localidad;
		List<Localidad> localidades = new ArrayList<Localidad>();
		LocalidadBo mlocalidad;
		mlocalidad = new LocalidadBo();
		localidades = mlocalidad.devolverLocalidad();
		Iterator<Localidad> iterador;
		if (cursor.moveToFirst()) {
			do {

				cliente = new Cliente();
				int indexId = cursor.getColumnIndex("IdCliente");
				int id = cursor.getInt(indexId);
				cliente.setId(id);

				int indexNombre = cursor.getColumnIndex("nombre");
				String nombre = cursor.getString(indexNombre);
				cliente.setNombre(nombre);

				int indexApellido = cursor.getColumnIndex("apellido");
				String apellido = cursor.getString(indexApellido);
				cliente.setApellido(apellido);

				int indexEmail = cursor.getColumnIndex("email");
				String email = cursor.getString(indexEmail);
				cliente.setEmail(email);

				int indexCuit = cursor.getColumnIndex("cuit");
				String cuit = cursor.getString(indexCuit);
				cliente.setCuit(cuit);

				int indexCantidad = cursor.getColumnIndex("domicilio");
				String domicilio = cursor.getString(indexCantidad);
				cliente.setDomicilioValue(domicilio);

				int indexEstado = cursor.getColumnIndex("estado");
				int estadoaux = cursor.getInt(indexEstado);
				if (estadoaux == 1) {
					estado = true;
				} else {
					estado = false;
				}
				cliente.setEstado(estado);

				int indexRazonSoc = cursor.getColumnIndex("razonsocial");
				String razonSoc = cursor.getString(indexRazonSoc);
				cliente.setRazonSocial(razonSoc);

				int indexTelelefono = cursor.getColumnIndex("telefono");
				String telefono = cursor.getString(indexTelelefono);
				cliente.setTelefono(telefono);

				int indexLocalidad = cursor.getColumnIndex("localidaId");
				int local = cursor.getInt(indexLocalidad);

				// / busco la localidad por el Id caracha que trae del hijo de
				// un conteiner de putas del cliente.

				iterador = localidades.iterator();

				do {
					localidad = iterador.next();
					if (localidad.getId() == local) {
						cliente.setLocalidad(localidad);
					}

				} while (iterador.hasNext());

				clientess.add(cliente);
			} while (cursor.moveToNext());
		}
		cursor.close();
		daoFactory.cerrar();
		return clientess;

	}

	@Override
	public void update(Cliente entity) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Cliente entity) throws Exception {
		SqliteDaoFactory daoFactory = new SqliteDaoFactory();
		SQLiteDatabase database = daoFactory.abrir();

		database.delete("Cliente", "IdCliente = ?",
				new String[] { String.valueOf(entity.getId()) });

		database.close();

	}

}
