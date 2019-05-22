package com.gqhl.hz.rvverticalvideo;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    PagerLayoutManager pagerLayoutManager;
    private int[] colors = {R.color.colorAccent,R.color.colorAccent1};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv_vertical);

        pagerLayoutManager = new PagerLayoutManager(this);
        pagerLayoutManager.setItemPrefetchEnabled(true);
        recyclerView.setLayoutManager(pagerLayoutManager);
        recyclerView.setAdapter(new MyAdapter());
    }

    private class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {


        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return new MyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(android.R.layout.simple_list_item_1,viewGroup,false));
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
            myViewHolder.textView.setText("AA --- " + i);
            myViewHolder.textView.setBackgroundResource(colors[i%2]);
        }

        @Override
        public int getItemCount() {
            return 10;
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            TextView textView;
            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                textView = itemView.findViewById(android.R.id.text1);
                ViewGroup.LayoutParams params = itemView.getLayoutParams();
                params.width = itemView.getResources().getDisplayMetrics().widthPixels;
                params.height =  itemView.getResources().getDisplayMetrics().heightPixels;
                textView.setLayoutParams(params);
            }
        }
    }
}
