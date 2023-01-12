package stringcalculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator = new Calculator();

    @Test
    @DisplayName("문자열 계산기 테스트")
    void calculate_테스트() {
        assertThat(calculator.calculate("2 + 3 * 4 / 2")).isEqualTo(10);
    }

    @Test
    @DisplayName("잘못된 문자열 예외 테스트")
    void wrong_string_exception_테스트() {
        assertThatThrownBy(() -> {
            calculator.calculate("2 $ 3 + 4");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 연산자 입니다");
    }

    @Test
    @DisplayName("숫자 체크 테스트")
    void wrong_number_check_테스트() {
        Assertions.assertAll(
                () -> assertThat(calculator.checkNumber("2")).isTrue(),
                () -> assertThat(calculator.checkNumber("+")).isFalse()
        );
    }

    @Test
    @DisplayName("잘못된 숫자 계산 예외 테스트")
    void wrong_number_exception_테스트() {
        assertThatThrownBy(() -> {
            calculator.calculate("2 + + 3");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 숫자 입니다");
    }

}