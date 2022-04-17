package baseball.controller;

import baseball.model.BaseballNumber;
import baseball.model.BaseballNumbers;
import baseball.model.Result;
import baseball.model.Status;

import java.util.LinkedList;
import java.util.List;

public class GameController {

    private final static int BASEBALL_NUMBER_SIZE = 3;
    private BaseballNumbers baseballNumbers;

    public GameController() {
        this.baseballNumbers = BaseballNumbers.createBaseballNumbers(BASEBALL_NUMBER_SIZE);
    }

    public Result play(BaseballNumbers baseballNumbers) {

        return new Result(checkNumbers(baseballNumbers));
    }

    public void init() {
        this.baseballNumbers = BaseballNumbers.createBaseballNumbers(BASEBALL_NUMBER_SIZE);
    }

    private List<Status> checkNumbers(BaseballNumbers input) {
        validateInputSize(input);
        List<Status> statuses = new LinkedList<>();
        for(BaseballNumber baseballNumber : input) {
            statuses.add(Status.findStatus(baseballNumbers, baseballNumber));
        }

        return statuses;
    }

    private void validateInputSize(BaseballNumbers input) {
        if(input.getSize() != BASEBALL_NUMBER_SIZE) {
            throw new IllegalArgumentException("Input size must be a " + BASEBALL_NUMBER_SIZE);
        }
    }
}
