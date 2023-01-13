package stringcalculator;

import java.util.List;
import java.util.regex.Pattern;

public class Calculator {

    private static final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]*$");

    public int calculate(String value) {
        List<String> splitList = List.of(value.split(" "));

        String firstValue = splitList.get(0);
        if(!checkNumber(firstValue)) {
            throw new IllegalArgumentException("잘못된 숫자 입니다");
        }

        int result = Integer.parseInt(firstValue);

        for (int i = 2; i < splitList.size(); i += 2) {
            String symbol = splitList.get(i - 1);
            Operator operator = Operator.findSymbol(symbol);

            String secondValue = splitList.get(i);
            if(!checkNumber(secondValue)) {
                throw new IllegalArgumentException("잘못된 숫자 입니다");
            }

            result = operator.calculate(result, Integer.parseInt(secondValue));
        }

        return result;
    }

    boolean checkNumber(String value) {
        return NUMBER_PATTERN.matcher(value).matches();
    }

}
