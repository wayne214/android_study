package com.example.androidstudy.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidstudy.R;
import com.example.androidstudy.bean.TestData;
import com.google.android.flexbox.FlexboxLayout;

import java.util.List;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder>{

    private List<TestData> data;
    private Context myContext;

    public MyRecyclerAdapter(Context context, List<TestData> data) {
        this.myContext = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cell, parent, false);
        return new MyViewHolder(inflate);
    }

    public interface ItemCellClicker{
        void onItemClick(String tag);
    }

    public ItemCellClicker itemCellClicker;

    public void setItemCellClicker(ItemCellClicker itemCellClicker){
        this.itemCellClicker = itemCellClicker;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
//        holder.setIsRecyclable(false);

        TextView title = holder.itemView.findViewById(R.id.tv_title);
        FlexboxLayout flexboxLayout = holder.itemView.findViewById(R.id.flexbox_layout);

        TestData data = this.data.get(position);
        List<String> tags = data.getTag();
        flexboxLayout.removeAllViews();
        for (int i = 0; i < tags.size(); i++) {
            String temp = tags.get(i);
            View tagView = LayoutInflater.from(myContext).inflate(R.layout.item_tag_cell, null, false);
            TextView tag = tagView.findViewById(R.id.tv_tag);
            tag.setText(temp);
            tag.setOnClickListener(view -> itemCellClicker.onItemClick(temp));
            flexboxLayout.addView(tagView);
        }
        title.setText(data.getTitle());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
