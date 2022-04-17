package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

public class ResultTest {

    @DisplayName("Result 생성 테스트")
    @Test
    void create() {
        // given & when
        Result result = new Result(Collections.emptyList());

        // then
        assertNotNull(result);
    }

    @DisplayName("isDone() 테스트")
    @Test
    void isDoneTest() {
        // given
        Result doneStatusResult = new Result(Arrays.asList(Status.STRIKE, Status.STRIKE, Status.STRIKE));
        Result notEndStatusResult = new Result(Arrays.asList(Status.BALL, Status.NOTHING, Status.STRIKE));

        // when & then
        assertTrue(doneStatusResult.isDone());
        assertFalse(notEndStatusResult.isDone());
    }
}
