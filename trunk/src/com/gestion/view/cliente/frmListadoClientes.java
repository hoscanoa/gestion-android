package com.gestion.view.cliente;

import java.util.List;
import com.gestion.R;
import com.gestion.bo.ArticuloAdapter;
import com.gestion.bo.ClienteAdapter;
import com.gestion.bo.ClienteBo;
import com.gestion.dto.Articulo;
import com.gestion.dto.Cliente;
import com.gestion.utils.Preferencia;
import com.gestion.ventas.frmCabeceraVenta;
import com.gestion.view.articulos.DialogOrdenarArticulos;
import com.gestion.view.articulos.frmAltaArticulo;
import com.gestion.view.cliente.DialogOrdenarCliente.ItemListener;
import com.gestion.view.principal.Principal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class frmListadoClientes extends FragmentActivity  implements ItemListener {
	private ClienteBo mClienteBo;
	private ClienteAdapter mAdapter;
	private static final int ACTIVITY_ALTA_CLIENTE =0;
	private static final int ACTIVITY_MODIFICAR_CLIENTE = 1;
	public static final int MODO_UPDATE = 99;
	public static final int MODO_CREATE = 0;
	private Preferencia mPreferencia;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.lyt_cliente_listado);

		ListView lstClientes = (ListView) findViewById(R.id.lstCliente);
		lstClientes.setTextFilterEnabled(true);
		registerForContextMenu(lstClientes);

		mClienteBo = new ClienteBo();
		//List<Cliente> clientes = mClienteBo.retriewClientes();
		List<Cliente> clientes = mClienteBo.getListado();
		mAdapter = new ClienteAdapter(this,
				R.layout.lyt_cliente_item, clientes);
		/*
		lstClientes.setOnItemClickListener(new OnItemClickListener() {
			// lo que hace es mostrarte el Id.. como?.. el argumento cero es el
			// contexto, arg2 es integer de la posicio
			// y lo definis como el objeto que te va a devolver el Id
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				String idCliente = ((Cliente) arg0.getItemAtPosition(arg2))
						.getApellido();
				Toast.makeText(getApplicationContext(),
						"este es el id" + idCliente, Toast.LENGTH_LONG).show();

			}
		});
		
		*/
		lstClientes.setAdapter(mAdapter);
		
		
		
		//Filtro de Busqueda
		
		EditText txtFiltro = (EditText) findViewById(R.id.txtFiltro);		
		txtFiltro.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence text, int start, int before,
					int count) {
				mAdapter.getFilter().filter(text.toString());

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub

			}
		});
	}

	
	
	// ************* aca arranca lo de menu. *******

	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.mn_cliente,menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {
		case R.id.itmClienteNuevo:
			callActivityAlta();
			//Toast.makeText(getApplicationContext(), "Nuevo Cliente",Toast.LENGTH_SHORT).show();
			return true;
		case R.id.itmOrdenarcliente:
			DialogOrdenarCliente dialog = new DialogOrdenarCliente();
			dialog.show(getSupportFragmentManager(), "Ordenar Cliente");
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}

		
		}	
		
	private void callActivityAlta() {
		Intent intent1 = new Intent(this, frmAltaCliente.class);
		intent1.putExtra("modo", MODO_CREATE);
		startActivityForResult(intent1, ACTIVITY_ALTA_CLIENTE);
		
		
	}
	
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
			super.onActivityResult(requestCode, resultCode, data);
			if (requestCode == ACTIVITY_ALTA_CLIENTE && resultCode == RESULT_OK){
				Cliente cliente = (Cliente) data.getExtras().getSerializable("cliente");
				mClienteBo.guardarCliente(cliente);
			mAdapter.add(cliente);
			}
			
			
			
	}
	
	public void onItemSelected(int position) {
		mPreferencia.setCriterioOrdenarCliente(position);
		mAdapter.sort(position);
	}
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
		 MenuInflater inflater = getMenuInflater();
		 menu.setHeaderTitle("Opciones");
		 inflater.inflate(R.menu.mn_cliente_item, menu);
		 super.onCreateContextMenu(menu, v, menuInfo);
	}
	
	@Override
	public boolean onContextItemSelected(MenuItem item) {
	    AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();
	    int pos = info.position;
	    
	   
	    
	    Cliente clienteSeleccionado = mAdapter.getItem(pos);
	    switch (item.getItemId()) {
	        case R.id.tmEliminar:
	        	mClienteBo.eliminarCliente(clienteSeleccionado);
				mAdapter.remove(clienteSeleccionado);
	        	Toast.makeText(getApplicationContext(), "Eliminar Cliente" + clienteSeleccionado,Toast.LENGTH_SHORT).show();
	            return true;
	        case R.id.mnModificarCliente:
	        	Toast.makeText(getApplicationContext(), "Modificar Cliente"+ clienteSeleccionado,Toast.LENGTH_SHORT).show();
	            return true;
	        case R.id.tmVentas:
	        	Intent intent = new Intent(getBaseContext(),frmCabeceraVenta.class);
				intent.putExtra("cliente", clienteSeleccionado);
				startActivity(intent);

	        	return true;
	       
	        default:
	            return super.onContextItemSelected(item);
	    }
	}

}


	
	

