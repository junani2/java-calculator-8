package calculator;

import static calculator.CustomDelimiter.FIRST_DELIMITER;
import static calculator.CustomDelimiter.LAST_DELIMITER;

public class CustomDelimiterParser {

    public static String findDelimiter(String str) {

        //커스텀 구분자만 잘라내기
        int lastIndex = str.lastIndexOf(LAST_DELIMITER);
        return str.substring(FIRST_DELIMITER.length(), lastIndex);
    }

    public static String cleanString(String str){

        //  //와 \n가 제거된 문자열
        String deleteDelimiter =  str.replace(FIRST_DELIMITER, "");
        deleteDelimiter = deleteDelimiter.replace(LAST_DELIMITER, "");
        return deleteDelimiter;
    }
}
