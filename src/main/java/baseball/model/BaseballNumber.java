package baseball.model;

import baseball.provider.NextStepNumberProvider;
import baseball.provider.NumberProvider;

import java.util.Objects;

public class BaseballNumber {

    private static final int START_RANGE = 1;
    private static final int END_RANGE = 9;
    private static final NumberProvider DEFAULT_PROVIDER = new NextStepNumberProvider();

    private final int number;
    private final int index;

    private BaseballNumber(int number, int index) {

        this.number = number;
        this.index = index;
    }

    public static BaseballNumber createBaseballNumberWithProvider(NumberProvider provider, int index) {
         return new BaseballNumber(provider.getRandomNumberInRange(START_RANGE, END_RANGE), index);
    }

    public static BaseballNumber creatBaseballNumber(int index) {
        return new BaseballNumber(DEFAULT_PROVIDER.getRandomNumberInRange(START_RANGE, END_RANGE), index);
    }

    public static BaseballNumber createBaseballNumber(int number, int index) {
        validateRange(number);
        return new BaseballNumber(number, index);
    }

    private static void validateRange(int number) {
        if(number < START_RANGE) {
            throw new IllegalArgumentException("Number must be greater than " + START_RANGE);
        }

        if(number > END_RANGE) {
            throw new IllegalArgumentException("Number must be less than " + END_RANGE);
        }
    }

    public int getNumber() {
        return number;
    }

    public int getIndex() {
        return index;
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
