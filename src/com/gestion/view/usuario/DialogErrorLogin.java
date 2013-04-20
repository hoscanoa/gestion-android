package com.gestion.view.usuario;


import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

public class DialogErrorLogin extends DialogFragment {
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
           
		Builder builder = new Builder(getActivity());
         
		builder.setPositiveButton("Ok", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				
			}
		});
		
		return builder.create();
	}
}
