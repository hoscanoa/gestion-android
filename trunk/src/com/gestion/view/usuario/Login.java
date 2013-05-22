package com.gestion.view.usuario;

import com.gestion.R;
import com.gestion.bo.UsuarioBo;
import com.gestion.ventas.FrmDetalleVenta;
import com.gestion.view.articulos.frmListadoArticulos;
import com.gestion.view.cliente.frmAltaCliente;
import com.gestion.view.cliente.frmListadoClientes;
import com.gestion.view.principal.Principal;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends Activity {

	private EditText txtUsuario;
	private EditText txtClave;
	private UsuarioBo mUsuarioBo;
	private boolean valido;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		initViews();
		initVar();
		this.setTitle("Ingrese a la aplicacion");
		
	}

	private void initVar() {
		mUsuarioBo = new UsuarioBo();
	}

	private void initViews() {

		txtUsuario = (EditText) findViewById(R.id.txtUsuario);
		txtClave = (EditText) findViewById(R.id.txtPass);

		Button btnOk = (Button) findViewById(R.id.Ok);
		btnOk.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				btnOnclick(v);

			}

			private void btnOnclick(View v) {
				String usuario = txtUsuario.getText().toString();
				String clave = txtClave.getText().toString();

				
				try {
					valido = mUsuarioBo.loginString(usuario, clave);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				if (!valido) {
					Toast.makeText(getBaseContext(), R.string.msgErrorLogin,
							Toast.LENGTH_SHORT).show();
				} else {
					Intent intent = new Intent(getBaseContext(), Principal.class);
				intent.putExtra("usuario", usuario);
					startActivity(intent);
				}

			}
		});
//		Button btnCancel = (Button) findViewById(R.id.Cancelar);
//		btnCancel.setOnClickListener(new OnClickListener() {
//
//			@Override
//			public void onClick(View v) {
//				finish();
//
//			}
//		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
