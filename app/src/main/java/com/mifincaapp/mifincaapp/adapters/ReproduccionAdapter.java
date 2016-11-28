package com.mifincaapp.mifincaapp.adapters;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mifincaapp.mifincaapp.R;
import com.mifincaapp.mifincaapp.db.Reg_Control;


import java.util.List;

/**
 * Created by GARF on 27/11/2016.
 */

public class ReproduccionAdapter extends RecyclerView.Adapter<ReproduccionAdapter.CustomViewHolder>{
    public static final String TAG = ReproduccionAdapter.class.getName();
    List<Reg_Control> mItems;

    public ReproduccionAdapter(List<Reg_Control> items) {
        mItems = items;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_reproduccion, parent, false);
        CustomViewHolder customViewHolder = new CustomViewHolder(view);
        return customViewHolder;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: " + position);
        holder.mTextArete.setText(mItems.get(position).getArete());
        holder.mTextDiagnostico.setText(mItems.get(position).getDesarrollo());
        holder.mTextMetodo.setText(mItems.get(position).getMetodo());
        holder.mTextSemental.setText(mItems.get(position).getSemental());
        holder.mTextParto.setText(mItems.get(position).getParto());
        holder.mTextDesarrollo.setText(mItems.get(position).getDesarrollo());
        holder.mTextCrias.setText(mItems.get(position).getCrias());
        holder.mTextComentarios.setText(mItems.get(position).getComentarios());
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
        TextView mTextArete;
        TextView mTextDiagnostico;
        TextView mTextMetodo;
        TextView mTextSemental;
        TextView mTextParto;
        TextView mTextDesarrollo;
        TextView mTextCrias;
        TextView mTextComentarios;

        public CustomViewHolder(View itemView) {
            super(itemView);
            mTextArete = (TextView) itemView.findViewById(R.id.tvArete);
            mTextDiagnostico = (TextView) itemView.findViewById(R.id.tvDiagnostico);
            mTextMetodo = (TextView) itemView.findViewById(R.id.tvMetodo);
           mTextSemental = (TextView) itemView.findViewById(R.id.tvSemental);
            mTextParto = (TextView) itemView.findViewById(R.id.tvParto);
            mTextDesarrollo = (TextView) itemView.findViewById(R.id.tvDesarrollo);
            mTextCrias = (TextView) itemView.findViewById(R.id.tvDesarrollo);
            mTextComentarios = (TextView) itemView.findViewById(R.id.tvComentarios);
        }
    }
}
