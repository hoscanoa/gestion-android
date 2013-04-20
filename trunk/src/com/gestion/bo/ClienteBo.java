package com.gestion.bo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.gestion.dto.Cliente;

public class ClienteBo {
 
    public List<Cliente> retriewClientes(){
    	ArrayList<Cliente>clientes = new ArrayList<Cliente>();
    	
    	Cliente cliente = new Cliente();
    	cliente.setNombre("Nicolas");
    	cliente.setApellido("Miño");
    	cliente.setCiut("2344");
    	cliente.setEmail("nico@gmail.com");
    	cliente.setEstado(true);
    	
    	clientes.add(cliente);
    	
    	cliente = new Cliente();
    	cliente.setNombre("Pepe");
    	cliente.setApellido("Ruiz");
    	cliente.setCiut("45644");
    	cliente.setEmail("pepito@gmail.com");
    	cliente.setEstado(false);
    	clientes.add(cliente);
    	
    	cliente = new Cliente();
    	cliente.setNombre("Tito");
    	cliente.setApellido("el bambino");
    	cliente.setCiut("45644");
    	cliente.setEmail("titiño@gmail.com");
    	cliente.setEstado(false);
    	clientes.add(cliente);
        
    	cliente = new Cliente();
    	cliente.setNombre("Tito");
    	cliente.setApellido("el bambino");
    	cliente.setCiut("45644");
    	cliente.setEmail("titiño@gmail.com");
    	cliente.setEstado(false);
    	clientes.add(cliente);
    	
    	cliente = new Cliente();
    	cliente.setNombre("Claudio");
    	cliente.setApellido("Ubeda");
    	cliente.setCiut("45644");
    	cliente.setEmail("titiño@gmail.com");
    	cliente.setEstado(true);
    	clientes.add(cliente);
    	
    	
    	cliente = new Cliente();
    	cliente.setNombre("Jesus");
    	cliente.setApellido("Dattolo");
    	cliente.setCiut("45644");
    	cliente.setEmail("jd@gmail.com");
    	cliente.setEstado(true);
    	clientes.add(cliente);
    	
    	cliente = new Cliente();
    	cliente.setNombre("Barbara");
    	cliente.setApellido("Cruz");
    	cliente.setCiut("3445544");
    	cliente.setEmail("barbi@gmail.com");
    	cliente.setEstado(true);
    	clientes.add(cliente);
    	
    	cliente = new Cliente();
    	cliente.setNombre("Mariano");
    	cliente.setApellido("Miño");
    	cliente.setCiut("3445544");
    	cliente.setEmail("marian@gmail.com");
    	cliente.setEstado(true);
    	clientes.add(cliente);
    	
    	cliente = new Cliente();
    	cliente.setNombre("Leonardo");
    	cliente.setApellido("Miño");
    	cliente.setCiut("3445544");
    	cliente.setEmail("leo@gmail.com");
    	cliente.setEstado(true);
    	clientes.add(cliente);
    	
    	cliente = new Cliente();
    	cliente.setNombre("Marcos");
    	cliente.setApellido("Leiva");
    	cliente.setCiut("3445566");
    	cliente.setEmail("marquitos@gmail.com");
    	cliente.setEstado(false);
    	clientes.add(cliente);
    	
    	return clientes;
    }
	
}
