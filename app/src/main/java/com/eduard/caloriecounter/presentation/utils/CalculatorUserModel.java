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
    public String operation(double weight, double height, double age) {
        User user = new User(weight,height,age);
        double result =(88.36 + (13.4 * user.getWeight()) + (4.8 * user.getHeight())-(5.7 * user.getAge()));
        return String.valueOf(result);
    }
}
