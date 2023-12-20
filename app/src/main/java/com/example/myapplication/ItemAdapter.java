package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.model.Item;

import java.util.List;


public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder>{
    private List<Item> items;
    private Context context;
    public ItemAdapter(Context context,List<Item> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_rcv, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
    Item item =  items.get(position);
    if (item == null) {
        return;
    }
        Glide.with(holder.itemView.getContext()).load(item.getProfile_image()).placeholder(R.drawable.ic_launcher_foreground).centerCrop().into(holder.img);
//    holder.tvName.setText(String.valueOf(item.getName()));\
    holder.tvName.setText(String.valueOf(item.getEmployee_name()));
    holder.itemLayout.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            onClickDetail(item);
        }
    });
    }

    private void onClickDetail(Item item) {
        Intent intent = new Intent(context, DeltailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("item", item);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }


    @Override
    public int getItemCount() {
        if (items != null) {
            return items.size();
        }
        return 0;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView tvName;
        private ConstraintLayout itemLayout;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            itemLayout = itemView.findViewById(R.id.wrapper);
            img = itemView.findViewById(R.id.img);
        }
    }
}
