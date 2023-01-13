package stringcalculator;

import java.util.Arrays;
import java.util.function.BinaryOperator;

public enum Operator {
    PLUS("+", (a, b) -> a + b),
    MINUS("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> {
        if (b == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다");
        }
        return a / b;
    });

    private final String symbol;
    private final BinaryOperator<Integer> operate;

    Operator(String symbol, BinaryOperator<Integer> operate) {
        this.symbol = symbol;
        this.operate = operate;
    }

    public static Operator findSymbol(String symbol) {
        return Arrays.stream(values())
                .filter(value -> value.symbol.equals(symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 연산자 입니다"));
    }

    public int calculate(int a, int b) {
        return operate.apply(a, b);
    }

}
