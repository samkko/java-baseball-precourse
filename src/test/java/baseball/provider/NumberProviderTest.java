package baseball.provider;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class NumberProviderTest {

    @DisplayName("NumberProvider (NextStepNumberProvider 구현체) > getRandomNumberInRange 테스트")
    @RepeatedTest(100)
    void getRandomNumberInRangeTest() {
        // given
        NumberProvider numberProvider = new NextStepNumberProvider();

        // when & then
        Assertions.assertTrue(() -> numberProvider.getRandomNumberInRange(1, 5) <= 5);
        Assertions.assertTrue(() -> numberProvider.getRandomNumberInRange(1, 5) >= 1);
    }
}
