package study;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Calculator {

    static int[] numberArray;
    static String[] operatorArray;

    public String input() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public String[] separate(String text) {
        String[] values = text.split(" ");

        if (values.length % 2 == 0) {
            throw new IllegalStateException("잘못된 계산식 입니다");
        }

        return values;
    }

    public void changeArray(String[] values) {
        numberArray = new int[values.length / 2 + 1];
        operatorArray = new String[values.length / 2];

        numberArray[0] = Integer.parseInt(values[0]);

        String numberPattern = "^[0-9]*$";
        String operatorPattern = "^[+|-|*|/]$";

        for (int i = 2; i < values.length; i += 2) {
            if (!Pattern.matches(numberPattern, values[i])) {
                throw new IllegalArgumentException("숫자가 아닙니다");
            }

            numberArray[i / 2] = Integer.parseInt(values[i]);
        }

        for (int i = 1; i < values.length; i += 2) {
            if (!Pattern.matches(operatorPattern, values[i])) {
                throw new IllegalArgumentException("연산자가 아닙니다");
            }

            operatorArray[i / 2] = values[i];
        }
    }

    public int calculate() {
        int[] numbers = numberArray;
        String[] operators = operatorArray;

        int result = calculateOperator(numbers[0], operators[0], numbers[1]);
        for (int i = 1; i < numbers.length - 1; i++) {
            result = calculateOperator(result, operators[i], numbers[i + 1]);
        }

        return result;
    }

    public int calculateOperator(int firstNumber, String operator, int secondNumber) {
        switch (operator) {
            case "+":
                return add(firstNumber, secondNumber);
            case "-":
                return subtract(firstNumber, secondNumber);
            case "*":
                return multiply(firstNumber, secondNumber);
            case "/":
                return divide(firstNumber, secondNumber);
            default:
                return 0;
        }
    }

    public int add(int x, int y) {
        return x + y;
    }

    public int subtract(int x, int y) {
        return x - y;
    }

    public int multiply(int x, int y) {
        return x * y;
    }

    public int divide(int x, int y) {
        if (y == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다");
        }

        return x / y;
    }

}
