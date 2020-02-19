package com.eduard.caloriecounter.presentation.model;

public class User {

    public String UserWeight,UserHeight,UserAge;
    public static final int MAX_DECIMAL_DIGITS = 1;

    public String getWeight() {
        return UserWeight;
    }

    public void setWeight(String weight) {
        UserWeight = weight;
    }

    public String getHeight() {
        return UserHeight;
    }

    public void setHeight(String height) {
        UserHeight = height;
    }

    public String getAge() {
        return UserAge;
    }

    public void setAge(String age) {
        UserAge = age;
    }

}

