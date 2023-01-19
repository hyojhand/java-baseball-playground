package baseball.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class GameResultTest {

    private GameResult gameResult;

    @BeforeEach
    void setUp() {
        gameResult = new GameResult(GameStatus.PLAY,"게임 시작");
    }

    @Test
    @DisplayName("GameResult 업데이트 테스트")
    void update_gameResult_테스트() {
        GameResult result = new GameResult(GameStatus.END, "게임 종료");
        gameResult.updateGameResult(result);

        assertAll(
                () -> assertThat(gameResult.getGameStatus()).isEqualTo(GameStatus.END),
                () -> assertThat(gameResult.getMessage()).isEqualTo("게임 종료")
        );
    }

    @Test
    @DisplayName("GameStatus 반환 테스트")
    void get_gameResult_테스트() {
        assertThat(gameResult.getGameStatus()).isEqualTo(GameStatus.PLAY);
    }

    @Test
    @DisplayName("Message 반환 테스트")
    void get_message_테스트() {
        assertThat(gameResult.getMessage()).isEqualTo("게임 시작");
    }
}