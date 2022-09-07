package com.kerem.deneme_3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecycleViewClickİnterface {

    ArrayList<KayitSinifi> kayitDizisi= new ArrayList<>();
    KayitSinifi kayit;
    Context context = this;
    int imaj;
    RecyclerView RecyclerView;
    RecyclerCustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView=findViewById(R.id.rec_view);
        imaj=R.drawable.elma;
        kayit= new KayitSinifi(imaj,"elma","kırmızı");
        kayitDizisi.add(kayit);

        imaj=R.drawable.armut;
        kayit= new KayitSinifi(imaj,"armut","sarı");
        kayitDizisi.add(kayit);

        imaj=R.drawable.cilek;
        kayit= new KayitSinifi(imaj,"çilek","kırmızı");
        kayitDizisi.add(kayit);

        imaj=R.drawable.karpuz;
        kayit= new KayitSinifi(imaj,"karpuz","yeşil");
        kayitDizisi.add(kayit);

        imaj=R.drawable.uzum;
        kayit= new KayitSinifi(imaj,"üzüm","mor");
        kayitDizisi.add(kayit);

        adapter= new RecyclerCustomAdapter(context,kayitDizisi,this);
        RecyclerView.setAdapter(adapter);
        RecyclerView.setLayoutManager(new LinearLayoutManager(context));













    }

    @Override
    public void onItemClick(int position) {


    }

    @Override
    public void onItemLongClick(int position) {

    }
}