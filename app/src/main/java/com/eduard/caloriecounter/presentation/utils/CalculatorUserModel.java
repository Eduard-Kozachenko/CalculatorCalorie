//package com.eduard.caloriecounter.presentation.utils;
//
//import com.eduard.caloriecounter.presentation.model.User;
//
//
//public class CalculatorUserModel {
//
//    public String operationMale(double weight, double height, double age, int level) {
//        User user = new User(weight,height,age);
//        double result =(88.36 + (13.4 * user.getWeight()) + (4.8 * user.getHeight())-(5.7 * user.getAge()));    //Формула Харриса-Бенедикта.
//        double resPlus = 0;
//        switch (level){
//            case 0:
//                if(level == 0){
//                    return null;
//                }
//                break;
//            case 1:
//                if(level == 1){
//                    resPlus = 1.2 * result;
//                }
//            case 2:
//                if(level == 2) {
//                    resPlus = 1.375 * result;
//                }
//            case 3:
//                if(level == 3){
//                    resPlus = 1.55 * result;
//                }
//            case 4:
//                if(level == 4){
//                    resPlus = 1.725 * result;
//                }
//            case 5:
//                if(level == 5){
//                    resPlus = 1.9 * result;
//                }
//        }
//        return String.valueOf(resPlus);
//    }
//
//    public String operationFemale(double weight, double height, double age, int level) {
//        User user = new User(weight,height,age);
//        double result =(447.6 + (9.2 * user.getWeight()) + (3.1 * user.getHeight())-(4.3 * user.getAge()));      //Формула Харриса-Бенедикта.
//        double resPlus = 0;
//        switch (level){
//            case 0:
//                if(level == 0){
//                    return null;
//                }
//                break;
//            case 1:
//                if(level == 1){
//                    resPlus = 1.2 * result;
//                }
//            case 2:
//                if(level == 2) {
//                    resPlus = 1.375 * result;
//                }
//            case 3:
//                if(level == 3){
//                    resPlus = 1.55 * result;
//                }
//            case 4:
//                if(level == 4){
//                    resPlus = 1.725 * result;
//                }
//            case 5:
//                if(level == 5){
//                    resPlus = 1.9 * result;
//                }
//        }
//        return String.valueOf(resPlus);
//    }
//}
