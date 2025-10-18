package calculator;

import calculator.service.CustomDelimiter;
import calculator.service.DefaultDelimiter;
import calculator.service.NumberListSum;
import calculator.view.InputView;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        //문자열 입력
        InputView inputView = new InputView();
        String str =inputView.InputString();

        List<Integer> numberList = new ArrayList<>();

        //커스텀 구분자인지 기본 구분자인지에 따라 달라지는 객체 반환
        if (str.startsWith("//")) {
            CustomDelimiter customDelimiter = new CustomDelimiter();
            numberList = customDelimiter.parse(str);
        } else {
            DefaultDelimiter defaultDelimiter = new DefaultDelimiter();
            numberList = defaultDelimiter.parse(str);
        }

        //숫자 리스트의 합
        int result = NumberListSum.calculateSum(numberList);

        System.out.println("결과 : " + result);

        Console.close();
    }
}
