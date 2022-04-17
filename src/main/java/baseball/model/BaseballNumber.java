package baseball.model;

import baseball.provider.NextStepNumberProvider;
import baseball.provider.NumberProvider;

import java.util.Objects;

public class BaseballNumber {

    private static final int START_RANGE = 1;
    private static final int END_RANGE = 9;
    private static final NumberProvider DEFAULT_PROVIDER = new NextStepNumberProvider();

    private final int number;

    private BaseballNumber(int number) {
        this.number = number;
    }

    public static BaseballNumber createBaseballNumberWithProvider(NumberProvider provider) {
         return new BaseballNumber(provider.getRandomNumberInRange(START_RANGE, END_RANGE));
    }

    public static BaseballNumber creatBaseballNumber() {
        return new BaseballNumber(DEFAULT_PROVIDER.getRandomNumberInRange(START_RANGE, END_RANGE));
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseballNumber that = (BaseballNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
