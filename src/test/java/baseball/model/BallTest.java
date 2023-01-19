package baseball.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BallTest {
    private Ball ball;

    private static final int BALL_NUMBER = 1;

    @BeforeEach
    void setUp() {
        ball = new Ball(BALL_NUMBER);
    }

    @Test
    @DisplayName("BallStatus 스트라이크 업데이트 테스트")
    void update_ballStatus_strike_테스트() {
        ball.updateStatusToStrike();
        assertThat(ball.getBallStatus()).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    @DisplayName("BallStatus 볼 업데이트 테스트")
    void update_ballStatus_ball_테스트() {
        ball.updateStatusToBall();
        assertThat(ball.getBallStatus()).isEqualTo(BallStatus.BALL);
    }

    @Test
    @DisplayName("BallStatus 반환 테스트")
    void get_ballStatus_테스트() {
        assertThat(ball.getBallStatus()).isEqualTo(BallStatus.NOTHING);
    }

    @Test
    @DisplayName("BallNumber 반환 테스트")
    void get_ballNumber_테스트() {
        assertThat(ball.getNumber()).isEqualTo(BALL_NUMBER);
    }


}