package com.gestion.ventas;

import java.util.List;

import com.gestion.R;
import com.gestion.bo.ArticuloAdapter;
import com.gestion.dto.Articulo;
import com.gestion.view.articulos.frmAltaArticulo;
import com.gestion.view.articulos.frmListadoArticulos;
import com.gestion.view.cliente.frmAltaCliente;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class FrmDetalleVenta extends Activity {
	private Intent intent;
	
	private static final int ACTIVITY_ALTA_ARTICULO = 0;
	public Button btnAgregar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lyt_detalle_venta);
		this.setTitle("Spreiiiyeett");
		intent = new Intent(this, frmListadoArticulos.class);
		btnAgregar = (Button) findViewById(R.id.btn_agregar);
		
		btnAgregar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {


//Intent intent = new Intent(this, frmAltaArticulo.class);
//.putExtra("modo", MODO_UPDATE);
//intent.putExtra("articulo", articuloSeleccionado);
startActivityForResult(intent, ACTIVITY_ALTA_ARTICULO);
				//startActivity(intent);
				
			}
		});
			
	}
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == ACTIVITY_ALTA_ARTICULO && resultCode == RESULT_OK) {
			String cantidad = (String) data.getExtras().getSerializable("Cantidad");
			String idCantidad = (String) data.getExtras().getSerializable("idProducto");
			//mArticuloBo.guardarArticulo(articuloNuevo);
			//mAdapter.add(articuloNuevo);
			Toast.makeText(getApplicationContext(), "Eliminar Cliente" + cantidad + idCantidad ,Toast.LENGTH_SHORT).show();
	          } 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		getMenuInflater().inflate(R.menu.frm_detalle_venta, menu);
		return true;
	}

}
