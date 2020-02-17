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

public class Calculator {

    public String operation(User etWeight, User etHeight,User etAge) {
        double result =  (88.36 + (13.4 * getWeight(etWeight)) + (4.8 * getHeight(etHeight))-(5.7 * getAge(etAge)));
        return formatResult(result);
    }

    private double getWeight(User operand) {
        return Double.valueOf(operand.getWeight());
    }
    private double getHeight(User operand) {
        return Double.valueOf(operand.getHeight());
    }
    private double getAge(User operand) {
        return Double.valueOf(operand.getAge());
    }

    private String formatResult(Double res) {
        // Limit digits
        double digits = Math.pow(10, User.MAX_DECIMAL_DIGITS);
        res = Math.round(res * digits) / digits;

        // Split resulting float
        String result = Double.toString(res);
        String decimals = result.substring(0, result.indexOf("."));
        String fractionals = result.substring(result.indexOf(".") + 1);

        // Remove trailing zeros
        while (fractionals.length() > 0 && fractionals.substring(fractionals.length() - 1).equals("0")) {
            fractionals = fractionals.substring(0, fractionals.length() - 1);
        }

        if (fractionals.length() > 0) {
            // Result has fractionals different than zero - return them!
            return decimals + "." + fractionals;
        } else {
            return decimals;
        }
    }
}
