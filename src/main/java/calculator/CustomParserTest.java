package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class CustomParserTest {
    private final CustomDelimiter customDelimiter = new CustomDelimiter();

    @Test
    void 음수_입력시_예외_발생() {
        // given
        String input = "//;\n1;-2;3";

        // expect
        assertThatThrownBy(() -> customDelimiter.parser(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("negative number is not allowed");
    }

    @Test
    void 숫자가_아닌값_입력시_예외_발생() {
        // given
        String input = "//;\n1;fdfd;3";

        // expect
        assertThatThrownBy(() -> customDelimiter.parser(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("not allowed number format");
    }
}
