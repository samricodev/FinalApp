package com.example.finalapp;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {
    public TextView textViewItem, textViewDescripcion;

    public MyViewHolder(View itemView) {
        super(itemView);
        textViewItem = itemView.findViewById(R.id.lblNombre);
        textViewDescripcion = itemView.findViewById(R.id.lblDescripcion);
    }
}


