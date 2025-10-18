package calculator.service;

import java.util.List;
import calculator.parser.NumberParser;

public class DefaultDelimiter {

    public List<Integer> parse(String strToCalculate) {

        // , 나 : 를 기준으로 숫자를 나눔
        String[] splitStr = strToCalculate.split(",|:");

        return NumberParser.parseToIntList(splitStr);
    }
}
