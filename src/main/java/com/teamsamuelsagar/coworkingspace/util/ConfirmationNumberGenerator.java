package com.teamsamuelsagar.coworkingspace.util;

import java.util.Random;

public class ConfirmationNumberGenerator {
    public static String generateConfirmationNumber(int length) {

        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder confirmationNumber = new StringBuilder();
        Random random = new Random();
        int index;

        while(confirmationNumber.length() < length) {
            index = random.nextInt(characters.length());
            confirmationNumber.append(characters.charAt(index));
        }

        return confirmationNumber.toString();
    }
}
