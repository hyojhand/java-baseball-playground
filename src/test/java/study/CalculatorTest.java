package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {
    private Calculator calculator;
    private String value;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();

        String input = "2 + 3 * 5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        value = calculator.input();

        String[] values = calculator.separate(value);
        calculator.changeArray(values);
    }

    @Test
    void separate_테스트() {
        String[] separateText = calculator.separate(value);
        assertThat(separateText).contains("2", "+", "3");
    }

    @Test
    @DisplayName("계산 테스트")
    void calculate_테스트() {
        assertThat(calculator.calculate()).isEqualTo(25);
    }

    @Test
    @DisplayName("잘못된 계산식 테스트")
    void values_exception_테스트() {
        assertThatThrownBy(() -> {
            String input = "2 + 3 *";
            calculator.separate(input);
        }).isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("잘못된 계산식 입니다");
    }

    @Test
    @DisplayName("잘못된 숫자 입력 테스트")
    void number_exception_테스트() {
        assertThatThrownBy(() -> {
            String input = "2 + *";
            String[] values = calculator.separate(input);
            calculator.changeArray(values);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자가 아닙니다");
    }

    @Test
    @DisplayName("잘못된 연산자 입력 테스트")
    void operator_exception_테스트() {
        assertThatThrownBy(() -> {
            String input = "2 2 3";
            String[] values = calculator.separate(input);
            calculator.changeArray(values);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("연산자가 아닙니다");
    }

    @Test
    @DisplayName("덧셈 테스트")
    void add_테스트() {
        assertThat(calculator.add(2, 3)).isEqualTo(5);
    }

    @Test
    @DisplayName("뺄셈 테스트")
    void subtract_테스트() {
        assertThat(calculator.subtract(5, 3)).isEqualTo(2);
    }

    @Test
    @DisplayName("곱셈 테스트")
    void multiply_테스트() {
        assertThat(calculator.multiply(2, 3)).isEqualTo(6);
    }

    @Test
    @DisplayName("나눗셈 테스트")
    void divide_테스트() {
        assertThat(calculator.divide(9, 3)).isEqualTo(3);
    }

    @Test
    @DisplayName("0으로 나눗셈 예외 테스트")
    void divide_zero_테스트() {
        assertThatThrownBy(() -> {
            calculator.divide(9, 0);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("0으로 나눌 수 없습니다");
    }

}
