package stringcalculator;

import stringcalculator.model.Calculator;
import stringcalculator.view.InputView;
import stringcalculator.view.OutputView;

public class Application {

  public static void main(String[] args) {
    final String inputValue = InputView.inputValue();
    final int result = new Calculator().calculate(inputValue);
    OutputView.printResult(result);
  }

}
