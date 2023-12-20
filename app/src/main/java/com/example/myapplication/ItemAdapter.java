package com.example.myapplication;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

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
    holder.tvId.setText(String.valueOf(item.getId()));
    holder.tvName.setText(String.valueOf(item.getTitle()));
    holder.tvBody.setText(String.valueOf(item.getBody()));
    holder.itemLayout.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(context, "User id: " + item.getUserId(), Toast.LENGTH_SHORT).show();
        }
    });
        holder.itemLayout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                showDeleteConfirmationDialog(item, position);
                return true;
            }
        });
    }

    private void showDeleteConfirmationDialog(final Item item, final int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Xóa bài viết");
        builder.setMessage("Có thực sự muốn xóa bài viết này không?");
        builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                deleteItem(position);
            }
        });
        builder.setNegativeButton("Không", null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }
    private void deleteItem(int position) {
        if (position >= 0 && position < items.size()) {
            items.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, items.size());
        }
    }
    @Override
    public int getItemCount() {
        if (items != null) {
            return items.size();
        }
        return 0;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        private TextView tvId;
        private TextView tvName;
        private TextView tvBody;
        private ConstraintLayout itemLayout;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            tvId = itemView.findViewById(R.id.tvId);
            tvName = itemView.findViewById(R.id.tvName);
            tvBody = itemView.findViewById(R.id.tvBody);
            itemLayout = itemView.findViewById(R.id.wrapper);
        }
    }
}
