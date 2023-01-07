package stringcalculator.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;

class OperatorTest {

  @Test
  void 더하기() {
    assertThat(Operator.PLUS.calculate(1, 2)).isEqualTo(3);
  }

  @Test
  void 빼기() {
    assertThat(Operator.MINUS.calculate(2, 1)).isEqualTo(1);
  }

  @Test
  void 곱하기() {
    assertThat(Operator.MULTIPLY.calculate(2, 1)).isEqualTo(2);
  }

  @Test
  void 나누기() {
    assertThat(Operator.SUBTRACT.calculate(9, 3)).isEqualTo(3);
  }

  @Test
  void 나누기_0인_경우() {
    assertThatIllegalArgumentException()
        .isThrownBy(() -> Operator.SUBTRACT.calculate(1, 0));
  }
}
