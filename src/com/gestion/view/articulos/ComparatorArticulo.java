package com.gestion.view.articulos;

import java.text.Collator;
import java.util.Comparator;

import com.gestion.dto.Articulo;
import com.gestion.utils.Preferencia;

public class ComparatorArticulo implements Comparator<Articulo> {
	private int mCriterio;

	public ComparatorArticulo(int criterio) {
		mCriterio = criterio;
	}

	@Override
	public int compare(Articulo a1, Articulo a2) {
		Collator collator = Collator.getInstance();
		collator.setStrength(Collator.PRIMARY);
		String valor1 = null;
		String valor2 = null;

		switch (mCriterio) {
		case Preferencia.ORDENAR_NOMBRE:
			valor1 = a1.getNombre();
			valor2 = a2.getNombre();
			break;
		case Preferencia.ORDENAR_CODIGO:
			valor1 = a1.getCodigo();
			valor2 = a2.getCodigo();
			break;
		default:
			break;
		}
		return collator.compare(valor1, valor2);
	}

}
