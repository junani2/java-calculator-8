package calculator;

import java.util.List;

public class NumberListSum {

    public static int calculateSum(List<Integer> numberList) {

        //리스트가 비어있으면 0을 반환
        if(numberList==null || numberList.isEmpty()){
            return 0;
        }

        int sum = 0;
        for(int number : numberList){
            sum += number;
        }

        return sum;
    }
}
