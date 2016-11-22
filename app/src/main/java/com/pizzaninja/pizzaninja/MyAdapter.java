package com.pizzaninja.pizzaninja;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.CustomViewHolder>{
    private List<FeedItem> feedItemList;
    private Context mContext;

    public MyAdapter(Context context, List<FeedItem> feedItemList) {
        this.feedItemList = feedItemList;
        this.mContext = context;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_row, null);
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder customViewHolder, int i) {
        FeedItem feedItem = feedItemList.get(i);
        customViewHolder.textView.setText(Html.fromHtml(feedItem.getTitle()));
    }

    @Override
    public int getItemCount() {
        return (null != feedItemList ? feedItemList.size() : 0);
    }

    class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        protected Button button;
        protected TextView textView;

        public CustomViewHolder(View view) {
            super(view);
            button = (Button) view.findViewById(R.id.button);
            button.setOnClickListener(this);
            textView = (TextView) view.findViewById(R.id.title);
        }

        @Override
        public void onClick(View v) {
            String item = textView.getText().toString();
            MenuActivity ma = MenuActivity.getInstance();
            //ma.AddItem(item);
        }
    }


}