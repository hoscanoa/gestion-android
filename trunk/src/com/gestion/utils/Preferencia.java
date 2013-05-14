package com.gestion.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class Preferencia {
	private SharedPreferences mPreferences;
	private Context mContext;
	private static final String KEY_ORDEN_ARTICULO = "ordenarArticulo";

	private static final String KEY_ORDEN_CLIENTE = "ordenarCliente";

	public static final int ORDENAR_NOMBRE = 0;
	public static final int ORDENAR_CODIGO = 1;
	public static final int ORDENAR_APELLIDO = 2;
	
	public Preferencia(Context context) {
		mContext = context;
		mPreferences = mContext.getSharedPreferences("demo",
				Context.MODE_PRIVATE);

	}

	public int getCriterioOrdenarArticulo() {
		return mPreferences.getInt(KEY_ORDEN_ARTICULO, 0);
	}
	public int getCriterioOrdenarCliente() {
		return mPreferences.getInt(KEY_ORDEN_CLIENTE, 0);
	}
	public void setCriterioOrdenarArticulo(int criterio){
		Editor editor = mPreferences.edit();
		editor.putInt(KEY_ORDEN_ARTICULO, criterio);
		editor.commit();
	}
	public void setCriterioOrdenarCliente(int criterio){
		Editor editor = mPreferences.edit();
		editor.putInt(KEY_ORDEN_CLIENTE, criterio);
		editor.commit();
	}
}
