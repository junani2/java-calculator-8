package calculator.parser;

import static calculator.service.CustomDelimiter.FIRST_DELIMITER;
import static calculator.service.CustomDelimiter.LAST_DELIMITER;

public class CustomDelimiterParser {

    public static String findCustomDelimiter(String str) {

        //커스텀 구분자만 잘라내기
        int lastIndex = str.lastIndexOf(LAST_DELIMITER);
        return str.substring(FIRST_DELIMITER.length(), lastIndex);
    }

    public static String cleanCustomString(String str){

        //  //와 \n가 제거된 문자열
        String deleteDelimiter =  str.replace(FIRST_DELIMITER, "");
        deleteDelimiter = deleteDelimiter.replace(LAST_DELIMITER, "");
        return deleteDelimiter;
    }
}
