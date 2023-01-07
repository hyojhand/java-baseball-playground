package stringcalculator.model;

import java.util.Arrays;
import java.util.function.BinaryOperator;

public enum Operator {

  PLUS("+", (a, b) -> a + b),
  MINUS("-", (a, b) -> a - b),
  MULTIPLY("*", (a, b) -> a * b),
  SUBTRACT("/", (a, b) -> {
      if (b == 0) {
        throw new IllegalArgumentException();
      }
      return a / b;
    }
  );

  private String symbol;
  private BinaryOperator<Integer> operate;

  Operator(String symbol, BinaryOperator<Integer> operate) {
    this.symbol = symbol;
    this.operate = operate;
  }

  public static Operator findBySymbol(String symbol) {
    return Arrays.stream(values())
        .filter(it -> it.symbol.equals(symbol))
        .findFirst()
        .orElseThrow(IllegalArgumentException::new);
  }

  public int calculate(int a, int b) {
    return operate.apply(a, b);
  }
}
