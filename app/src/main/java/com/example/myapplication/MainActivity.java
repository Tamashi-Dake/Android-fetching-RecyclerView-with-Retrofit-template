package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.myapplication.model.DataJson;
import com.example.myapplication.model.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rcvItem;
    private List<Item> items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcvItem = findViewById(R.id.rcv);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rcvItem.setLayoutManager(linearLayoutManager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, linearLayoutManager.getOrientation());
        rcvItem.addItemDecoration(dividerItemDecoration);


        getItemListFromAPI();
    }

//    private void getItemListFromAPI() {
//        ApiService.apiService.getListItems(
////                1
//                )
//                .enqueue(new Callback<List<Item>>() {
//                    @Override
//                    public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
//                        items = response.body();
//                        if (items == null) {
//                            return;
//                        }
//                        List<Item> itemList =new ArrayList<>();
//                        for (Item item : items) {
//                            itemList.add(new Item(item.getId(),item.getName()));
//                        }
//                        ItemAdapter itemAdapter = new ItemAdapter(MainActivity.this, itemList);
//                        rcvItem.setAdapter(itemAdapter);
//                    }
//
//                    @Override
//                    public void onFailure(Call<List<Item>> call, Throwable t) {
//                        Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
//                    }
//                });
//    }
    private void getItemListFromAPI() {
        ApiService.apiService.getListItems()
                .enqueue(new Callback<DataJson<Item>>() {
                    @Override
                    public void onResponse(Call<DataJson<Item>> call, Response<DataJson<Item>> response) {
                        DataJson<Item> dataJson = response.body();
                        if (dataJson == null) {
                            return;
                        }
                        if (Objects.equals(dataJson.isStatus(), "success")) {
                            List<Item> items = dataJson.getData();
                            List<Item> itemList =new ArrayList<>();
                            for (int i = 0; i < items.size(); i++) {
                                itemList.add(new Item(
                                        items.get(i).getId(),
                                        items.get(i).getEmployee_name(),
                                        items.get(i).getProfile_image()
                                ));
                            }
                            ItemAdapter itemAdapter = new ItemAdapter(MainActivity.this, itemList);
                            rcvItem.setAdapter(itemAdapter);
                        }
                    }
                    @Override
                    public void onFailure(Call<DataJson<Item>> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}