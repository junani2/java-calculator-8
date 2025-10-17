package calculator;

import org.junit.jupiter.api.Test;

import static java.beans.Beans.isInstanceOf;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DefaultParserTest {

    private final DefaultDelimiter defaultDelimiter = new DefaultDelimiter();

    @Test
    void 음수_입력시_예외_발생(){

        String input = "1,-2:3";

        assertThatThrownBy(() -> defaultDelimiter.parse(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("negative number is not allowed");
    }

    @Test
    void 숫자가_아닌값_입력시_예외_발생(){

        String input = "1,kkkk:3";

        assertThatThrownBy(() -> defaultDelimiter.parse(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("invalid number is not allowed");
    }

}
