package com.gestion.view.principal;


import com.gestion.R;
import com.gestion.view.articulos.frmListadoArticulos;
import com.gestion.view.cliente.frmListadoClientes;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class Principal extends Activity {
public TextView usuario;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.principal);
		this.setTitle("Spreiiiyeett");
		TextView usuario = (TextView) findViewById(R.id.txtUsuario1);
		Bundle extras = getIntent().getExtras();
		String aux = extras.getString("usuario");
		usuario.setText(aux);
		IniViews();
		
		
	}

	private void IniViews() {
		ImageButton btnClientes = (ImageButton) findViewById(R.id.imgClientes);
		btnClientes.setOnClickListener(new OnClickListener() {
			
			
			public void onClick(View v) {
				Intent intent = new Intent(getBaseContext(),frmListadoClientes.class);
				
				startActivity(intent);
				
			}
		});
		
		ImageButton btnArticulos = (ImageButton) findViewById(R.id.imgArticulo);
		btnArticulos.setOnClickListener(new OnClickListener() {
			
			
			public void onClick(View v) {
				Intent intent = new Intent(getBaseContext(),frmListadoArticulos.class);
				
				startActivity(intent);
				
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.principal, menu);
		return true;
	}

}
