package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @DisplayName("java.lang.String > split() 테스트")
    @Test
    void splitTest() {

        // given
        String string = "1,2";
        String string2 = "1";

        // when
        String[] result = string.split(",");
        String[] result2 = string2.split(",");

        // then
        assertThat(result).contains("1");
        assertThat(result).contains("2");
        assertThat(result).containsExactly("1", "2");
        assertThat(result2).containsExactly("1");
    }

    @DisplayName("java.lang.String > substring() 테스트")
    @Test
    void subStringTest() {

        // given
        String string = "(1,2)";

        // when
        String result = string.substring(1, 4);

        // then
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("java.lang.String > charAt() IndexOutOfBoundsException 테스트")
    @Test
    void charAtExceptionTest() {

        // given
        String string = "qwer1234asdf";
        int length = string.length();

        // when & then
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    string.charAt(length+1);
                });

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    string.charAt(-1);
                });

        assertThatThrownBy(() -> {
            string.charAt(length+1);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range");
    }
}
