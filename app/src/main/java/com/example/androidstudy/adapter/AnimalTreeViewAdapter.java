package com.example.androidstudy.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.androidstudy.R;
import com.example.androidstudy.bean.Animal;
import com.example.androidstudy.databinding.NodeBaseLayoutBinding;
import com.gyso.treeview.adapter.DrawInfo;
import com.gyso.treeview.adapter.TreeViewAdapter;
import com.gyso.treeview.adapter.TreeViewHolder;
import com.gyso.treeview.line.DashLine;
import com.gyso.treeview.model.NodeModel;
import com.gyso.treeview.line.BaseLine;


public class AnimalTreeViewAdapter extends TreeViewAdapter<Animal> {
    private DashLine dashLine =  new DashLine(Color.parseColor("#F06292"),6);
    private OnItemClickListener listener;

    public interface OnItemClickListener{
        void onItemClick(View item, NodeModel<Animal> node);
    }

    @Override
    public TreeViewHolder<Animal> onCreateViewHolder(@NonNull ViewGroup viewGroup, NodeModel<Animal> node) {
        NodeBaseLayoutBinding nodeBinding = NodeBaseLayoutBinding.inflate(LayoutInflater.from(viewGroup.getContext()),viewGroup,false);
        return new TreeViewHolder<>(nodeBinding.getRoot(),node);
    }

    @Override
    public void onBindViewHolder(@NonNull TreeViewHolder<Animal> holder) {
        View itemView = holder.getView();
        NodeModel<Animal> node = holder.getNode();
        TextView nameView = itemView.findViewById(R.id.name);
        ImageView headView = itemView.findViewById(R.id.portrait);
        final Animal animal = node.value;
        nameView.setText(animal.name);
        headView.setImageResource(animal.headId);
        headView.setOnClickListener(v -> {
            if(listener!=null){
                listener.onItemClick(v,node);
            }
        });
    }

    @Override
    public BaseLine onDrawLine(DrawInfo drawInfo) {
        return null;
    }
}
