package com.mvp.carl.common.present;


/**
 * Created by Carl on 2017/12/5.
 * 
 */

public interface BaseContract {
    interface View<T extends Present> {
        void refreshData(Object data);

        void showErrorMessage(String message);

        void setLoadIndicator(boolean active);

        void setPresenter(T presenter);
    }

    interface Present {
        void subscibe();

        void unSubscibe();

        void refreshData();
    }
}
