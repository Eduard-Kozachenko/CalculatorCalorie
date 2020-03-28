package com.eduard.caloriecounter.presentation.presenter;

import com.eduard.caloriecounter.presentation.utils.CalculatorUserModel;

public class CollectionPresenter implements CollectionContract.Presenter {

    private CollectionContract.Model model;
    private CollectionContract.View view;

    @Override
    public void collectionInfoMale(double weight, double height, double age, int level) {
        model = new CalculatorUserModel();
        String data = String.valueOf(model.operationMale(weight, height, age, level));
        view.setViewData(data);
//        new Handler().postDelayed(() -> getView().showInformationDialog("Your result =" + data + " kcal / day"), 3500);
    }

    @Override
    public void collectionInfoFemale(double weight, double height, double age, int level) {
        model = new CalculatorUserModel();
        String data = String.valueOf(model.operationFemale(weight, height, age, level));
        view.setViewData(data);
//        new Handler().postDelayed(() -> getView().showInformationDialog("Your result =" + data + " kcal / day"), 3500);
    }
}

