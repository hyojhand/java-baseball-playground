package baseballrefactor.domain;

public class BaseBallGame {

    public GameResult play(Balls balls, Balls otherBalls) {
        GameResult gameResult = new GameResult();
        for (int i = 0; i < otherBalls.getBalls().size(); i++) {
            BallResult ballResult = balls.compareResult(otherBalls.getBalls().get(i));
            gameResult.reportCount(ballResult.getResult());
        }
        return gameResult;
    }

}
