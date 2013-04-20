package com.gestion.bo;

import java.util.ArrayList;
import java.util.List;
import com.gestion.R;
import com.gestion.dto.Cliente;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;


public class ClienteAdapter extends ArrayAdapter<Cliente> {
	private List<Cliente> mClientes,mAllClientes;
	private int res;

	public ClienteAdapter(Context context, int textViewResourceId,List<Cliente> objects) {
		super(context, textViewResourceId, objects);
		this.res = textViewResourceId;
		this.mClientes = objects;
		this.mAllClientes = objects;
		// TODO Auto-generated constructor stub
	}
	@Override
	public Filter getFilter() {
		return new ClienteFilter();
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mClientes.size();
	}

	@Override
	public Cliente getItem(int pos) {
		// TODO Auto-generated method stub
		return mClientes.get(pos);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int pos, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = inflater.inflate(res, null);
		ImageView ivFoto = (ImageView) view.findViewById(R.id.ivFoto);
		TextView lblNombre = (TextView) view.findViewById(R.id.lblNombre); 
		TextView lblApellido = (TextView) view.findViewById(R.id.lblApellido); 
		TextView lblCuit = (TextView) view.findViewById(R.id.lblCuit);
		TextView lblDomicilio = (TextView) view.findViewById(R.id.lblDomicilio);
		TextView lblDomicilioValue = (TextView) view.findViewById(R.id.lblDomicilioValue);
		ToggleButton btnEstado=  (ToggleButton) view.findViewById(R.id.btnEstado);
		
		Cliente cliente = getItem(pos);
		lblApellido.setText(cliente.getApellido());
		lblNombre.setText(cliente.getNombre());
		lblCuit.setText(cliente.getCiut());
		lblDomicilio.setText(cliente.getDomicilio());
		btnEstado.setChecked(cliente.isEstado());
		
		
		return view;
	}
	private class ClienteFilter extends Filter{

		@Override
		protected FilterResults performFiltering(CharSequence constraint) {
			
			  constraint = constraint.toString().toLowerCase();
			  FilterResults filterResults = new FilterResults();
			  List<Cliente> clientesFiltrados = new ArrayList<Cliente>();
			  if(constraint != null && constraint.length() > 0){
				  
				  for(Cliente art: mAllClientes){
					  String text = art.toString().toLowerCase();
					  if (text.contains(constraint))
					  {
						  clientesFiltrados.add(art);
					  }
					  filterResults.count = clientesFiltrados.size();
					  filterResults.values = clientesFiltrados;
				  }
					  
				  
			  }
			  else
			  {
			  filterResults.count = mAllClientes.size();
			  filterResults.values = mAllClientes;
			  }
			  
			  return filterResults;
			  
		}
		  
		  @Override
			protected void publishResults(CharSequence constraint, FilterResults result) {
			  mClientes = (List<Cliente>)result.values;
				notifyDataSetChanged();
				
			}
		  
		}

	
		
	}
