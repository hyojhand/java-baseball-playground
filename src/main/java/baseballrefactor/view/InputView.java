package baseballrefactor.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public List<Integer> getNumberList() {
        String input = inputValue("숫자를 입력해 주세요 : ");
        return changeNumberList(input);
    }

    public String inputReplayValue() {
        return inputValue("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요 : ");
    }

    private String inputValue(String message) {
        System.out.print(message);
        return SCANNER.nextLine();
    }

    private List<Integer> changeNumberList(String input) {
        return Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
