package calculator;

import java.util.ArrayList;
import java.util.List;
import calculator.NumberParser;

public class DefaultDelimiter {

    public List<Integer> parse(String strToCalculate) {

        // , 나 : 를 기준으로 숫자를 나눔
        String[] splitStr = strToCalculate.split(",|:");

        return NumberParser.parseToIntList(splitStr);
    }
}
