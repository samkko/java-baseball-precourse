package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
}
