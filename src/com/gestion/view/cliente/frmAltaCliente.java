package com.gestion.view.cliente;

import java.util.ArrayList;

import com.gestion.R;

import com.gestion.bo.LocalidadBo;
import com.gestion.dto.Articulo;
import com.gestion.dto.Cliente;
import com.gestion.dto.Localidad;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ToggleButton;

public class frmAltaCliente extends Activity {
	
	private EditText txtCodigo;
	private EditText txtDescripcion;
	private EditText txtPrecio;
	private EditText txtCantidad;
	private int modo;
	private Articulo articuloNuevo;
	private Articulo articuloModificar;
	public LocalidadBo mlocalidad;
	public ArrayList<Localidad> lstLocalidad;
	public Spinner localSpn;
	public ArrayAdapter<Localidad> spinner_adapter;
	
public Localidad localidadAux;
	private EditText txtNombre;
	private EditText txtApellido;
	private EditText txtDomicilio;
	private EditText txtCuit;
	private EditText txtRazonSocial;
	private EditText txtTelefono;
	private EditText txtEmaill;
	private ToggleButton tgbEstado;

	private Cliente clienteNuevo;
	private Cliente clienteModificar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Bundle b = getIntent().getExtras();
		modo = (Integer) b.getSerializable("modo");

		setContentView(R.layout.lyt_cliente_alta);
		Button btnAceptar = (Button) findViewById(R.id.btnOkCli);
		// una el spinner con el View spinner del layout
		localSpn = (Spinner) findViewById(R.id.spnLocalidad);
		
		txtApellido = (EditText) findViewById(R.id.txtApellido);
		txtNombre = (EditText) findViewById(R.id.txtNombre);
		txtCuit = (EditText) findViewById(R.id.txtCuit);
		txtEmaill = (EditText) findViewById(R.id.txtEml);
		txtRazonSocial = (EditText) findViewById(R.id.txtRazon);
		txtTelefono = (EditText) findViewById(R.id.txtTelefono);
		txtDomicilio = (EditText) findViewById(R.id.txtDomicilio);
		
		lstLocalidad = new ArrayList<Localidad>();
		mlocalidad = new LocalidadBo();
		lstLocalidad = mlocalidad.devolverLocalidad();
		localidadAux = new Localidad();
		spinner_adapter = new ArrayAdapter<Localidad>(this,	android.R.layout.simple_spinner_item, lstLocalidad);
		spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		localSpn.setAdapter(spinner_adapter);
		
		if (modo == frmListadoClientes.MODO_UPDATE) {
			clienteModificar = (Cliente) b.getSerializable("cliente");
			txtNombre.setText(clienteModificar.getNombre());
			txtApellido.setText(clienteModificar.getApellido());
			txtCuit.setText(clienteModificar.getCuit());
			txtDomicilio.setText(clienteModificar.getDomicilioValue());
			txtEmaill.setText(clienteModificar.getEmail());
			txtRazonSocial.setText(clienteModificar.getRazonSocial());
			txtTelefono.setText(clienteModificar.getTelefono());

		}
		
		
		btnAceptar.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				crearArticulo();
			}

		});
		Button btnCancel = (Button)findViewById(R.id.btnCancelCli);
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
		/*Intent intent = new Intent(this, frmListadoClientes.class);
		if (modo == frmListadoClientes.MODO_UPDATE) {

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
*/
		Intent intent = new Intent(this, frmListadoClientes.class);

if (modo == frmListadoClientes.MODO_UPDATE) {

	localidadAux.setDescripcion("cstes");
	localidadAux.setId(3);
	clienteModificar.setNombre(txtNombre.getText().toString());
	clienteModificar.setApellido(txtApellido.getText().toString());
	clienteModificar.setCuit(txtCuit.getText().toString());
	clienteModificar.setDomicilioValue(txtDomicilio.getText().toString());
	clienteModificar.setEmail(txtEmaill.getText().toString());
	clienteModificar.setEstado(true);
	clienteModificar.setLocalidad(localidadAux);
	clienteModificar.setRazonSocial(txtRazonSocial.getText().toString());
	clienteModificar.setTelefono(txtTelefono.getText().toString());
	
	
	intent.putExtra("cliente", clienteModificar);
} 

else {
	clienteNuevo = new Cliente();
	localidadAux.setDescripcion("cstes");
	localidadAux.setId(3);
	clienteNuevo.setNombre(txtNombre.getText().toString());
	clienteNuevo.setApellido(txtApellido.getText().toString());
	clienteNuevo.setCuit(txtCuit.getText().toString());
	clienteNuevo.setDomicilioValue(txtDomicilio.getText().toString());
	clienteNuevo.setEmail(txtEmaill.getText().toString());
	clienteNuevo.setEstado(true);
	clienteNuevo.setLocalidad(localidadAux);
	clienteNuevo.setRazonSocial(txtRazonSocial.getText().toString());
	clienteNuevo.setTelefono(txtTelefono.getText().toString());
	intent.putExtra("cliente", clienteNuevo);
}

		intent.putExtra("modo", modo);
		setResult(RESULT_OK, intent);
		finish();
	}
	
	}


