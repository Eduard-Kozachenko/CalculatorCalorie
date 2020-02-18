package com.eduard.caloriecounter.presentation.presenter;

import com.eduard.caloriecounter.presentation.base.BasePresenter;

public interface CollectionContract {

     interface View extends BasePresenter.View {

         void initView();
         void setViewData(String data);
//        void updateUserInfo(String info);

    }

    interface Presenter{

        void onClick();

//        void appendValue(String value);
//
//        void performCalculation();

    }
}
