package com.eduard.caloriecounter.presentation.presenter;

import com.eduard.caloriecounter.presentation.base.BasePresenter;

public interface CollectionContract {

     interface View extends BasePresenter.View {
         void setViewData(String data);
    }

    interface Presenter {
        void collectionInfoMale(double weight, double height, double age, int level);
        void collectionInfoFemale(double weight, double height, double age, int level);
    }

    interface Model {
        String operationMale(double weight, double height, double age, int level);
        String operationFemale(double weight, double height, double age, int level);
    }
}
