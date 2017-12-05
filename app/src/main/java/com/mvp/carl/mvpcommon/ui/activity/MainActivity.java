package com.mvp.carl.mvpcommon.ui.activity;

import android.widget.TextView;

import com.mvp.carl.common.base.Activity;
import com.mvp.carl.mvpcommon.R;
import com.mvp.carl.mvpcommon.present.MainContract;
import com.mvp.carl.mvpcommon.present.impl.MainPresent;

public class MainActivity extends Activity<MainContract.Present> implements MainContract.View {


    private MainContract.Present mMainPresenter;
    private TextView mTvTitle;

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initWidget() {
        super.initWidget();
        mTvTitle = findViewById(R.id.mtv_title);
    }

    @Override
    public MainContract.Present getBasePresenter() {
        return new MainPresent(this, this);
    }


    @Override
    public void refreshData(Object data) {
        // TODO: 2017/12/5 处理接口返回数据 此处用假数据
        // 调用present处理文本刷新功能
        mMainPresenter.changeData("hi");
    }

    @Override
    public void setPresenter(MainContract.Present presenter) {
        mMainPresenter = presenter;
    }

    @Override
    public void showTitle(String str) {
        // 处理view回填数据
        mTvTitle.setText(str);
    }
}
