/*
 * Copyright 2016 Sören Reimler
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.eduard.caloriecounter.presentation.utils;
import com.eduard.caloriecounter.presentation.model.User;
import com.eduard.caloriecounter.presentation.presenter.CollectionContract;

public class CalculatorUserModel implements CollectionContract.Model{

    @Override
    public String operationMale(double weight, double height, double age, int level) {
        User user = new User(weight,height,age);
        double result =(88.36 + (13.4 * user.getWeight()) + (4.8 * user.getHeight())-(5.7 * user.getAge()));
        double resPlus = 0;
        switch (level){
            case 0:
                if(level == 0){
                    return null;
                }
                break;
            case 1:
                if(level == 1){
                    resPlus = 1.2 * result;
                }
            case 2:
                if(level == 2) {
                    resPlus = 1.375 * result;
                }
            case 3:
                if(level == 3){
                    resPlus = 1.55 * result;
                }
            case 4:
                if(level == 4){
                    resPlus = 1.725 * result;
                }
            case 5:
                if(level == 5){
                    resPlus = 1.9 * result;
                }
        }
        return String.valueOf(resPlus);
    }

    @Override
    public String operationFemale(double weight, double height, double age, int level) {
        User user = new User(weight,height,age);
        double result =(447.6 + (9.2 * user.getWeight()) + (3.1 * user.getHeight())-(4.3 * user.getAge()));
        double resPlus = 0;
        switch (level){
            case 0:
                if(level == 0){
                    return null;
                }
                break;
            case 1:
                if(level == 1){
                    resPlus = 1.2 * result;
                }
            case 2:
                if(level == 2) {
                    resPlus = 1.375 * result;
                }
            case 3:
                if(level == 3){
                    resPlus = 1.55 * result;
                }
            case 4:
                if(level == 4){
                    resPlus = 1.725 * result;
                }
            case 5:
                if(level == 5){
                    resPlus = 1.9 * result;
                }
        }
        return String.valueOf(resPlus);
    }
}
