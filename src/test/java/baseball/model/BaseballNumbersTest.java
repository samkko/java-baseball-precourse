package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BaseballNumbersTest {

    @DisplayName("BaseballNumbers 생성 테스트")
    @Test
    void create() {
        // given & when
        final int size = 3;
        BaseballNumbers baseballNumbers = BaseballNumbers.createBaseballNumbers(size);

        // then
        assertNotNull(baseballNumbers);
        assertEquals(size, baseballNumbers.getNumbers().size());
    }

    @DisplayName("BaseballNumbers 생성시 size가 1보다 작은 경우 IllegalArgument 테스트")
    @Test
    void createExceptionTest() {
        // when & then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> BaseballNumbers.createBaseballNumbers(-1));
    }
}
