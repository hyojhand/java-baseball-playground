package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {

    public GameResult game(List<Integer> randomNumbers, List<Integer> numbers) {
        List<Ball> balls = getBallList(numbers);

        for (int i = 0; i < balls.size(); i++) {
            Ball ball = balls.get(i);
            compareNumber(randomNumbers, ball, i);
        }

        int ballCount = 0;
        int strikeCount = 0;

        for (Ball ball : balls) {
            if (ball.getBallStatus() == BallStatus.STRIKE) {
                strikeCount++;
            }

            if (ball.getBallStatus() == BallStatus.BALL) {
                ballCount++;
            }
        }

        return getGameResult(ballCount, strikeCount);
    }

    // Ball List로 변환
    private List<Ball> getBallList(List<Integer> numbers) {
        List<Ball> balls = new ArrayList<>();

        for (Integer number : numbers) {
            balls.add(new Ball(number));
        }

        return balls;
    }

    // 랜덤숫자와 야구공 비교
    private void compareNumber(List<Integer> randomNumbers, Ball ball, int idx) {
        if (checkIsStrike(randomNumbers, ball, idx)) {
            ball.updateStatusToStrike();
            return;
        }

        if (checkIsBall(randomNumbers, ball)) {
            ball.updateStatusToBall();
        }
    }

    // 게임 결과 반환
    private GameResult getGameResult(int ballCount, int strikeCount) {
        // 일치하는게 없음
        if (ballCount == 0 && strikeCount == 0) {
            return new GameResult(GameStatus.PLAY, "nothing");
        }

        // 정답
        if (strikeCount == 3) {
            return new GameResult(GameStatus.END, "3스트라이크");
        }

        String message = "";
        if (ballCount != 0) {
            message += (ballCount + "볼 ");
        }

        if (strikeCount != 0) {
            message += (strikeCount + "스트라이크");
        }

        // 게임 결과
        return new GameResult(GameStatus.PLAY, message);
    }

    // 볼인지 체크
    private boolean checkIsBall(List<Integer> randomNumbers, Ball ball) {
        return randomNumbers.contains(ball.getNumber());
    }

    // 스트라이크인지 체크
    private boolean checkIsStrike(List<Integer> randomNumbers, Ball ball, int idx) {
        return randomNumbers.get(idx) == ball.getNumber();
    }
}
