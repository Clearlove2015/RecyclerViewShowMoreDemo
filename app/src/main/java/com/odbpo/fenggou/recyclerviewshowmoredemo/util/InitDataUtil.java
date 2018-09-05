package com.odbpo.fenggou.recyclerviewshowmoredemo.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zc
 * @Time: 2018/3/22 13:25
 * @Desc: 生成模拟数据
 */
public class InitDataUtil {

    public static List<Integer> getFData() {
        List<Integer> mData = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            mData.add(i);
        }
        return mData;
    }

}
