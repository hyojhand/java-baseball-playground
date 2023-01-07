package stringcalculator.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;

class CalculatorTest {
  private Calculator calculator = new Calculator();

  @Test
  void 더하기() {
    assertThat(calculator.calculate("1+2")).isEqualTo(3);
  }

  @Test
  void 빼기() {
    assertThat(calculator.calculate("2-1")).isEqualTo(1);
  }

  @Test
  void 곱하기() {
    assertThat(calculator.calculate("2*1")).isEqualTo(2);
  }

  @Test
  void 나누기() {
    assertThat(calculator.calculate("9/3")).isEqualTo(3);
  }

  @Test
  void 나누기_0인_경우() {
    assertThatIllegalArgumentException()
        .isThrownBy(() -> calculator.calculate("9/0"));
  }

  @Test
  void 계산을_어려번_하는_경우() {
    assertThat(calculator.calculate("1+2/3")).isEqualTo(1);
  }
}
