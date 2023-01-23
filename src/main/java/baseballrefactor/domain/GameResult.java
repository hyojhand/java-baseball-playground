package baseballrefactor.domain;

public class GameResult {
    private static final int GAME_END_COUNT = 3;
    private int ballCount = 0;
    private int strikeCount = 0;

    public int getBallCount() {
        return this.ballCount;
    }

    public int getStrikeCount() {
        return this.strikeCount;
    }

    public void setStrikeCount(int strikeCount) {
        this.strikeCount = strikeCount;
    }

    public void reportCount(BallStatus status) {
        if (status.isStrike()) {
            strikeCount++;
        }

        if (status.isBall()) {
            ballCount++;
        }
    }

    public boolean isGameEnd() {
        return strikeCount == GAME_END_COUNT;
    }


}
