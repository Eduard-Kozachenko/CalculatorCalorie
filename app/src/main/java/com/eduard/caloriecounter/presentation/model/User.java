package com.eduard.caloriecounter.presentation.model;

public class User {

    public String str_Weight,str_Height,str_Age;
//    public static final String ERROR_VALUE = "ERROR";
    public static final int MAX_DECIMAL_DIGITS = 1;
//    public static final int MAX_LENGTH = 10;

    public String getWeight() {
        return str_Weight;
    }

    public void setWeight(String weight) {
        str_Weight = weight;
    }

    public String getHeight() {
        return str_Height;
    }

    public void setHeight(String height) {
        str_Height = height;
    }

    public String getAge() {
        return str_Age;
    }

    public void setAge(String age) {
        str_Age = age;
    }

}

