package baseballrefactor.controller;

import baseballrefactor.domain.Balls;
import baseballrefactor.domain.BaseBallGame;
import baseballrefactor.domain.GameResult;
import baseballrefactor.domain.GenerateNumber;
import baseballrefactor.view.InputView;
import baseballrefactor.view.OutputView;

import java.util.List;

public class GameController {

    private static final InputView INPUT_VIEW = new InputView();
    private static final OutputView OUTPUT_VIEW = new OutputView();

    public static void start() {
        List<Integer> randomNumbers = generateRandomNumber();
        BaseBallGame baseBallGame = new BaseBallGame();
        GameResult gameResult = new GameResult();

        while (!gameResult.isGameEnd()) {
            List<Integer> numbers = INPUT_VIEW.getNumberList();
            gameResult = baseBallGame.play(new Balls(randomNumbers), new Balls(numbers));
            OUTPUT_VIEW.printResult(gameResult);
        }

        replayGame(INPUT_VIEW.inputReplayValue());
    }

    private static void replayGame(String replayValue) {
        if (replayValue.equals("1")) {
            start();
        }

        if (replayValue.equals("2")) {
            end();
        }
    }

    private static List<Integer> generateRandomNumber() {
        GenerateNumber generateRandom = new GenerateNumber();
        return generateRandom.getRandomNumbers();
    }

    private static void end() {
        System.out.println("게임 종료");
        System.exit(0);
    }

}
