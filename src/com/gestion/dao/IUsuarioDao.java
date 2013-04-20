package com.gestion.dao;

import com.gestion.dto.Usuario;

public interface IUsuarioDao extends IGenericDao<Usuario, Long> {

	Usuario login(String nombreUsuario, String clave) throws Exception;
}
