package baseballrefactor.domain;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GenerateNumber {

    private static final int MAX_LENGTH = 3;

    public List<Integer> getRandomNumbers() {
        IntStream intStream = new Random().ints(1, 9).limit(3);
        List<Integer> numbers = intStream.boxed().distinct().collect(Collectors.toList());
        int count = numbers.size();

        while (count < MAX_LENGTH) {
            intStream = new Random().ints(1, 9).limit(3);
            numbers = intStream.boxed().distinct().collect(Collectors.toList());
            count = numbers.size();
        }

        return numbers;
    }

}
