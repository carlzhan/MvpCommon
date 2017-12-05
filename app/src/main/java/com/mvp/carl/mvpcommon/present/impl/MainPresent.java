package com.mvp.carl.mvpcommon.present.impl;

import android.content.Context;

import com.mvp.carl.common.present.BasePresenter;
import com.mvp.carl.mvpcommon.present.MainContract;

/**
 * Created by Carl on 2017/12/5.
 */

public class MainPresent extends BasePresenter<MainContract.View> implements MainContract.Present {

    private final Context mContext;
    private final MainContract.View mRootView;

    public MainPresent(Context context, MainContract.View view) {
        super(context, view);
        mContext = context;
        mRootView = getRootView();
    }

    @Override
    public void requestNet() {
        // 获取网络数据部分
        mRootView.refreshData("");
    }

    @Override
    public void changeData(String str) {
        // 对数据进行逻辑操作
        String s = str + "满意请点赞，谢谢大家";
        mRootView.showTitle(s);
    }
}
