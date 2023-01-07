package stringcalculator.model;


import java.util.ArrayList;
import java.util.List;

public class Calculator {

    public int calculate(String value) {
        final String[] split = value.split("");

        List<Integer> numbers = new ArrayList<>();
        List<Operator> operators = new ArrayList<>();

        for (int i = 0; i < split.length; i++) {
            if (i % 2 == 0) {
                numbers.add(Integer.parseInt(split[i]));
            }
            if (i % 2 == 1) {
                operators.add(Operator.findBySymbol(split[i]));
            }
        }

        int result = numbers.get(0);

        for (int i = 1; i < numbers.size(); i++) {
            final Operator operator = operators.get(i - 1);
            result = operator.calculate(result, numbers.get(i));
        }

        return result;
    }
}
