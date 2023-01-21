package baseball.model;

public class Ball {
    private final int number;
    private BallStatus ballStatus;

    public Ball(int number) {
        this.number = number;
        this.ballStatus = BallStatus.NOTHING;
    }

    public void updateStatusToStrike() {
        this.ballStatus = BallStatus.STRIKE;
    }

    public void updateStatusToBall() {
        this.ballStatus = BallStatus.BALL;
    }

    public int getNumber() {
        return number;
    }

    public BallStatus getBallStatus() {
        return ballStatus;
    }

}
