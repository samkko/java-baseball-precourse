package baseball.provider;

import camp.nextstep.edu.missionutils.Randoms;

public class NextStepNumberProvider implements NumberProvider {

    @Override
    public int getRandomNumberInRange(int start, int end) {
        return Randoms.pickNumberInRange(start, end);
    }
}
