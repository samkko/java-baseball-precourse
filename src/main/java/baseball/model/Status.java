package baseball.model;

import java.util.function.BiPredicate;

public enum Status {

    STRIKE((target, input) -> target.getNumber(input.getIndex()).equals(input)),
    BALL(BaseballNumbers::contains),
    NOTHING((target, input) -> !target.contains(input));

    private final BiPredicate<BaseballNumbers, BaseballNumber> predicate;

    Status(BiPredicate<BaseballNumbers, BaseballNumber> predicate) {
        this.predicate = predicate;
    }

    public static Status findStatus(BaseballNumbers target, BaseballNumber input) {

        if(STRIKE.predicate.test(target, input)) {
            return STRIKE;
        }

        if(BALL.predicate.test(target, input)) {
            return BALL;
        }

        return NOTHING;
    }
}
