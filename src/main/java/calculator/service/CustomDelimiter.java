package calculator.service;

import calculator.parser.CustomDelimiterParser;
import calculator.parser.NumberParser;

import java.util.List;
import java.util.regex.Pattern;

public class CustomDelimiter {
    public static final String FIRST_DELIMITER = "//";
    public static final String LAST_DELIMITER = "\n";

    public List<Integer> parse(String strToCalculate) {

        //  \\n을 그대로 받으면 줄바꿈을 실행시키기 때문에  \n로  변환하는 로직
        strToCalculate = strToCalculate.replace("\\n", "\n");

        //커스텀 구분자에서 시작값 끝값 확인하기
        if (!strToCalculate.startsWith(FIRST_DELIMITER) || !strToCalculate.contains(LAST_DELIMITER)) {
            throw new IllegalArgumentException("invalid delimiter");
        }

        //구분자 추출
        String delimiter = CustomDelimiterParser.findCustomDelimiter(strToCalculate);

        // //와 \n가 제거된 기본 구분자 형식으로 만들기
        String cleanStr = CustomDelimiterParser.cleanCustomString(strToCalculate);

        //구분자를 기준으로 숫자 배열에 넣기(특수문자 처리)
        String[] splitStr = cleanStr.split(Pattern.quote(delimiter));

        return  NumberParser.parseToIntList(splitStr);
    }
}


