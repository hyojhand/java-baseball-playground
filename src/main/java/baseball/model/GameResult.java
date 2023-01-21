package baseball.model;

public class GameResult {

    private GameStatus gameStatus;
    private String message;

    public GameResult(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public void updateGameResult(GameResult gameResult) {
        this.gameStatus = gameResult.getGameStatus();
        this.message = gameResult.getMessage();
    }

    public GameResult(GameStatus gameStatus, String message) {
        this.gameStatus = gameStatus;
        this.message = message;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public String getMessage() {
        return message;
    }
}
