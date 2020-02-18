package com.eduard.caloriecounter.presentation.presenter;

import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;

import com.eduard.caloriecounter.presentation.base.BasePresenter;
import com.eduard.caloriecounter.presentation.model.User;
import com.eduard.caloriecounter.presentation.utils.Calculator;

public class CollectionPresenter extends BasePresenter<CollectionContract.View> implements CollectionContract.Presenter {

    private User mUser;
    private Calculator mCalculator;

    private User mWeight;
    private User mHeight;
    private User mAge;

//    private boolean isInErrorState;

    public CollectionPresenter(Calculator calculator,User user) {

        mCalculator=calculator;
        mUser=user;

//        initPresenter();
    }

    private void initPresenter() {
        mCalculator = new Calculator();
        getView().initView();
    }

    @Override
    public void onClick() {
        String data = mCalculator.operation(mWeight,mHeight,mAge);
        getView().setViewData(data);
    }

//    @Override
//    public void appendValue(String value) {
//
//    }
//
//    @Override
//    public void performCalculation() {
//        String result = "";
//        result = mCalculator.operation(mWeight,mHeight,mAge);
//
//        if (result.equals("") || result.length() > User.MAX_LENGTH) {
//            switchToErrorState();
//        } else {
////            mUser.setValue(result);
//        }
//        updateDisplay();
//    }
//
//    private void switchToErrorState() {
//        mWeight.setWeight(User.ERROR_VALUE);
//        isInErrorState = true;
//    }
//
//    private void updateDisplay() {
////        getView().updateUserInfo(mWeight.getAge(),mHeight.getHeight(),mAge.getAge());
//        getView().updateUserInfo(mWeight.getWeight());
//        getView().updateUserInfo(mUser.toString());
//    }

}

//Формула Харриса-Бенедикта
//        для мужчин: BMR = 88.36 + (13.4 x вес, кг) + (4.8 х рост, см) – (5.7 х возраст, лет)
//        для женщин: BMR = 447.6 + (9.2 x вес, кг) + (3.1 х рост, cм) – (4.3 х возраст, лет)

//+суточная активность
//        Норма калорий = BMR x Уровень активности = 1765 х 1.55 = 2735 ккал