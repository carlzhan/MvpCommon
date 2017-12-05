package com.mvp.carl.common.base;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.mvp.carl.common.present.BaseContract;

import java.util.List;

/**
 * Created by Carl on 2017/12/5.
 * 基类activity
 */

public abstract class Activity<Present extends BaseContract.Present> extends AppCompatActivity implements BaseContract.View<Present> {
    private Present mPresent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initWindows();
        if (initArgs(getIntent().getExtras())) {
            setContentView(getContentLayoutId());
            initWidget();
            initData();
        } else {
            finish();
        }
    }

    /**
     * 初始化相关参数
     *
     * @param bundle 参数Bundle
     * @return 如果参数正确返回true，错误返回false 默认返回true
     */
    protected boolean initArgs(Bundle bundle) {
        return true;
    }

    /**
     * 获取当前界面资源文件id
     *
     * @return 资源文件id
     */
    protected abstract int getContentLayoutId();

    /**
     * 初始化数据
     */
    protected void initData() {
        mPresent = getBasePresenter();
        mPresent.subscibe();
    }

    /**
     * 获取具体控制类P
     *
     * @return 实现类
     */
    public abstract Present getBasePresenter();

    /**
     * 初始化控件
     */
    protected void initWidget() {
    }


    /**
     * 初始化窗口
     */
    protected void initWindows() {

    }

    /**
     * @return
     */
    @Override
    public boolean onSupportNavigateUp() {
        // 点击界面返回导航时，finish界面
        finish();
        return super.onSupportNavigateUp();
    }

    /**
     * 物理返回键
     */
    @SuppressLint("RestrictedApi")
    @Override
    public void onBackPressed() {
        // 遍历activity中的fragment，判断是否属于自己的fragment，判断fragment中onBackPressed是否为true，是则直接返回
        List<android.support.v4.app.Fragment> fragments = getSupportFragmentManager().getFragments();
        if (fragments != null && fragments.size() > 0) {
            for (android.support.v4.app.Fragment fragment : fragments) {
                if (fragment instanceof Fragment) {
                    if (((Fragment) fragment).onBackPressed()) {
                        return;
                    }
                }
            }
        }
        super.onBackPressed();
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onPause() {
        super.onPause();
        mPresent.unSubscibe();
    }

    @Override
    public void showErrorMessage(String message) {
        // TODO: 2017/12/5 showMessage 
    }

    @Override
    public void setLoadIndicator(boolean active) {
        // TODO: 2017/12/5 showLoadView 
    }
}
