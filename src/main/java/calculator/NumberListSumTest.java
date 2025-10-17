package calculator;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class NumberListSumTest {

    @Test
    void 숫자리스트_합계_테스트(){

        List<Integer> numbers = List.of(1,2,3,4);
        int result = NumberListSum.calculateSum(numbers);
        assertThat(result).isEqualTo(10);
    }


}
