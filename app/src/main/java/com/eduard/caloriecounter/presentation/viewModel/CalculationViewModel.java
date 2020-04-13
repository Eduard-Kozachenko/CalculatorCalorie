package com.eduard.caloriecounter.presentation.viewModel;

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

    public void collectionInfoMale(double weight, double height, double age, int level){
        result.setValue(CalculationUseCase.operationMale(weight, height, age, level));
    }

    public void collectionInfoFemale(double weight, double height, double age, int level){
        result.setValue(CalculationUseCase.operationFemale(weight, height, age, level));
    }
}
