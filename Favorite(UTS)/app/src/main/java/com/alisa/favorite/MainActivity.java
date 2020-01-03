package com.alisa.favorite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvFavorite;
    private ArrayList<Favorite> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle("My Favorite Volleyball Player");
        }

        rvFavorite = findViewById(R.id.rv_favorite);
        rvFavorite.setHasFixedSize(true);

        list.addAll(getListFavorite());
        showRecycleList();
    }

    public ArrayList<Favorite> getListFavorite() {
        String[] dataName = getResources().getStringArray(R.array.data_name);
        String[] dataDescription = getResources().getStringArray(R.array.data_description);
        String[] dataPhoto = getResources().getStringArray(R.array.photo);

        ArrayList<Favorite> listFavorite = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++){
            Favorite favorite = new Favorite();
            favorite.setName(dataName[i]);
            favorite.setDescription(dataDescription[i]);
            favorite.setPhoto(dataPhoto[i]);

            listFavorite.add(favorite);
        }
        return listFavorite;
    }

    private void showRecycleList(){
        rvFavorite.setLayoutManager(new LinearLayoutManager(this));
        ListFavoriteAdapter listFavoriteAdapter = new ListFavoriteAdapter(list);
        rvFavorite.setAdapter(listFavoriteAdapter);
    }
}
