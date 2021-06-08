package com.testframework.utils;

import java.util.List;

public class CommonUtils {

    //this method strips string from all non numeric characters except dot and parses it to double
    public static double parseStringToDouble(String str) {
        str = str.replaceAll("[^0-9.]", "");
        return Double.parseDouble(str);
    }

    //this method sums all doubles from given list of strings
    public static double sumOfListElements(List<String> stringList) {
        double sum = 0.0d;
        for (String str : stringList) {
            double result = parseStringToDouble(str);
            sum += result;
        }
        return sum;
    }
}
