package net.gzchunxiang.cx_widget_demo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class GridFragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<Item> items = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View view = inflater.inflate(R.layout.layout_fragment_list, container, false);
        recyclerView = view.findViewById(R.id.rv);

        for (int i = 0; i < 50; i++) {
            Item item = new Item();
            item.imgId = R.mipmap.ic_launcher;
            item.string = "list item " + i;
            items.add(item);
        }
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(),3);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new ListAdapter());

        return view;
    }

    class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {


        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = getLayoutInflater().inflate(R.layout.item_grid, null);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
            Item item = items.get(i);
            viewHolder.iv.setImageResource(item.imgId);
            viewHolder.tv.setText(item.string);

        }

        @Override
        public int getItemCount() {
            return items.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            ImageView iv;
            TextView tv;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                iv = itemView.findViewById(R.id.iv);
                tv = itemView.findViewById(R.id.tv);
            }
        }
    }

    @Override
    public void setArguments(Bundle args) {
        // TODO Auto-generated method stub
        super.setArguments(args);
    }

    class Item {
        int imgId;
        String string;
    }
}
