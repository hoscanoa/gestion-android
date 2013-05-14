package com.gestion.view.cliente;

import com.gestion.R;
import com.gestion.utils.Preferencia;

import android.app.AlertDialog.Builder;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

public class DialogOrdenarCliente extends DialogFragment {
	ItemListener mItemListener;
	private Preferencia mPreferencia;
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		Builder builder = new Builder(getActivity());
		mPreferencia = new Preferencia(getActivity());
		int criterio = mPreferencia.getCriterioOrdenarCliente();
		builder.setSingleChoiceItems(R.array.OrdenarCliente, criterio, new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int position) {
			//	mItemListener.onItemSelected(position);
			//	dialog.dismiss();

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
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		// Verify that the host activity implements the callback interface
		try {
			// Instantiate the NoticeDialogListener so we can send events to the
			// host
			mItemListener = (ItemListener) activity;
		} catch (ClassCastException e) {
			// The activity doesn't implement the interface, throw exception
			throw new ClassCastException(activity.toString()
					+ " must implement NoticeDialogListener");
		}
	}
	
	public interface ItemListener{
		public void onItemSelected(int position);

		}
}
