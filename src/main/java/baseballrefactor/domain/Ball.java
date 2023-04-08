package baseballrefactor.domain;

import java.util.Objects;

public class Ball {
    private final int number;
    private int order;

    public Ball(int number) {
        this.number = getValidateNumber(number);
    }

    public Ball(int number, int order) {
        this.number = getValidateNumber(number);
        this.order = order;
    }

    private int getValidateNumber(int number) {
        if (number < 1 || number > 9) {
            throw new IllegalArgumentException("올바른 숫자가 아닙니다");
        }
        return number;
    }

    public boolean isSameNumber(Ball otherBall) {
        return this.number == otherBall.number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return number == ball.number && order == ball.order;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, order);
    }
}
