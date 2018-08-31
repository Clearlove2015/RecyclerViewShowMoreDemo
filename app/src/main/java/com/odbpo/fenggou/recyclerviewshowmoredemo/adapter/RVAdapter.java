package com.odbpo.fenggou.recyclerviewshowmoredemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.odbpo.fenggou.recyclerviewshowmoredemo.R;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @author: zc
 * @Time: 2018/8/31 14:09
 * @Desc:
 */
public class RVAdapter extends RecyclerView.Adapter {
    private List<Integer> mData;

    public RVAdapter(List<Integer> mData) {
        this.mData = mData;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_rv, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ItemViewHolder itemHolder = (ItemViewHolder) holder;
        itemHolder.tv.setText("item - " + mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.tv)
        TextView tv;

        public ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
