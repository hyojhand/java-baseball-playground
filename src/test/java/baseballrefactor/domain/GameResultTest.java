package baseballrefactor.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultTest {

    @Test
    @DisplayName("Strike 시 스트라이크 카운트가 1 올라간다")
    void strike_count_up_test() {
        GameResult gameResult = new GameResult();
        gameResult.reportCount(BallStatus.STRIKE);
        assertThat(gameResult.getStrikeCount()).isEqualTo(1);
        assertThat(gameResult.getBallCount()).isEqualTo(0);
    }

    @Test
    @DisplayName("Ball 시 볼 카운트가 1 올라간다")
    void ball_count_up_test() {
        GameResult gameResult = new GameResult();
        gameResult.reportCount(BallStatus.BALL);
        assertThat(gameResult.getStrikeCount()).isEqualTo(0);
        assertThat(gameResult.getBallCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("게임 종료 테스트")
    void game_end_test() {
        GameResult gameResult = new GameResult();
        gameResult.reportCount(BallStatus.STRIKE);
        gameResult.reportCount(BallStatus.STRIKE);
        gameResult.reportCount(BallStatus.STRIKE);
        assertThat(gameResult.isGameEnd()).isTrue();
    }
}
