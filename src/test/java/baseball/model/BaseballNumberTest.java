package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

public class BaseballNumberTest {

    @DisplayName("BaseballNumber 생성 테스트")
    @Test
    void create() {
        // given & when
        BaseballNumber baseballNumber = BaseballNumber.createBaseballNumber(1);

        // then
        assertNotNull(baseballNumber);
    }

    @DisplayName("BaseballNumber 생성 테스트 with provider")
    @Test
    void createWithProvider() {
        // given & when
        final int number = 5;
        BaseballNumber baseballNumber = BaseballNumber.createBaseballNumberWithProvider((start, end) -> number, 1);

        // then
        assertNotNull(baseballNumber);
        assertEquals(baseballNumber.getNumber(), number);
    }

    @DisplayName("BaseballNumber 생성 실패 테스트 - 범위 오류")
    @ParameterizedTest
    @ValueSource(ints = {10, -1, 20, -5, 0})
    void createExceptionTest(int invalidNumber) {
        // when & then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> BaseballNumber.createBaseballNumber(invalidNumber, 0));
    }
}
