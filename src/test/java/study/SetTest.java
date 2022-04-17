package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>(Arrays.asList(1,1,2,3));
    }

    @DisplayName("java.util.Set (HashSet 구현체) > size() 테스트")
    @Test
    void sizeTest() {

        // when & then
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("java.util.Set (HashSet 구현체) > contains() 테스트 with @ParameterizedTest + @ValueSource")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void containsTest(int number) {

        // when & then
        assertThat(numbers.contains(number)).isTrue();
    }

    @DisplayName("java.util.Set (HashSet 구현체) >  contains() 테스트 with @ParameterizedTest + @CsvSource")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void containsTest(int number, boolean expected){

        // when & then
        assertThat(numbers.contains(number)).isEqualTo(expected);
    }
}
