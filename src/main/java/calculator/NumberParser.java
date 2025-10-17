package calculator;

import java.util.ArrayList;
import java.util.List;

public class NumberParser {

    public static List<Integer> parseToIntList(String[] splitStr) {

        List<Integer> numberList = new ArrayList<>();

        for (String token : splitStr) {
            if (token.isEmpty()) {
                continue;
            }

            try {
                int number = Integer.parseInt(token);
                if (number < 0) {
                    throw new IllegalArgumentException("negative number is not allowed");
                }
                numberList.add(number);

            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("invalid number is not allowed");
            }
        }

        return numberList;
    }

}
