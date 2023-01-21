package baseball.controller;

import baseball.model.BaseballGame;
import baseball.model.GameResult;
import baseball.model.GameStatus;
import baseball.model.GenerateNumber;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class GameController {
    private static final InputView INPUT_VIEW = new InputView();
    private static final OutputView OUTPUT_VIEW = new OutputView();
    private static final BaseballGame BASEBALL_GAME = new BaseballGame();

    public static void start() {
        List<Integer> randomNumbers = generateRandomNumber();

        GameResult gameResult = new GameResult(GameStatus.PLAY);
        while (gameResult.getGameStatus() == GameStatus.PLAY) {
            List<Integer> numbers = INPUT_VIEW.getNumberList();

            GameResult baseBallResult = BASEBALL_GAME.game(randomNumbers, numbers);
            gameResult.updateGameResult(baseBallResult);

            OUTPUT_VIEW.printResult(gameResult.getMessage());
        }

        System.out.println("3개의 숫자를 모두 맞히셨습니다!");
        replayGame(INPUT_VIEW.inputReplayValue());
    }

    private static void replayGame(String replayValue) {
        if (replayValue.equals("1")) {
            restart();
        }

        if (replayValue.equals("2")) {
            end();
        }
    }

    private static List<Integer> generateRandomNumber() {
        GenerateNumber generateRandom = new GenerateNumber();
        return generateRandom.getRandomNumbers();
    }

    private static void restart() {
        start();
    }

    private static void end() {
        System.out.println("게임 종료");
        System.exit(0);
    }

}
