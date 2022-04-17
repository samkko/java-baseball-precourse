package baseball.converter;

import baseball.model.Result;
import baseball.model.Status;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class BaseballMessageConverter {

    private final static String STRIKE_MESSAGE = "스트라이크";
    private final static String BALL_MESSAGE = "볼";
    private final static String NOTHING_MESSAGE = "낫싱";
    private final static String BLANK = " ";

    public static String resultToOutput(Result result) {
        StringBuilder message = new StringBuilder();
        Map<Status, Integer> countMap = new HashMap<>();

        for(Status status : result.getStatuses()) {
            countMap.put(status, countMap.getOrDefault(status, 0) + 1);
        }

        int ballCount = Optional.ofNullable(countMap.get(Status.BALL)).orElse(0);
        if(ballCount > 0) {
            message.append(ballCount).append(BALL_MESSAGE).append(BLANK);
        }

        int strikeCount = Optional.ofNullable(countMap.get(Status.STRIKE)).orElse(0);
        if(strikeCount > 0) {
            message.append(strikeCount).append(STRIKE_MESSAGE).append(BLANK);
        }

        if(isNothing(ballCount, strikeCount)) {
            message.append(NOTHING_MESSAGE);
        }

        return message.toString();
    }

    private static boolean isNothing(int ballCount, int strikeCount) {
        return ballCount == 0 && strikeCount == 0;
    }
}
