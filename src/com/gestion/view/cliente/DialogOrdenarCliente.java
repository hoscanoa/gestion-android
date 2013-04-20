package com.gestion.view.cliente;

import com.gestion.R;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

public class DialogOrdenarCliente extends DialogFragment {
	ItemLiestener mItemListener;
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		Builder builder = new Builder(getActivity());
		builder.setSingleChoiceItems(R.array.OrdenarCliente, 1, new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				mItemListener.onItemSelected();
				
			}
		});
		
		builder.setNegativeButton("Cancelar", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
				
			}
		});
		
		return builder.create();
	}
	
	public interface ItemLiestener{
		public void onItemSelected();

		}
}
