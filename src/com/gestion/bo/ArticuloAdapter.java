package com.gestion.bo;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.gestion.R;
import com.gestion.dto.Articulo;
import com.gestion.dto.Cliente;
import com.gestion.view.articulos.ComparatorArticulo;

public class ArticuloAdapter extends ArrayAdapter<Articulo> {

	private List<Articulo> mArticulos, mAllArticulos;
	private int res;

	public ArticuloAdapter(Context context, int textViewResourceId,	List<Articulo> objects) {
		super(context, textViewResourceId, objects);
		this.mArticulos = objects;
		this.mAllArticulos = objects;
		this.res = textViewResourceId;
		// TODO Auto-generated constructor stub
	}
	@Override
	public void add(Articulo object) {
		mArticulos.add(object);
	    notifyDataSetChanged();
		
	}
	@Override
	public Filter getFilter() {
		// TODO Auto-generated method stub
		return new ArticuloFilter();
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mArticulos.size();
	}
    
	@Override
	public Articulo getItem(int pos) {
		// TODO Auto-generated method stub
	   return mArticulos.get(pos);
	}
	public void sort(int criterio) {
		Collections.sort(mArticulos, new ComparatorArticulo(criterio));
		notifyDataSetChanged();
	}

	@Override
	public View getView(int pos, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		LayoutInflater inflater = (LayoutInflater) getContext()
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = inflater.inflate(res, null);
		TextView lblId = (TextView) view.findViewById(R.id.lblId);
	    TextView lblCodigo = (TextView) view.findViewById(R.id.lblCodigo);
		TextView lblProducto = (TextView) view.findViewById(R.id.lblProducto);
		TextView lblCantidad = (TextView) view.findViewById(R.id.lblCantidad);
	    TextView lblPrecio = (TextView) view.findViewById(R.id.lblPrecio);
		TextView lblPrecioValue = (TextView) view.findViewById(R.id.lblPrecioValue);
//		ToggleButton btnEstado = (ToggleButton) view.findViewById(R.id.btnEstado);
        
		Articulo articulo = getItem(pos);
		lblId.setText(String.valueOf(articulo.getId()));
	    lblCodigo.setText(articulo.getCodigo());
		lblProducto.setText(articulo.getNombre());
		lblCantidad.setText(String.valueOf(articulo.getCantidad()));
	    lblPrecioValue.setText(String.valueOf(articulo.getCosto()));
	
		return view;
	}

	private class ArticuloFilter extends Filter {

		@Override
		protected FilterResults performFiltering(CharSequence constraint) {
			constraint = constraint.toString().toLowerCase();
			FilterResults filterResult = new FilterResults();
			List<Articulo> articulosFiltrados = new ArrayList<Articulo>();
			if (constraint != null && constraint.length() > 0) {
				for (Articulo art : mAllArticulos) {
					String text = art.toString().toLowerCase();
					if (text.contains(constraint)) {
						articulosFiltrados.add(art);
					}
					filterResult.count = articulosFiltrados.size();
					filterResult.values = articulosFiltrados;
				}
			} else {
				filterResult.count = mAllArticulos.size();
				filterResult.values = mAllArticulos;
			}
			return filterResult;
		}

		@Override
		protected void publishResults(CharSequence constraint,
				FilterResults results) {
			mArticulos = (List<Articulo>) results.values;
			notifyDataSetChanged();

		}

	}
}
