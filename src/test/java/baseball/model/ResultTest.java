package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ResultTest {

    @DisplayName("Result 생성 테스트")
    @Test
    void create() {
        // given & when
        Result result = new Result(Collections.emptyList());

        // then
        assertNotNull(result);
    }
}
