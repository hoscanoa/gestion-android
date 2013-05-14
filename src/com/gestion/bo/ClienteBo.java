package com.gestion.bo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.gestion.dao.DaoFactory;
import com.gestion.dao.IArticuloDao;
import com.gestion.dao.IClienteDao;

import com.gestion.dto.Cliente;

public class ClienteBo  {
	private DaoFactory daoFactory = DaoFactory.getFactory(DaoFactory.SQLITE);
	private IClienteDao clienteDao = daoFactory.getClienteDao();
	
	public List<Cliente> getListado() {
		// busco en la bd todos los articulos
		try {
			return clienteDao.retrieveAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
	
	public void guardarCliente(Cliente articulo){
		try {
			clienteDao.create(articulo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void modificarArticulo(Cliente articulo){
		try {
			clienteDao.update(articulo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void eliminarCliente(Cliente cliente) {
		try {
			clienteDao.delete(cliente);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
   
	public List<Cliente> retriewClientes(){
    	ArrayList<Cliente>clientes = new ArrayList<Cliente>();
    	
    	Cliente cliente = new Cliente();
    	cliente.setId(10);
    	cliente.setNombre("Nicolas");
    	cliente.setApellido("Miño");
    	cliente.setCuit("2344");
    	cliente.setEmail("nico@gmail.com");
    	cliente.setEstado(true);
    	
    	clientes.add(cliente);
    	
    	cliente = new Cliente();
    	cliente.setId(11);
    	cliente.setNombre("Pepe");
    	cliente.setApellido("Ruiz");
    	cliente.setCuit("45644");
    	cliente.setEmail("pepito@gmail.com");
    	cliente.setEstado(false);
    	clientes.add(cliente);
    	
    	cliente = new Cliente();
    	cliente.setId(13);
    	cliente.setNombre("Tito");
    	cliente.setApellido("el bambino");
    	cliente.setCuit("45644");
    	cliente.setEmail("titiño@gmail.com");
    	cliente.setEstado(false);
    	clientes.add(cliente);
        
    	cliente = new Cliente();
    	cliente.setId(14);
    	cliente.setNombre("Tito");
    	cliente.setApellido("el bambino");
    	cliente.setCuit("45644");
    	cliente.setEmail("titiño@gmail.com");
    	cliente.setEstado(false);
    	clientes.add(cliente);
    	
    	cliente = new Cliente();
    	cliente.setId(15);
    	cliente.setNombre("Claudio");
    	cliente.setApellido("Ubeda");
    	cliente.setCuit("45644");
    	cliente.setEmail("titiño@gmail.com");
    	cliente.setEstado(true);
    	clientes.add(cliente);
    	
    	
    	cliente = new Cliente();
    	cliente.setId(16);
    	cliente.setNombre("Jesus");
    	cliente.setApellido("Dattolo");
    	cliente.setCuit("45644");
    	cliente.setEmail("jd@gmail.com");
    	cliente.setEstado(true);
    	clientes.add(cliente);
    	
    	
    	return clientes;
    }
	
}
