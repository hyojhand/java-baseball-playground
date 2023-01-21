package baseball.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GenerateNumberTest {

    private GenerateNumber generateNumber;
    private static final int NUMBER_LENGTH = 3;

    @BeforeEach
    void setUp() {
        generateNumber = new GenerateNumber();
    }

    @Test
    @DisplayName("랜덤 숫자 길이 테스트")
    void check_randomNumber_length_테스트() {
        List<Integer> randomNumbers = generateNumber.getRandomNumbers();
        assertThat(randomNumbers.size()).isEqualTo(NUMBER_LENGTH);
    }

}