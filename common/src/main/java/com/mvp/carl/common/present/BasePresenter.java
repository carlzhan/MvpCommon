package com.mvp.carl.common.present;

import android.content.Context;


/**
 * Created by Carl on 2017/12/5.
 * Presenter基类，子类继承后需要实现子类自定义的Contract extends BaseContract
 */

public abstract class BasePresenter<T extends BaseContract.View> implements BaseContract.Present {

    private final Context mContext;
    private final T mRootView;

    public BasePresenter(Context context, T view) {
        mContext = context;
        mRootView = view;
        mRootView.setPresenter(this);
    }

    @Override
    public void subscibe() {
        requestNet();
    }

    public abstract void requestNet();

    @Override
    public void unSubscibe() {
        
    }

    @Override
    public void refreshData() {

    }

    public T getRootView() {
        return mRootView;
    }


}