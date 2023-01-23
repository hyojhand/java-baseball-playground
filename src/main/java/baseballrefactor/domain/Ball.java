package baseballrefactor.domain;

import java.util.Objects;
import java.util.regex.Pattern;

public class Ball {
    private static final Pattern NUMBER_PATTERN = Pattern.compile("^[1-9]$");
    private final int number;
    private int order;

    public Ball(int number) {
        if (!NUMBER_PATTERN.matcher(String.valueOf(number)).matches()) {
            throw new IllegalArgumentException("올바른 숫자가 아닙니다");
        }

        this.number = number;
    }

    public Ball(int number, int order) {
        this.number = number;
        this.order = order;
    }

    public int getOrder() {
        return order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return number == ball.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
