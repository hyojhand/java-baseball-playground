package baseball.view;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView {

    private static final int NUMBER_LENGTH = 3;
    private static final Pattern NUMBER_PATTERN = Pattern.compile("^[1-9]{3}$");
    private static final Pattern REPLAY_NUMBER_PATTERN = Pattern.compile("^[1,2]$");
    private static final Scanner SCANNER = new Scanner(System.in);

    private String inputValue(String message) {
        System.out.print(message);
        return SCANNER.nextLine();
    }

    public String inputReplayValue() {
        String input = inputValue("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요 : ");
        checkReplayNumber(input);
        return input;
    }

    public List<Integer> getNumberList() {
        String input = inputValue("숫자를 입력해 주세요 : ");
        checkInputNumber(input);

        List<Integer> numbers = changeNumberList(input);
        duplicateInputNumber(numbers);

        return numbers;
    }

    // 입력받은 숫자를 Number List 변환
    private List<Integer> changeNumberList(String input) {
        return Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    // 잘못된 숫자 입력 체크 (숫자가 아닌 문자, 길이가 3이 아닌 문자)
    private void checkInputNumber(String value) {
        if (!NUMBER_PATTERN.matcher(value).matches()) {
            throw new IllegalArgumentException("잘못된 숫자입니다");
        }
    }

    // 중복된 숫자 입력 체크
    private void duplicateInputNumber(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != NUMBER_LENGTH) {
            throw new IllegalArgumentException("중복되는 숫자가 있습니다");
        }
    }

    // 재게임 숫자 체크
    private void checkReplayNumber(String value) {
        if (!REPLAY_NUMBER_PATTERN.matcher(value).matches()) {
            throw new IllegalArgumentException("1과 2중에 입력하세요");
        }
    }
}
