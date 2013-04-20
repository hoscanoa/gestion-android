package com.gestion.view.cliente;

import java.util.List;

import com.gestion.R;
import com.gestion.bo.ClienteAdapter;
import com.gestion.bo.ClienteBo;
import com.gestion.dto.Cliente;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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

public class frmListadoClientes extends Activity {
	private ClienteBo mClienteBo;
	private ClienteAdapter mAdapter;
	private static final int Activity_alta_cliente =0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.lyt_cliente_listado);

		ListView lstClientes = (ListView) findViewById(R.id.lstCliente);
		lstClientes.setTextFilterEnabled(true);
		registerForContextMenu(lstClientes);

		mClienteBo = new ClienteBo();
		List<com.gestion.dto.Cliente> clientes = mClienteBo.retriewClientes();
		mAdapter = new ClienteAdapter(this,
				R.layout.lyt_cliente_item, clientes);
		lstClientes.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub

			}
		});
		lstClientes.setAdapter(mAdapter);
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

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {
		case R.id.mnEliminarCliente:
			Toast.makeText(getApplicationContext(), "Nuevo Cliente",Toast.LENGTH_SHORT).show();
			return true;
		case R.id.mnModificarCliente:
			Toast.makeText(getApplicationContext(), "Modificar", Toast.LENGTH_LONG).show();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}

	}
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
		 MenuInflater inflater = getMenuInflater();
		 menu.setHeaderTitle("Opciones");
		 inflater.inflate(R.menu.main, menu);
		
	}
	
	@Override
	public boolean onContextItemSelected(MenuItem item) {
	    AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();
	    int pos = info.position;
	    Cliente clienteSeleccionado = mAdapter.getItem(pos);
	    switch (item.getItemId()) {
	        case R.id.mnEliminarCliente:
	        	Toast.makeText(getApplicationContext(), "Eliminar Cliente" + clienteSeleccionado,Toast.LENGTH_SHORT).show();
	            return true;
	        case R.id.mnModificarCliente:
	        	Toast.makeText(getApplicationContext(), "Modificar Cliente"+ clienteSeleccionado,Toast.LENGTH_SHORT).show();
	            return true;
	        case R.id.mnRegistrarVentaCliente:
	        	Toast.makeText(getApplicationContext(), "Registrar Venta",Toast.LENGTH_SHORT).show();
	        	return true;
	        default:
	            return super.onContextItemSelected(item);
	    }
	}
	private void callActivityAlta(){
		Intent intent = new Intent(this,frmAltaCliente.class);
		//startActivityForResult(intent,);
	}
	
}
