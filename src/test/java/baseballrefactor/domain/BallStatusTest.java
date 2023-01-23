package baseballrefactor.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BallStatusTest {

    @Test
    void is_strike_test() {
        BallStatus status = BallStatus.STRIKE;
        assertThat(status.isStrike()).isTrue();
    }

    @Test
    void is_ball_test() {
        BallStatus status = BallStatus.BALL;
        assertThat(status.isBall()).isTrue();
    }

}