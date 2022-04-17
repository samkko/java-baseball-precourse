package baseball.model;

import java.util.Iterator;
import java.util.List;

public class Result implements Iterable<Status> {

    private final List<Status> statuses;

    public Result(List<Status> statuses) {
        this.statuses = statuses;
    }

    public List<Status> getStatuses() {
        return statuses;
    }

    @Override
    public Iterator<Status> iterator() {
        return statuses.iterator();
    }
}
