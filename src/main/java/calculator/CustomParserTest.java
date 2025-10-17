package calculator;

import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CustomParserTest {

    private final CustomDelimiter customDelimiter = new CustomDelimiter();

    @Test
    void 첫번째_커스텀_구분자_오류() {

        String input = "/;\n1;-2;3";

        assertThatThrownBy(() -> customDelimiter.parse(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("invalid Delimiter");
    }

    @Test
    void 두번째_커스텀_구분자_오류() {

        String input = "/;\s1;-2;3";

        assertThatThrownBy(() -> customDelimiter.parse(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("invalid Delimiter");
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
}
