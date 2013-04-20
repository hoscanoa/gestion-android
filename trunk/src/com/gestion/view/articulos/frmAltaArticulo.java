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
	private ArticuloBo mArticuloBo;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
    	// TODO Auto-generated method stub
    	super.onCreate(savedInstanceState);
    	Bundle b = getIntent().getExtras();
		modo = (Integer)b.getSerializable("modo");
		if(modo == frmListadoArticulos.MODO_UPDATE){
			articuloNuevo = (Articulo)b.getSerializable("articulo");
			//cargar datos
		}
		setContentView(R.layout.lyt_articulo_alta);
		Button btnAceptar = (Button)findViewById(R.id.btnOk);
		 txtCodigo = (EditText) findViewById(R.id.txtCodigo);
		 txtNombre = (EditText) findViewById(R.id.txtNombreArticulo);
	     txtDescripcion = (EditText) findViewById(R.id.txtDescripcion);
	     txtPrecio = (EditText) findViewById(R.id.txtPrecio);
	     txtCantidad = (EditText) findViewById(R.id.txtCantidad);
		btnAceptar.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				crearArticulo();
			}

		
			
		});
    }
	private void crearArticulo() {
		if(modo == frmListadoArticulos.MODO_UPDATE){
		
		}else{
			articuloNuevo = new Articulo();
			//articuloNuevo.setId(99);
			articuloNuevo.setNombre(txtNombre.getText().toString());
			articuloNuevo.setDescripcion(txtDescripcion.getText().toString());
			articuloNuevo.setCosto(Integer.valueOf(txtPrecio.getText().toString()));
		    articuloNuevo.setCantidad(Integer.valueOf(txtCantidad.getText().toString()));
		    articuloNuevo.setCodigo(txtCodigo.getText().toString());
			
		   
		 
		}
		Intent intent = new Intent(this, frmListadoArticulos.class);
		intent.putExtra("articulo", articuloNuevo);
		intent.putExtra("modo", modo);
		setResult(RESULT_OK, intent);
		finish();
	}
	
	
}
