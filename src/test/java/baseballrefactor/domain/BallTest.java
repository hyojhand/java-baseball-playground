package baseballrefactor.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class BallTest {

    @Test
    void create_Ball_테스트() {
        assertThat(new Ball(1)).isEqualTo(new Ball(1));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    @DisplayName("1~9까지 번호를 가진다")
    void number_range_테스트(int number) {
        assertThat(new Ball(number)).isEqualTo(new Ball(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 10})
    @DisplayName("1~9이외의 번호는 예외륿 발생한다")
    void number_range_exception_테스트(int number) {
        assertThatThrownBy(() -> {
            assertThat(new Ball(number)).isEqualTo(new Ball(number));
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("올바른 숫자가 아닙니다");
    }

    @Test
    @DisplayName("공이 같은 숫자인지 확인하는 테스트")
    void ball_SameNumber_Test() {
        Ball ball = new Ball(1, 0);
        assertAll(
                () -> assertThat(ball.isSameNumber(new Ball(1, 1))).isTrue(),
                () -> assertThat(ball.isSameNumber(new Ball(2, 0))).isFalse()
        );
    }

}