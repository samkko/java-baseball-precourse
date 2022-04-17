package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatusTest {

    @DisplayName("Status findStatus() 테스트")
    @ParameterizedTest
    @MethodSource("provideTargetAndInputAndResult")
    void findStatusTest(BaseballNumbers target, BaseballNumber input, Status expectedResult) {

        // given & when
        Status result = Status.findStatus(target, input);

        // then
        assertEquals(result, expectedResult);
    }

    private static Stream<Arguments> provideTargetAndInputAndResult() {
        return Stream.of(
                Arguments.of(BaseballNumbers.createBaseballNumbers("321"), BaseballNumber.createBaseballNumber(3, 0), Status.STRIKE),
                Arguments.of(BaseballNumbers.createBaseballNumbers("321"), BaseballNumber.createBaseballNumber(2, 0), Status.BALL),
                Arguments.of(BaseballNumbers.createBaseballNumbers("321"), BaseballNumber.createBaseballNumber(4, 0), Status.NOTHING)
        );
    }
}
