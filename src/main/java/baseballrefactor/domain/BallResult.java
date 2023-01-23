package baseballrefactor.domain;

import java.util.Objects;

public class BallResult {
    private final BallStatus result;

    public BallResult(BallStatus result) {
        this.result = result;
    }

    public BallStatus getResult() {
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BallResult that = (BallResult) o;
        return getResult() == that.getResult();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getResult());
    }
}
