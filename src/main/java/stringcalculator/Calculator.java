package stringcalculator;

import java.util.regex.Pattern;

public class Calculator {

    private static final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]*$");

    public int calculate(String value) {
        String[] split = value.split(" ");

        int result = checkNumber(split[0]);

        for (int i = 2; i < split.length; i += 2) {
            String symbol = split[i - 1];
            Operator operator = Operator.findSymbol(symbol);

            int number = checkNumber(split[i]);
            result = operator.calculate(result, number);
        }

        return result;
    }

    private int checkNumber(String number) {
        if (!NUMBER_PATTERN.matcher(number).matches()) {
            throw new IllegalArgumentException("잘못된 숫자 입니다");
        }

        return Integer.parseInt(number);
    }

}
