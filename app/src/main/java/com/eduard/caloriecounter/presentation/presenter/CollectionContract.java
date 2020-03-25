package com.eduard.caloriecounter.presentation.presenter;


public interface CollectionContract {

     interface View  {
         void setViewData(String res);
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
