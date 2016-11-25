package com.mifincaapp.mifincaapp.adapters;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mifincaapp.mifincaapp.R;
import com.mifincaapp.mifincaapp.db.Reg_inventario;

import java.util.List;

/**
 * Created by GARF on 23/11/2016.
 */

public class InventarioAdapter extends RecyclerView.Adapter<InventarioAdapter.CustomViewHolder> {
    public static final String TAG = InventarioAdapter.class.getName();
    List<Reg_inventario> mItems;

    public InventarioAdapter(List<Reg_inventario> items) {
        mItems = items;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.inventario_item, parent, false);
        CustomViewHolder customViewHolder = new CustomViewHolder(view);
        return customViewHolder;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: " + position);
        holder.mTextFecha.setText(mItems.get(position).getFecha());
        holder.mTextArete.setText(mItems.get(position).getArete());
        holder.mTextEdad.setText(mItems.get(position).getEdad());
        holder.mTextCategoria.setText(mItems.get(position).getCategoria());
        holder.mTextRaza.setText(mItems.get(position).getRaza());
        //holder.mTextAge.setText(String.valueOf(mItems.get(position).getEdad()));
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: " + mItems.size());
        return mItems.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {
        TextView mTextFecha;
        TextView mTextArete;
        TextView mTextEdad;
        TextView mTextCategoria;
        TextView mTextRaza;

        public CustomViewHolder(View itemView) {
            super(itemView);
            mTextFecha = (TextView) itemView.findViewById(R.id.tvFecha);
            mTextArete = (TextView) itemView.findViewById(R.id.tvArete);
            mTextEdad = (TextView) itemView.findViewById(R.id.tvEdad);
            mTextCategoria = (TextView) itemView.findViewById(R.id.tvCategoria);
            mTextRaza = (TextView) itemView.findViewById(R.id.tvRaza);
        }
    }
}
