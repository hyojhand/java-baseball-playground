package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator = new Calculator();

    @Test
    @DisplayName("덧셈 테스트")
    void plus_테스트() {
        assertThat(calculator.calculate("1 + 2")).isEqualTo(3);
    }

    @Test
    @DisplayName("뺄셈 테스트")
    void minus_테스트() {
        assertThat(calculator.calculate("2 - 1")).isEqualTo(1);
    }

    @Test
    @DisplayName("곱셈 테스트")
    void multiply_테스트() {
        assertThat(calculator.calculate("2 * 1")).isEqualTo(2);
    }

    @Test
    @DisplayName("나눗셈 테스트")
    void divide_테스트() {
        assertThat(calculator.calculate("6 / 3")).isEqualTo(2);
    }

    @Test
    @DisplayName("0으로 나눗셈 테스트")
    void divide_zero_테스트() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> calculator.calculate("6 / 0"));
    }

    @Test
    @DisplayName("문자열 계산기 테스트")
    void calculate_테스트() {
        assertThat(calculator.calculate("2 + 3 * 4 / 2")).isEqualTo(10);
    }

    @Test
    @DisplayName("잘못된 연산자 예외 테스트")
    void wrong_operator_exception_테스트() {
        assertThatThrownBy(() -> {
            calculator.calculate("2 $ 3 + 4");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 연산자 입니다");
    }

    @Test
    @DisplayName("잘못된 숫자 예외 테스트")
    void wrong_number_exception_테스트() {
        assertThatThrownBy(() -> {
            calculator.calculate("2 + + 3");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 숫자 입니다");
    }

}