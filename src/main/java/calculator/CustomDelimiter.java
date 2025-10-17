package calculator;

import java.util.ArrayList;
import java.util.List;

import static calculator.CustomDelimiterParser.*;

public class CustomDelimiter {
    public static final String FIRST_DELIMITER = "//";
    public static final String LAST_DELIMITER = "\n";

    public List<Integer> parse(String strToCalculate) {

        //커스텀 구분자에서 시작값 끝값 확인하기
        if (!strToCalculate.startsWith(FIRST_DELIMITER) || !strToCalculate.contains(LAST_DELIMITER)) {
            throw new IllegalArgumentException("invalid Delimiter");
        }

        //구분자 추출
        String delimiter = findCustomDelimiter(strToCalculate);

        // //와 \n가 제거된 기본 구분자 형식으로 만들기
        String cleanStr = cleanCustomString(strToCalculate);

        //구분자를 기준으로 숫자 배열에 넣기
        String[] splitStr = cleanStr.split(delimiter);

        return  NumberParser.parseToIntList(splitStr);

    }
}


