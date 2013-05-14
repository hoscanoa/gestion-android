package com.gestion.ventas;

import com.gestion.R;
import com.gestion.view.articulos.frmListadoArticulos;
import com.gestion.view.cliente.frmListadoClientes;


//import android.app.LocalActivityManager;
//import android.content.Intent;
//import android.os.Bundle;
//import android.support.v4.app.FragmentActivity;
//import android.widget.TabHost;
//
//public class frmTabsVenta extends FragmentActivity {
//
//	private LocalActivityManager mlActivityManager;
//
//	@Override
//	protected void onCreate(Bundle arg0) {
//		super.onCreate(arg0);
//		//setContentView(R.layout.lyt_tab_venta);
//		//TabHost tabHost = (TabHost) findViewById(R.id.tabhost);
//		mlActivityManager = new LocalActivityManager(this, false);
//		tabHost.setup(mlActivityManager);
//		mlActivityManager.dispatchCreate(arg0);
//
//		TabHost.TabSpec specParentalDashBoard;
//		Intent intentSettings = new Intent().setClass(this,
//				frmListadoArticulos.class);
//		specParentalDashBoard = tabHost.newTabSpec("Venta")
//				.setIndicator("Venta").setContent(intentSettings);
//		tabHost.addTab(specParentalDashBoard);
//
//		TabHost.TabSpec specParentalDashBoard2;
//		Intent intentSettings2 = new Intent().setClass(this,
//				frmListadoClientes.class);
//		specParentalDashBoard2 = tabHost.newTabSpec("Detalle")
//				.setIndicator("Detalle").setContent(intentSettings2);
//		tabHost.addTab(specParentalDashBoard2);
//
//	}
//	// @Override
//	// public boolean onKeyDown(int keyCode, KeyEvent event) {
//	// KeyEvent.KEYCODE_BACK
//	// return super.onKeyDown(keyCode, event);
//	// }
//}
