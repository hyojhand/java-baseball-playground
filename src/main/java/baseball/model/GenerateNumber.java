package baseball.model;

import java.util.*;
import java.util.stream.Collectors;

public class GenerateNumber {

    private static final List<Integer> NUMBERS = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

    public List<Integer> getRandomNumbers() {
        Collections.shuffle(NUMBERS);

        return NUMBERS.stream()
                .limit(3)
                .collect(Collectors.toList());
    }

}
