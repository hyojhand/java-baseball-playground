package baseballrefactor.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static baseballrefactor.domain.BallStatus.*;

public class Balls {
    public static final int MAX_BALL_SIZE = 3;
    private final List<Ball> balls;

    public Balls(List<Integer> numbers) {
        this.balls = changeBalls(getValidateNumbers(numbers));
    }

    private List<Integer> getValidateNumbers(List<Integer> numbers) {
        Set<Integer> elements = new HashSet<>(numbers);
        if (elements.size() != MAX_BALL_SIZE) {
            throw new IllegalArgumentException("중복된 숫자가 있습니다");
        }
        return numbers;
    }

    private List<Ball> changeBalls(List<Integer> numbers) {
        List<Ball> balls = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            balls.add(new Ball(numbers.get(i), i));
        }
        return balls;
    }

    public BallResult compareResult(Ball ball) {
        if (balls.contains(ball)) {
            return new BallResult(STRIKE);
        }

        if (isContainNumber(ball)) {
            return new BallResult(BALL);
        }

        return new BallResult(NOTHING);
    }

    private boolean isContainNumber(Ball otherBall) {
        for (Ball ball : balls) {
            if(ball.isSameNumber(otherBall)) {
                return true;
            }
        }

        return false;
    }

    public List<Ball> getBalls() {
        return balls;
    }

}
