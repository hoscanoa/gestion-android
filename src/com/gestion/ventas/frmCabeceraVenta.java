package com.gestion.ventas;

import com.gestion.R;
import com.gestion.dto.Cliente;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class frmCabeceraVenta extends Activity {
	private Cliente cliente;
	private TextView nombre;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Bundle b = getIntent().getExtras();
		cliente = (Cliente) b.getSerializable("cliente");
		setContentView(R.layout.lyt_cabecera_venta);
		    nombre = (TextView) findViewById(R.id.txtNombreCliente);
			nombre.setText(cliente.getNombre());
		
	}
}
