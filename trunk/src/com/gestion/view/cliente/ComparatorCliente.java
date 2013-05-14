package com.gestion.view.cliente;

import java.text.Collator;
import java.util.Comparator;

import com.gestion.dto.Articulo;
import com.gestion.dto.Cliente;
import com.gestion.utils.Preferencia;

public class ComparatorCliente implements Comparator<Cliente> {
	private int mCriterio;

	public ComparatorCliente(int criterio) {
		mCriterio = criterio;
	}



@Override
public int compare(Cliente c1, Cliente c2) {
	Collator collator = Collator.getInstance();
	collator.setStrength(Collator.PRIMARY);
	String valor1 = null;
	String valor2 = null;

	switch (mCriterio) {
	case Preferencia.ORDENAR_NOMBRE:
		valor1 = c1.getNombre();
		valor2 = c2.getNombre();
		break;
	case Preferencia.ORDENAR_CODIGO:
		valor1 = c1.getApellido();
		valor2 = c2.getApellido();
		break;
	default:
		break;
	}
	return collator.compare(valor1, valor2);
}

}


