package baseball.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class BaseballNumbers implements Iterable<BaseballNumber> {

    private final Set<BaseballNumber> numbers;

    private BaseballNumbers() {
        numbers = new LinkedHashSet<>();
    }

    public static BaseballNumbers createBaseballNumbers(int size) {
        validateSize(size);
        BaseballNumbers baseballNumbers = new BaseballNumbers();
        setNumbers(baseballNumbers, size);

        return baseballNumbers;
    }

    public static BaseballNumbers createBaseballNumbers(String input) {
        validateInput(input);
        BaseballNumbers baseballNumbers = new BaseballNumbers();
        setNumbers(baseballNumbers, input);

        return baseballNumbers;
    }

    private static void validateSize(int size) {
        if(size < 1) {
            throw new IllegalArgumentException("Size must greater than 0");
        }
    }

    private static void setNumbers(BaseballNumbers baseballNumbers, int size) {
        for (int index = 0; index < size; index++) {
            createUniqueNumber(baseballNumbers, index);
        }
    }

    private static void createUniqueNumber(BaseballNumbers baseballNumbers, int index) {
        while(!baseballNumbers.numbers.add(BaseballNumber.creatBaseballNumber(index)));
    }

    private static void validateInput(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException("Input value must be a number");
        }
    }

    private static void setNumbers(BaseballNumbers baseballNumbers, String input) {
        String[] splitedInput = input.split("");
        for(int index = 0; index < splitedInput.length ; index++) {
            BaseballNumber baseballNumber = BaseballNumber.createBaseballNumber(Integer.parseInt(splitedInput[index]), index);
            checkUnique(baseballNumbers, baseballNumber);
            baseballNumbers.numbers.add(baseballNumber);
        }
    }

    private static void checkUnique(BaseballNumbers baseballNumbers, BaseballNumber baseballNumber) {
        if(baseballNumbers.numbers.contains(baseballNumber)) {
            throw new IllegalArgumentException("Baseball Number Duplicated!");
        }
    }

    public Set<BaseballNumber> getNumbers() {
        return numbers;
    }

    public BaseballNumber getNumber(int index) {
        return new ArrayList<>(numbers).get(index);
    }

    public boolean contains(BaseballNumber baseballNumber) {
       return numbers.contains(baseballNumber);
    }

    public int getSize() {
        return numbers.size();
    }

    @Override
    public Iterator<BaseballNumber> iterator() {
        return numbers.iterator();
    }
}
