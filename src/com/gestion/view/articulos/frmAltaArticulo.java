package com.gestion.view.articulos;

import com.gestion.R;
import com.gestion.bo.ArticuloBo;
import com.gestion.dto.Articulo;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class frmAltaArticulo extends Activity {
	private EditText txtNombre;
	private EditText txtCodigo;
	private EditText txtDescripcion;
	private EditText txtPrecio;
	private EditText txtCantidad;
	private int modo;
	private Articulo articuloNuevo;
	private Articulo articuloModificar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Bundle b = getIntent().getExtras();
		modo = (Integer) b.getSerializable("modo");

		setContentView(R.layout.lyt_articulo_alta);
		Button btnAceptar = (Button) findViewById(R.id.btnOk);
		
		txtCodigo = (EditText) findViewById(R.id.txtCodigo);
		txtNombre = (EditText) findViewById(R.id.txtNombreArticulo);
		txtDescripcion = (EditText) findViewById(R.id.txtDescripcion);
		txtPrecio = (EditText) findViewById(R.id.txtPrecio);
		txtCantidad = (EditText) findViewById(R.id.txtCantidad);
		if (modo == frmListadoArticulos.MODO_UPDATE) {
			articuloModificar = (Articulo) b.getSerializable("articulo");
			txtCodigo.setText(articuloModificar.getCodigo());
			txtNombre.setText(articuloModificar.getNombre());
			txtDescripcion.setText(articuloModificar.getDescripcion());
			txtPrecio.setText(String.valueOf(articuloModificar.getCosto()));
			txtCantidad
					.setText(String.valueOf(articuloModificar.getCantidad()));

		}
		btnAceptar.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				crearArticulo();
			}

		});
		Button btnCancel = (Button)findViewById(R.id.btnCancel);
		btnCancel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				cancel();
			}
			private void cancel() {
				setResult(RESULT_CANCELED);
				finish();
				
			}

		});
		
	}

	private void crearArticulo() {
		Intent intent = new Intent(this, frmListadoArticulos.class);
		if (modo == frmListadoArticulos.MODO_UPDATE) {

			articuloModificar.setNombre(txtNombre.getText().toString());
			articuloModificar.setDescripcion(txtDescripcion.getText()
					.toString());
			articuloModificar.setCosto(Integer.valueOf(txtPrecio.getText()
					.toString()));
			articuloModificar.setCantidad(Integer.valueOf(txtCantidad.getText()
					.toString()));
			articuloModificar.setCodigo(txtCodigo.getText().toString());
			intent.putExtra("articulo", articuloModificar);
		} else {
			articuloNuevo = new Articulo();
			// articuloNuevo.setId(99);
			articuloNuevo.setNombre(txtNombre.getText().toString());
			articuloNuevo.setDescripcion(txtDescripcion.getText().toString());
			articuloNuevo.setCosto(Integer.valueOf(txtPrecio.getText()
					.toString()));
			articuloNuevo.setCantidad(Integer.valueOf(txtCantidad.getText()
					.toString()));
			articuloNuevo.setCodigo(txtCodigo.getText().toString());
			intent.putExtra("articulo", articuloNuevo);
		}

		intent.putExtra("modo", modo);
		setResult(RESULT_OK, intent);
		finish();
	}

}
