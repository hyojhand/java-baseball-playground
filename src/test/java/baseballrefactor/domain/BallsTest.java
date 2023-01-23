package baseballrefactor.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BallsTest {

    private Balls balls;

    @BeforeEach
    void setUp() {
        balls = new Balls(List.of(1, 2, 3));
    }

    @Test
    @DisplayName("숫자3개를 포함한 Balls 생성")
    void create_balls() {
        balls = new Balls(List.of(1, 2, 3));
    }

    @Test
    @DisplayName("중복된 Ball 예외 테스트")
    void duplicate_number() {
        assertThatThrownBy(() -> {
            balls = new Balls(List.of(1, 1, 3));
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 숫자가 있습니다");
    }

    @Test
    @DisplayName("strike 결과 테스트")
    void strike_결과_테스트() {
        Ball ball = new Ball(1, 0);
        assertThat(balls.compareResult(ball)).isEqualTo(new BallResult(BallStatus.STRIKE));
    }

    @Test
    @DisplayName("ball 결과 테스트")
    void ball_결과_테스트() {
        Ball ball = new Ball(2, 0);
        assertThat(balls.compareResult(ball)).isEqualTo(new BallResult(BallStatus.BALL));
    }

    @Test
    @DisplayName("notingh 결과 테스트")
    void nothing_결과_테스트() {
        Ball ball = new Ball(5, 0);
        assertThat(balls.compareResult(ball)).isEqualTo(new BallResult(BallStatus.NOTHING));
    }


}