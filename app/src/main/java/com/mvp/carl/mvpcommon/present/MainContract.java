package com.mvp.carl.mvpcommon.present;

import com.mvp.carl.common.present.BaseContract;

/**
 * Created by Carl on 2017/12/5.
 * Main操作接口
 */

public interface MainContract  {
    interface View extends BaseContract.View<Present>{
        void showTitle(String str);
    }
    interface Present extends BaseContract.Present{
        void changeData(String str);
    }
}
