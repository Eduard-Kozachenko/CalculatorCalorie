package com.eduard.caloriecounter.presentation.presenter;

import com.eduard.caloriecounter.presentation.base.BasePresenter;

public interface CollectionContract {

     interface View extends BasePresenter.View {
         void initView();
         void setViewData(String data);
    }

    interface Presenter {
         void onClick(android.view.View view);
        void collectionInfo(double weight, double height, double age);
    }

    interface Model {
        String operation(double weight, double height, double age);
    }
}
