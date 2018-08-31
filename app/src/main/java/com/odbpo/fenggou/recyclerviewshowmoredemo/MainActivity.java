package com.odbpo.fenggou.recyclerviewshowmoredemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.odbpo.fenggou.recyclerviewshowmoredemo.adapter.RVAdapter;
import com.odbpo.fenggou.recyclerviewshowmoredemo.util.InitDataUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.rv)
    RecyclerView rv;
    @Bind(R.id.tv_show_more)
    TextView tvShowMore;

    private static final int SHOW_NUM = 7;//收起列表时展示条数

    private List<Integer> mList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initRV();
    }

    public void initList() {
        if (InitDataUtil.getFData().size() > SHOW_NUM) {
            mList.clear();
            for (Integer i : InitDataUtil.getFData()) {
                mList.add(i);
                if (mList.size() == SHOW_NUM) {
                    break;
                }
            }
        } else {
            mList.clear();
            mList = InitDataUtil.getFData();
        }
    }

    public void initRV() {
        initList();
        rv.setLayoutManager(new GridLayoutManager(this, 4, LinearLayoutManager.VERTICAL, false));
        rv.setAdapter(new RVAdapter(mList));
    }

    @OnClick({R.id.tv_show_more})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_show_more:
                if (mList.size() > SHOW_NUM) {//收起
                    tvShowMore.setText("查看更多");
                    hideItem();
                } else {//查看更多
                    tvShowMore.setText("收起");
                    showItem();
                }
                break;
        }
    }

    public void hideItem() {
        mList.clear();
        for (Integer i : InitDataUtil.getFData()) {
            mList.add(i);
            if (mList.size() == SHOW_NUM) {
                break;
            }
        }
        rv.setAdapter(new RVAdapter(mList));
    }

    public void showItem() {
        mList.clear();
        mList = InitDataUtil.getFData();
        rv.setAdapter(new RVAdapter(mList));
    }

}
