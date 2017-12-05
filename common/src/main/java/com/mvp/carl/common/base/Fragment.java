package com.mvp.carl.common.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mvp.carl.common.present.BaseContract;


/**
 * Created by Carl on 2017/12/5.
 * fragment基类
 */

public abstract class Fragment<Present extends BaseContract.Present> extends android.support.v4.app.Fragment implements BaseContract.View<Present> {
    private View mRootView;
    protected Context mContext;
    private Present mPresent;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        // 处理初始化参数
        initArgs(getArguments());
        mContext = getContext();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mRootView == null) {
            mRootView = inflater.inflate(getContentLayoutId(), container, false);
            initWidget(mRootView);
        } else {
            if (mRootView.getParent() != null) {
                ((ViewGroup) mRootView).removeView(mRootView);
            }
        }

        return mRootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // View创建完成
        initData();
    }

    protected void initData() {
        mPresent = getPresenter();
        mPresent.subscibe();
    }

    /**
     * 获取具体控制类P
     *
     * @return 实现类
     */
    public abstract Present getPresenter();

    protected void initWidget(View view) {
    }

    /**
     * 设置标题头
     *
     * @param resId 文本信息id
     */
    public void setTitle(int resId) {

    }

    /**
     * 获取文件资源id
     *
     * @return 返回资源文件id
     */
    protected abstract int getContentLayoutId();

    /**
     * 初始化参数
     */
    protected void initArgs(Bundle arguments) {

    }

    /**
     * 返回按键触发时调用
     *
     * @return 返回true代表我已经处理返回逻辑，activity不用finish
     * 返回false代表我没有处理逻辑，activity自己走自己的逻辑
     */
    public boolean onBackPressed() {
        return false;
    }


    @Override
    public void showErrorMessage(String message) {
        // TODO: 2017/12/5 showMessage 
    }

    @Override
    public void setLoadIndicator(boolean active) {
        // TODO: 2017/12/5 showLoadView 
    }

    @Override
    public void onPause() {
        super.onPause();
        mPresent.unSubscibe();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
