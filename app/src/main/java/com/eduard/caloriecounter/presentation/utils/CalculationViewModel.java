package com.eduard.caloriecounter.presentation.utils;

import com.eduard.caloriecounter.presentation.usecase.CalculationUseCase;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CalculationViewModel extends ViewModel {
    private MutableLiveData<String> result;

    public CalculationViewModel() {
        result = new MutableLiveData<>();
    }

    public MutableLiveData<String> getResult() {
        return result;
    }

    public void collectionInfoMale(double weight, double height, double age){
        result.setValue(CalculationUseCase.operationMale(weight, height, age));
    }

    public void collectionInfoFemale(double weight, double height, double age){
        result.setValue(CalculationUseCase.operationFemale(weight, height, age));
    }
}
