package com.gestion.bo;

import com.gestion.dao.DaoFactory;
import com.gestion.dao.IUsuarioDao;
import com.gestion.dto.Usuario;

public class UsuarioBo {
 private DaoFactory daoFactory = DaoFactory.getFactory(DaoFactory.SQLITE);
 private IUsuarioDao usuarioDao = daoFactory.getUsuarioDao();
 
 
	public boolean loginString(String nombreUsuario, String clave)throws Exception{
		Usuario usuario = usuarioDao.login(nombreUsuario, clave);
		if (usuario != null) {
			return true;
		} else {
			return false;
		}

	}
}
