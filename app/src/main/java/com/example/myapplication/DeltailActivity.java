package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplication.model.Item;

public class DeltailActivity extends AppCompatActivity {
    private Item item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deltail);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle == null) {
            return;
        }
        item = (Item) bundle.getSerializable("item");

        ImageView img = findViewById(R.id.imgDetail);
        TextView tvName = findViewById(R.id.tvName);


        tvName.setText(item.getEmployee_name());
        Glide.with(this).load(item.getProfile_image()).placeholder(R.drawable.ic_launcher_background).centerCrop().into(img);

        ImageButton btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(v -> {
            finish();
        });

    }
}