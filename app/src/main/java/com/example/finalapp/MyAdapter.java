package com.example.finalapp;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private List<String> dataListTitulo;
    private List<String> dataListDesc;

    private Context context;

    public MyAdapter(List<String> dataList, List<String> dataListDesc ,Context context) {
        this.dataListTitulo = dataList;
        this.dataListDesc = dataListDesc;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        String itemTituolo = dataListTitulo.get(position);
        String itemDesc = dataListDesc.get(position);
        holder.textViewItem.setText(itemTituolo);
        holder.textViewDescripcion.setText(itemDesc);

    }

    @Override
    public int getItemCount() {
        return dataListTitulo.size();
    }
}
