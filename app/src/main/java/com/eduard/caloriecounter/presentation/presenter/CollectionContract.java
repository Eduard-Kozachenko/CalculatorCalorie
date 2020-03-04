package com.eduard.caloriecounter.presentation.presenter;

import com.eduard.caloriecounter.presentation.base.BasePresenter;

public interface CollectionContract {

     interface View extends BasePresenter.View {
         void setViewData(String data);
    }

    interface Presenter {
        void collectionInfoMale(double weight, double height, double age);
        void collectionInfoFemale(double weight, double height, double age);
    }

    interface Model {
        String operationMale(double weight, double height, double age);
        String operationFemale(double weight, double height, double age);
    }
}
