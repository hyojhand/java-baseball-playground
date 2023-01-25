package baseballrefactor.view;

import baseballrefactor.domain.GameResult;

public class OutputView {
    private static final int GAME_END_COUNT = 3;

    public void printResult(GameResult result) {
        int strikeCount = result.getStrikeCount();
        int ballCount = result.getBallCount();

        if (strikeCount == 0 && ballCount == 0) {
            System.out.println("NOTHING");
            return;
        }

        StringBuilder message = new StringBuilder();
        if (result.getStrikeCount() > 0) {
            message.append(strikeCount).append("스트라이크 ");
        }

        if (result.getBallCount() > 0) {
            message.append(ballCount).append("볼 ");
        }

        System.out.println(message);

        if(result.getStrikeCount() == GAME_END_COUNT) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다!");
        }
    }

}
