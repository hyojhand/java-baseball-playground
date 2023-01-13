package stringcalculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OperatorTest {

    @Test
    @DisplayName("더하기 테스트")
    void plus_test() {
        Assertions.assertThat(Operator.PLUS.calculate(1,2)).isEqualTo(3);
    }

    @Test
    @DisplayName("빼기 테스트")
    void minus_test() {
        Assertions.assertThat(Operator.MINUS.calculate(2,1)).isEqualTo(1);
    }

    @Test
    @DisplayName("곱하기 테스트")
    void multiply_test() {
        Assertions.assertThat(Operator.MULTIPLY.calculate(3,4)).isEqualTo(12);
    }

    @Test
    @DisplayName("나누기 테스트")
    void divide_test() {
        Assertions.assertThat(Operator.DIVIDE.calculate(6,3)).isEqualTo(2);
    }

    @Test
    @DisplayName("0으로 나누기 테스트")
    void divide_zero_테스트() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Operator.DIVIDE.calculate(6, 0));
    }

    @Test
    @DisplayName("잘못된 연산자 예외 테스트")
    void wrong_operator_exception_테스트() {
        assertThatThrownBy(() -> {
            Operator.findSymbol("%");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 연산자 입니다");
    }

}