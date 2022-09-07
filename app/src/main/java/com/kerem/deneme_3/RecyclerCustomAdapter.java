package com.kerem.deneme_3;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerCustomAdapter extends RecyclerView.Adapter<RecyclerCustomAdapter.ViewHolder> {

        Context context;
        ArrayList<KayitSinifi> kayitDizisi= new ArrayList<>();
        RecycleViewClickİnterface  recycleViewClickİnterface;

    public RecyclerCustomAdapter(Context context, ArrayList<KayitSinifi> kayitDizisi, MainActivity mainActivity) {
        this.context = context;
        this.kayitDizisi = kayitDizisi;
        this.recycleViewClickİnterface = recycleViewClickİnterface;


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout,parent,false);
        ViewHolder viewHolder = new ViewHolder (view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.imaj.setImageResource(kayitDizisi.get(position).imaj);
        holder.baslik.setText(kayitDizisi.get(position).baslik);
        holder.aciklama.setText(kayitDizisi.get(position).aciklama);
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(context,kayitDizisi.get(position).baslik,Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return kayitDizisi.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

            ImageView   imaj;
            TextView    baslik;
            TextView    aciklama;
            LinearLayout parentLayout;



            public ViewHolder(@NonNull View itemView) {
                super(itemView);

                imaj= itemView.findViewById(R.id.icon_image);
                baslik =itemView.findViewById(R.id.baslik_txt);
                aciklama=itemView.findViewById(R.id.aciklama_txt);
                parentLayout=itemView.findViewById(R.id.parentLayout);


                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        recycleViewClickİnterface.onItemClick(getAdapterPosition());
                    }
                });



                itemView.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View view) {
                        recycleViewClickİnterface.onItemLongClick(getAdapterPosition());
                        return true;
                    }
                });



            }
        }
}

























