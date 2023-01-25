package baseballrefactor.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GenerateNumberTest {

    private final int NUMBER_LENGTH = 3;

    @Test
    @DisplayName("랜덤숫자 길이 테스트")
    void check_randomNumber_length_테스트() {
        GenerateNumber generateNumber = new GenerateNumber();
        assertThat(generateNumber.getRandomNumbers().size()).isEqualTo(NUMBER_LENGTH);
    }
}
