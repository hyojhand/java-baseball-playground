package baseballrefactor.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class BaseballGameTest {

    private BaseBallGame baseBallGame;

    @BeforeEach
    void setUp() {
        baseBallGame = new BaseBallGame();
    }

    @Test
    void one_ball_test() {
        Balls balls = new Balls(List.of(1, 2, 3));
        Balls userBalls = new Balls(List.of(3, 4, 5));

        GameResult gameResult = baseBallGame.play(balls, userBalls);

        assertAll(
                () -> assertThat(gameResult.getBallCount()).isEqualTo(1),
                () -> assertThat(gameResult.getStrikeCount()).isEqualTo(0)
        );
    }

    @Test
    void one_strike_test() {
        Balls balls = new Balls(List.of(1, 2, 3));
        Balls userBalls = new Balls(List.of(1, 4, 5));

        GameResult gameResult = baseBallGame.play(balls, userBalls);

        assertAll(
                () -> assertThat(gameResult.getBallCount()).isEqualTo(0),
                () -> assertThat(gameResult.getStrikeCount()).isEqualTo(1)
        );
    }

    @Test
    void three_strike_test() {
        Balls balls = new Balls(List.of(1, 2, 3));
        Balls userBalls = new Balls(List.of(1, 2, 3));

        GameResult gameResult = baseBallGame.play(balls, userBalls);

        assertAll(
                () -> assertThat(gameResult.getBallCount()).isEqualTo(0),
                () -> assertThat(gameResult.getStrikeCount()).isEqualTo(3)
        );
    }

}
