package calculator;

import java.util.ArrayList;
import java.util.List;

import static calculator.CustomDelimiterParser.*;

public class CustomDelimiter {
    public static final String FIRST_DELIMITER = "//";
    public static final String LAST_DELIMITER = "\n";

    public List<Integer> parser(String strToCalculate) {

        //커스텀 구분자에서 시작값 끝값 확인하기
        if (!strToCalculate.startsWith(FIRST_DELIMITER) && !strToCalculate.contains(LAST_DELIMITER)) {
            throw new IllegalArgumentException("invalid String");
        }

        //구분자 추출
        String delimiter = findDelimiter(strToCalculate);

        // //와 \n가 제거된 기본 구분자 형식으로 만들기
        String cleanStr = cleanString(strToCalculate);

        //구분자를 기준으로 숫자 배열에 넣기
        String[] splitStr = cleanStr.split(delimiter);
        
        //숫자 리스트로 변환 및 검증
        List<Integer> numberList = new ArrayList<>();
        for (String token : splitStr) {

            if (token.isEmpty()) {
                continue;
            }

            try{
                int number = Integer.parseInt(token);

                if(number <0){
                    throw new IllegalArgumentException("negative number is not allowed");
                }

                numberList.add(number);

            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("not allowed number format");
            }
        }

        return numberList;
    }
}


