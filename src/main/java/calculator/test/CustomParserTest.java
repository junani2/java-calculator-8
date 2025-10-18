package calculator.test;

import calculator.service.CustomDelimiter;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CustomParserTest {

    private final CustomDelimiter customDelimiter = new CustomDelimiter();

    @Test
    void 첫번째_커스텀_구분자_오류() {

        String input = "/;\n1;-2;3";

        assertThatThrownBy(() -> customDelimiter.parse(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("invalid delimiter");
    }

    @Test
    void 두번째_커스텀_구분자_오류() {

        String input = "/;\s1;-2;3";

        assertThatThrownBy(() -> customDelimiter.parse(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("invalid delimiter");
    }

    @Test
    void 음수_입력시_예외_발생() {

        String input = "//;\n1;-2;3";

        assertThatThrownBy(() -> customDelimiter.parse(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("negative number is not allowed");
    }

    @Test
    void 숫자가_아닌값_입력시_예외_발생() {

        String input = "//;\n1;fdfd;3";

        assertThatThrownBy(() -> customDelimiter.parse(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("invalid number is not allowed");
    }

    @Test
    void 정상적인_커스텀_구분자_입력시(){

        String input = "//;\n1;2;3";

       List<Integer> result = customDelimiter.parse(input);
        assertThat(result).isEqualTo(List.of(1, 2, 3));
    }
}
