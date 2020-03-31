package com.eduard.caloriecounter.presentation.usecase;

import com.eduard.caloriecounter.presentation.model.User;

public class CalculationUseCase {

    public static String operationMale(double weight, double height, double age) {
        User user = new User(weight, height, age);
        double result = (88.36 + (13.4 * user.getWeight()) + (4.8 * user.getHeight()) - (5.7 * user.getAge()));
        return String.valueOf(result);
    }

    public static String operationFemale(double weight, double height, double age) {
        User user = new User(weight, height, age);
        double result = (447.6 + (9.2 * user.getWeight()) + (3.1 * user.getHeight()) - (4.3 * user.getAge()));
        return String.valueOf(result);
    }
}
