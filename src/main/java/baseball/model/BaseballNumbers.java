package baseball.model;

import java.util.HashSet;
import java.util.Set;

public class BaseballNumbers {

    private final Set<BaseballNumber> numbers;

    private BaseballNumbers() {
        numbers = new HashSet<>();
    }

    public static BaseballNumbers createBaseballNumbers(int size) {
        validateSize(size);
        BaseballNumbers baseballNumbers = new BaseballNumbers();
        setNumbers(baseballNumbers, size);

        return baseballNumbers;
    }

    private static void validateSize(int size) {
        if(size < 1) {
            throw new IllegalArgumentException("Size must larger then 0.");
        }
    }

    private static void setNumbers(BaseballNumbers baseballNumbers, int size) {
        for (int i = 0; i < size; i++) {
            createUniqueNumber(baseballNumbers);
        }
    }

    private static void createUniqueNumber(BaseballNumbers baseballNumbers) {
        while(!baseballNumbers.numbers.add(BaseballNumber.creatBaseballNumber()));
    }

    public Set<BaseballNumber> getNumbers() {
        return numbers;
    }

}
