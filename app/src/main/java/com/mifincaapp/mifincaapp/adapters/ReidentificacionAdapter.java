package com.mifincaapp.mifincaapp.adapters;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mifincaapp.mifincaapp.R;
import com.mifincaapp.mifincaapp.db.Reg_reidentificacion;

import java.util.List;

/**
 * Created by USUARIO on 28/11/2016.
 */

public class ReidentificacionAdapter extends RecyclerView.Adapter<ReidentificacionAdapter.CustomViewHolder> {
    public static final String TAG = ReidentificacionAdapter.class.getName();
    List<Reg_reidentificacion> mItems;

    public ReidentificacionAdapter(List<Reg_reidentificacion> items) {
        mItems = items;
    }

    @Override
    public ReidentificacionAdapter.CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.inventario_item, parent, false);
        ReidentificacionAdapter.CustomViewHolder customViewHolder = new ReidentificacionAdapter.CustomViewHolder(view);
        return customViewHolder;
    }

    @Override
    public void onBindViewHolder(ReidentificacionAdapter.CustomViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: " + position);
        holder.mTextFecha.setText(mItems.get(position).getFecha());
        holder.mTextAreteanterior.setText(mItems.get(position).getAreteanterior());
        holder.mTextAretenuevo.setText(mItems.get(position).getAretenuevo());
        holder.mTextMotivocambio.setText(mItems.get(position).getMotivocambio());
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
        TextView mTextAreteanterior;
        TextView mTextAretenuevo;
        TextView mTextMotivocambio;

        public CustomViewHolder(View itemView) {
            super(itemView);
            mTextFecha = (TextView) itemView.findViewById(R.id.tvFecha);
            mTextAreteanterior = (TextView) itemView.findViewById(R.id.tvAreteanterior);
            mTextAretenuevo = (TextView) itemView.findViewById(R.id.tvAretenuevo);
            mTextMotivocambio = (TextView) itemView.findViewById(R.id.tvMotivocambio);
        }
    }
}
