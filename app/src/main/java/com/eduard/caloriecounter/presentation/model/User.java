package com.eduard.caloriecounter.presentation.model;

public class User {

    public String etWeight,etHeight,etAge;
    public static final String ERROR_VALUE = "ERROR";
    public static final int MAX_DECIMAL_DIGITS = 1;
    public static final int MAX_LENGTH = 10;

    public String getWeight() {
        return etWeight;
    }

    public void setWeight(String weight) {
        etWeight = weight;
    }

    public String getHeight() {
        return etHeight;
    }

    public void setHeight(String height) {
        etHeight = height;
    }

    public String getAge() {
        return etAge;
    }

    public void setAge(String age) {
        etAge = age;
    }

}

