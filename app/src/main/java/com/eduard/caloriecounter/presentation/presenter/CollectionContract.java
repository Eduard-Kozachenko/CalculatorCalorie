package com.eduard.caloriecounter.presentation.presenter;

import com.eduard.caloriecounter.presentation.base.BasePresenter;

public interface CollectionContract {

     interface View extends BasePresenter.View {

         void initView();
         void setViewData(String data);

    }

    interface Presenter {

        void onClick(android.view.View view);

    }

    interface Model {
        String operation();
    }

}