/*
import java.util.ArrayList;

import com.gestion.R;
import com.gestion.bo.LocalidadBo;
import com.gestion.dto.Articulo;
import com.gestion.dto.Cliente;
import com.gestion.dto.Localidad;
import com.gestion.dto.Provincia;
import com.gestion.view.articulos.frmListadoArticulos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

public class frmAltaCliente extends Activity {

	public LocalidadBo mlocalidad;
	public ArrayList<Localidad> lstLocalidad;
	public Spinner localSpn;
	public ArrayAdapter<Localidad> spinner_adapter;
	private int modo;
public Localidad localidadAux;
	private EditText txtNombre;
	private EditText txtApellido;
	private EditText txtDomicilio;
	private EditText txtCuit;
	private EditText txtRazonSocial;
	private EditText txtTelefono;
	private EditText txtEmaill;
	private ToggleButton tgbEstado;

	private Cliente clienteNuevo;
	private Cliente clienteModificar;
	

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lyt_cliente_alta);
		Bundle b = getIntent().getExtras();
		modo = (Integer) b.getSerializable("modo");
		
		
		
		
		
		
		
		
		

		// *******************************************
		
		
		Button btnAceptar = (Button) findViewById(R.id.btnOkCli);
		localSpn = (Spinner) findViewById(R.id.spnLocalidad);
		
		txtApellido = (EditText) findViewById(R.id.txtApellido);
		txtNombre = (EditText) findViewById(R.id.txtNombre);
		txtCuit = (EditText) findViewById(R.id.txtCuit);
		txtEmaill = (EditText) findViewById(R.id.txtEml);
		txtRazonSocial = (EditText) findViewById(R.id.txtRazon);
		txtTelefono = (EditText) findViewById(R.id.txtTelefono);
		Bindear();
		IniciarObjetos();
		
		Adapter();
		localSpn.setAdapter(spinner_adapter);

		if (modo == frmListadoArticulos.MODO_UPDATE) {
			clienteModificar = (Cliente) b.getSerializable("cliente");
			txtNombre.setText(clienteModificar.getNombre());
			txtApellido.setText(clienteModificar.getApellido());
			txtCuit.setText(clienteModificar.getCuit());
			txtDomicilio.setText(clienteModificar.getDomicilioValue());
			txtEmaill.setText(clienteModificar.getEmail());
			txtRazonSocial.setText(clienteModificar.getRazonSocial());
			txtTelefono.setText(clienteModificar.getTelefono());

		}
		// esto lo que hace es mostrate el Id, en este caso solo se debaria tomar el id de la localidad para guardarlo en Cliente
		localSpn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

			@Override
					public void onItemSelected(AdapterView<?> parent,
							View view, int pos, long id) {
						long idrecu = ((Provincia) parent
								.getItemAtPosition(pos)).getId();

						String aux = Long.toString(idrecu);

						Toast.makeText(parent.getContext(),
								"El id de la provincia es" + aux,
								Toast.LENGTH_SHORT).show();
					}

					@Override
					public void onNothingSelected(AdapterView<?> arg0) {
						
					}
					
				});
		
		
		btnAceptar.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				crearCliente();
			}

		});
		Button btnCancel = (Button) findViewById(R.id.btnCancel);
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

	private  void crearCliente() {
			
				Intent intent = new Intent(this, frmListadoClientes.class);
				 
				if (modo == frmListadoClientes.MODO_UPDATE) {

					localidadAux.setDescripcion("cstes");
					localidadAux.setId(3);
					clienteModificar.setNombre(txtNombre.getText().toString());
					clienteModificar.setApellido(txtApellido.getText().toString());
					clienteModificar.setCuit(txtCuit.getText().toString());
					clienteModificar.setDomicilioValue(txtDomicilio.getText().toString());
					clienteModificar.setEmail(txtEmaill.getText().toString());
					clienteModificar.setEstado(true);
					clienteModificar.setLocalidad(localidadAux);
					clienteModificar.setRazonSocial(txtRazonSocial.getText().toString());
					clienteModificar.setTelefono(txtTelefono.getText().toString());
					
					
					intent.putExtra("cliente", clienteModificar);
				} 
				
				else {
					clienteNuevo = new Cliente();
					localidadAux.setDescripcion("cstes");
					localidadAux.setId(3);
					clienteNuevo.setNombre(txtNombre.getText().toString());
					clienteNuevo.setApellido(txtApellido.getText().toString());
					clienteNuevo.setCuit(txtCuit.getText().toString());
					clienteNuevo.setDomicilioValue(txtDomicilio.getText().toString());
					clienteNuevo.setEmail(txtEmaill.getText().toString());
					clienteNuevo.setEstado(true);
					clienteNuevo.setLocalidad(localidadAux);
					clienteNuevo.setRazonSocial(txtRazonSocial.getText().toString());
					clienteNuevo.setTelefono(txtTelefono.getText().toString());
					intent.putExtra("cliente", clienteNuevo);
				}

				intent.putExtra("modo", modo);
				setResult(RESULT_OK, intent);
				finish();
				
		
	}


	private void Adapter() {
		spinner_adapter = new ArrayAdapter<Localidad>(this,
				android.R.layout.simple_spinner_item, lstLocalidad);
		spinner_adapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

	}

	private void IniciarObjetos() {
		lstLocalidad = new ArrayList<Localidad>();
		mlocalidad = new LocalidadBo();
		localidadAux = new Localidad();
	}

	private void Bindear() {
		
	}
	

	}
*/