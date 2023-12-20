package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.Toast;

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

        IntentFilter intentFilter = new IntentFilter("android.intent.action.AIRPLANE_MODE");

        BroadcastReceiver receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
               Toast.makeText(context, "Airplane mode ON/OFF", Toast.LENGTH_SHORT).show();
            }
        };

        this.registerReceiver(receiver, intentFilter);

        rcvItem = findViewById(R.id.rcv);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rcvItem.setLayoutManager(linearLayoutManager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, linearLayoutManager.getOrientation());
        rcvItem.addItemDecoration(dividerItemDecoration);
        if(isNetworkStatusAvialable (getApplicationContext())) {
            getItemListFromAPI();
        } else {
            Toast.makeText(this, "Không có kết nối mạng, vui lòng thử lại", Toast.LENGTH_SHORT).show();
        }
    }
    public static boolean isNetworkStatusAvialable (Context context) {
        ConnectivityManager cm =
                (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();

    }
    private void getItemListFromAPI() {
        ApiService.apiService.getListItems()
                .enqueue(new Callback<List<Item>>() {
                    @Override
                    public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
                        items = response.body();
                        if (items == null) {
                            return;
                        }
                        List<Item> itemList =new ArrayList<>();
                        for (Item item : items) {
                            itemList.add(new Item(item.getUserId(), item.getId(),item.getTitle(),item.getBody()));
                        }
                        ItemAdapter itemAdapter = new ItemAdapter(MainActivity.this, itemList);
                        rcvItem.setAdapter(itemAdapter);
                    }

                    @Override
                    public void onFailure(Call<List<Item>> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}