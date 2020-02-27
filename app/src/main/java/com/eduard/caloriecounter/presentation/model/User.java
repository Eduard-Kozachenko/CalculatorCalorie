package com.eduard.caloriecounter.presentation.model;

public class User {

//    public String userWeight, userHeight, userAge;
    public boolean userGender;
    public static final int MAX_DECIMAL_DIGITS = 1;

    public double userWeight, userHeight, userAge;

    public User(double userWeight, double userHeight,  double userAge) {
        this.userWeight = userWeight;
        this.userHeight = userHeight;
        this.userAge = userAge;
    }

    public double getWeight() {
        return userWeight;
    }

    public void setWeight(double weight) {
        userWeight = weight;
    }

    public double getHeight() {
        return userHeight;
    }

    public void setHeight(double height) {
        userHeight = height;
    }

    public double getAge() {
        return userAge;
    }

    public void setAge(double age) {
        userAge = age;
    }

    public boolean getGender() {
        return userGender;
    }

    public void setGender(boolean userGender) {
        this.userGender = userGender;
    }

}

