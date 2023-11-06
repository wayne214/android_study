package com.example.androidstudy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;

import com.example.androidstudy.adapter.AnimalTreeViewAdapter;
import com.example.androidstudy.bean.Animal;
import com.example.androidstudy.databinding.ActivityMainBinding;
import com.gyso.treeview.GysoTreeView;
import com.gyso.treeview.TreeViewEditor;
import com.gyso.treeview.layout.TreeLayoutManager;
import com.gyso.treeview.line.BaseLine;
import com.gyso.treeview.line.SmoothLine;
import com.gyso.treeview.model.NodeModel;

import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

public class TreeViewActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();
    private ActivityMainBinding binding;
    private final Stack<NodeModel<Animal>> removeCache = new Stack();
    private NodeModel<Animal> targetNode;
    private AtomicInteger atomicInteger = new AtomicInteger();
    private Handler handler = new Handler();
    private NodeModel<Animal> parentToRemoveChildren = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_tree_view);
        initViews();
    }

    private void initViews() {
        //1 customs adapter
        AnimalTreeViewAdapter adapter = new AnimalTreeViewAdapter();

        //2 configure layout manager; unit dp
//        TreeLayoutManager treeLayoutManager = getTreeLayoutManager();

        //3 view setting
//        binding.baseTreeView.setAdapter(adapter);
//        binding.baseTreeView.setTreeLayoutManager(treeLayoutManager);
//
//        //4 nodes data setting
//        setData(adapter);
//
//        //5 get an editor. Note: an adapter must set before get an editor.
//        final TreeViewEditor editor = binding.baseTreeView.getEditor();
    }

//    private TreeLayoutManager getTreeLayoutManager() {
//        int space_50dp = 30;
//        int space_20dp = 20;
//        BaseLine line = getLine();
////        return new BoxRightTreeLayoutManager(this,space_50dp,space_20dp,line);
////        return new BoxDownTreeLayoutManager(this,space_50dp,space_20dp,line);
////        return new BoxLeftTreeLayoutManager(this,space_50dp,space_20dp,line);
////        return new BoxUpTreeLayoutManager(this,space_50dp,space_20dp,line);
////        return new BoxHorizonLeftAndRightLayoutManager(this,space_50dp,space_20dp,line);
////        return new BoxVerticalUpAndDownLayoutManager(this,space_50dp,space_20dp,line);
//    }

    private BaseLine getLine() {
        return new SmoothLine();
        //return new StraightLine(Color.parseColor("#055287"),2);
        //return new DashLine(Color.parseColor("#F1286C"),3);
        //return new AngledLine();
    }
}