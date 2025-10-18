package calculator.parser;

import java.util.ArrayList;
import java.util.List;

public class NumberParser {

    //문자열을 숫자로 변환하고 리스트에 담기
    public static List<Integer> parseToIntList(String[] splitStr) {

        List<Integer> numberList = new ArrayList<>();

        // 문자열이 비어있는 경우 처리
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
