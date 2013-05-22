package com.gestion.view.articulos;

import java.util.List;

import com.gestion.R;
import com.gestion.bo.ArticuloAdapter;
import com.gestion.bo.ArticuloBo;
import com.gestion.dto.Articulo;
import com.gestion.utils.Preferencia;
import com.gestion.ventas.FrmDetalleVenta;
import com.gestion.view.articulos.DialogOrdenarArticulos.ItemListener;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
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
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.AdapterContextMenuInfo;

public class frmListadoArticulos extends FragmentActivity implements ItemListener {
	private ArticuloBo mArticuloBo;
	private ArticuloAdapter mAdapter;
	private static final int ACTIVITY_ALTA_ARTICULO = 0;
	private static final int ACTIVITY_MODIFICAR_ARTICULO = 1;
	public static final int MODO_UPDATE = 99;
	public static final int MODO_CREATE = 0;
	private Preferencia mPreferencia;
	private ListView lstArticulos;
	private int modo;
	final Context context = this;
	private String auxCantidad;
	public int auxIdArticulo;
	

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
			// para el setOnPut busca aca el modo viste..
		
	//	Bundle b = getIntent().getExtras();
//	modo = (Integer) b.getSerializable("modo");
		setContentView(R.layout.lyt_articulo_listado);
		
			// ***************************************

		lstArticulos = (ListView) findViewById(R.id.lstArticulos);
		lstArticulos.setTextFilterEnabled(true);
		registerForContextMenu(lstArticulos);
		mPreferencia = new Preferencia(this);
		mArticuloBo = new ArticuloBo();
		List<Articulo> articulos = mArticuloBo.getListado();
		mAdapter = new ArticuloAdapter(this, R.layout.lyt_articulo_item,
				articulos);

		lstArticulos.setAdapter(mAdapter);
		EditText txtFiltro = (EditText) findViewById(R.id.txtArticuloFiltro);
		
		
		//registerForContextMenu(lstArticulos);
		lstArticulos.setOnItemClickListener(new OnItemClickListener() {
			// lo que hace es mostrarte el Id.. como?.. el argumento cero es el
			// contexto, arg2 es integer de la posicio
			// y lo definis como el objeto que te va a devolver el Id
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				int idArticulo = ((Articulo) arg0.getItemAtPosition(arg2)).getId();
				Toast.makeText(getApplicationContext(),
						"este es el id" + idArticulo, Toast.LENGTH_LONG).show();
       auxIdArticulo = idArticulo;
			}
		});
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
		inflater.inflate(R.menu.mn_articulo, menu);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.itmNuevo:
			callActivityAlta();
			return true;
		case R.id.itmOrdenar:
			DialogOrdenarArticulos dialog = new DialogOrdenarArticulos();
			dialog.show(getSupportFragmentManager(), "Ordenar Articulo");
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}

	}

	private void callActivityAlta() {
		Intent intent = new Intent(this, frmAltaArticulo.class);
		intent.putExtra("modo", MODO_CREATE);
		startActivityForResult(intent, ACTIVITY_ALTA_ARTICULO);
	}

	private void callActivityModificar(Articulo articuloSeleccionado) {
		Intent intent = new Intent(this, frmAltaArticulo.class);
		intent.putExtra("modo", MODO_UPDATE);
		intent.putExtra("articulo", articuloSeleccionado);
		startActivityForResult(intent, ACTIVITY_MODIFICAR_ARTICULO);
	}
	
	

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == ACTIVITY_ALTA_ARTICULO && resultCode == RESULT_OK) {
			Articulo articuloNuevo = (Articulo) data.getExtras()
					.getSerializable("articulo");
			mArticuloBo.guardarArticulo(articuloNuevo);
			mAdapter.add(articuloNuevo);

		} else if (requestCode == ACTIVITY_MODIFICAR_ARTICULO
				&& resultCode == RESULT_OK) {
			Articulo articuloModificado = (Articulo) data.getExtras()
					.getSerializable("articulo");
			mArticuloBo.modificarArticulo(articuloModificado);
			List<Articulo> articulos = mArticuloBo.getListado();
			mAdapter = new ArticuloAdapter(this, R.layout.lyt_articulo_item,
					articulos);

			lstArticulos.setAdapter(mAdapter);

		}
	}

	@Override
	public void onItemSelected(int position) {
		mPreferencia.setCriterioOrdenarArticulo(position);
		mAdapter.sort(position);
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		MenuInflater inflater = getMenuInflater();
		menu.setHeaderTitle("Opciones");
		inflater.inflate(R.menu.mn_articulo_item, menu);
		super.onCreateContextMenu(menu, v, menuInfo);
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		final Intent intent = new Intent(this, FrmDetalleVenta.class);
		AdapterContextMenuInfo info = (AdapterContextMenuInfo) item
				.getMenuInfo();
		int pos = info.position;
		final Articulo articulo = mAdapter.getItem(pos);

		switch (item.getItemId()) {
		case R.id.tmModificar:
			callActivityModificar(articulo);
			return true;
		case R.id.tmEliminar:
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setMessage("¿Esta seguro?")
					.setPositiveButton("Aceptar",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int id) {
									mArticuloBo.eliminarArticulo(articulo);
									mAdapter.remove(articulo);
									dialog.dismiss();

								}
							})
					.setNegativeButton("Cancelar",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int id) {
									dialog.dismiss();
								}
							});
			// Create the AlertDialog object and return it
			builder.show();
			return true;
		case R.id.tmAgregarCompra:
			AlertDialog.Builder alert = new AlertDialog.Builder(context);
            alert.setTitle("Ingrese La cantidad que desea Comprar"); //Set Alert dialog title here
            alert.setMessage("Cantidad"); //Message here
 
            // Set an EditText view to get user input 
            final EditText input = new EditText(context);
            alert.setView(input);
 
            alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
             //You will get as string input data in this variable.
             // here we convert the input to a string and show in a toast.
             String srt = input.getEditableText().toString();
             Toast.makeText(context,srt + auxIdArticulo,Toast.LENGTH_LONG).show(); 
             auxCantidad = srt;
             intent.putExtra("idProducto", auxIdArticulo);
             intent.putExtra("Cantidad", auxCantidad);
     		 setResult(RESULT_OK, intent);
            
     		 
            } // End of onClick(DialogInterface dialog, int whichButton)
            });
            
            //End of alert.setPositiveButton
                alert.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                  public void onClick(DialogInterface dialog, int whichButton) {
                    // Canceled.
                      dialog.cancel();
                  }
            }); 
                
                //End of alert.setNegativeButton
                AlertDialog alertDialog = alert.create();
                alertDialog.show();
                
                
                return true;
			
		default:
			return super.onContextItemSelected(item);
		}

	}

}
