package com.onesuite.utilities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MathUtils {

    /**
     * Generates random number
     *
     * @param number accepts number from 1 to Long.Max
     * @return long
     */
    public static String generateRandomNumbers(int number) {
        String finalNumber = "";
        outerLoop:
        while (true) {
            StringBuilder tempNumber = new StringBuilder("1");
            int min = 1;
            for (int i = 0; i < number; i++) {
                tempNumber.append("0");
            }
            long max = Long.parseLong(String.valueOf(tempNumber));
            String generatedNumber = String.valueOf((int) Math.floor(Math.random() * (max - min + 1) + min));
            if (generatedNumber.length() == number) {
                finalNumber = generatedNumber;
                break outerLoop;
            }
        }
        return finalNumber;
    }

    /**
     * Generates current date
     *
     * @return current date
     */
    public static String getCurrentDate() {
        LocalDate dateObj = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        return dateObj.format(formatter);
    }
}