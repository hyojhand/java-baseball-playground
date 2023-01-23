package baseballrefactor.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

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

        Assertions.assertThat(gameResult.getBallCount()).isEqualTo(1);
        Assertions.assertThat(gameResult.getStrikeCount()).isEqualTo(0);
    }

    @Test
    void one_strike_test() {
        Balls balls = new Balls(List.of(1, 2, 3));
        Balls userBalls = new Balls(List.of(1, 4, 5));

        GameResult gameResult = baseBallGame.play(balls, userBalls);

        Assertions.assertThat(gameResult.getBallCount()).isEqualTo(0);
        Assertions.assertThat(gameResult.getStrikeCount()).isEqualTo(1);
    }

    @Test
    void three_strike_test() {
        Balls balls = new Balls(List.of(1, 2, 3));
        Balls userBalls = new Balls(List.of(1, 2, 3));

        GameResult gameResult = baseBallGame.play(balls, userBalls);

        Assertions.assertThat(gameResult.getBallCount()).isEqualTo(0);
        Assertions.assertThat(gameResult.getStrikeCount()).isEqualTo(3);
    }

}
