package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

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

    @DisplayName("BaseballNumbers 생성 With Input 테스트")
    @Test
    void createWithInput() {
        // given & when
        final String input = "321";
        BaseballNumbers baseballNumbers = BaseballNumbers.createBaseballNumbers(input);

        // then
        assertNotNull(baseballNumbers);
        assertTrue(baseballNumbers.getNumbers().contains(BaseballNumber.createBaseballNumber(3,0)));
    }

    @DisplayName("BaseballNumbers 생성 With Input 실패 테스트")
    @Test
    void createWithInputException() {
        // given
        final String input = "333";

        // when & then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> BaseballNumbers.createBaseballNumbers(input))
                .withMessageContaining("Duplicated");
    }

    @DisplayName("BaseballNumbers 생성시 size가 1보다 작은 경우 IllegalArgument 테스트")
    @Test
    void createExceptionTest() {
        // when & then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> BaseballNumbers.createBaseballNumbers(-1));
    }

    @DisplayName("contains() 메소드 테스트")
    @Test
    void containsTest() {
        // given
        BaseballNumbers baseballNumbers = BaseballNumbers.createBaseballNumbers("321");
        BaseballNumber containsNumber = BaseballNumber.createBaseballNumber(3, 0);
        BaseballNumber notContainsNumber = BaseballNumber.createBaseballNumber(7, 0);

        // when & then
        assertTrue(baseballNumbers.contains(containsNumber));
        assertFalse(baseballNumbers.contains(notContainsNumber));
    }
}
