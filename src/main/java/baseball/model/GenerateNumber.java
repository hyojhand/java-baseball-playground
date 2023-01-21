package baseball.model;

import java.util.*;

public class GenerateNumber {

    private static final int MAX_LENGTH = 3;

    public List<Integer> getRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();

        while (randomNumbers.size() < MAX_LENGTH) {
            randomNumbers.add(getNewNumber(randomNumbers));
        }

        return randomNumbers;
    }

    // 중복되지 않는 숫자 3개 생성
    private int getNewNumber(List<Integer> randomNumbers) {
        int randomNumber = generate();
        while (randomNumbers.contains(randomNumber)) {
            randomNumber = generate();
        }

        return randomNumber;
    }

    // 랜덤 숫자 생성
    private int generate() {
        Random random = new Random();
        return random.nextInt(9) + 1;
    }

}
