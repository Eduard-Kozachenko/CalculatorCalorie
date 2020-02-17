package com.eduard.caloriecounter.presentation.presenter;

import com.eduard.caloriecounter.presentation.base.BasePresenter;

public interface CollectionContract {

     interface View extends BasePresenter.View {

        void updateUserInfo(String info);

    }

    interface Presenter{

//        void onClick(android.view.View view);

        void appendValue(String value);

        void performCalculation();

    }
}
