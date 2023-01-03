package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = Set.of(1, 2, 3);
    }

    @Test
    @DisplayName("불변 컬렉션 값 추가 테스트")
    void Immutable_Collection_테스트() {
        assertThatThrownBy(() -> {
            numbers.add(4);
        }).isInstanceOf(UnsupportedOperationException.class);

    }

    @Test
    @DisplayName("Set 크기 확인 테스트")
    void Set_size_테스트() {
        int setSize = numbers.size();
        assertThat(setSize).isEqualTo(3);
    }

    @Test
    @DisplayName("Set 값 존재 확인 테스트")
    void Set_contains_테스트() {
        assertAll(
                () -> assertThat(numbers.contains(1)).isTrue(),
                () -> assertThat(numbers.contains(2)).isTrue(),
                () -> assertThat(numbers.contains(3)).isTrue()
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("Set 값 존재 확인 Parameterized 테스트")
    void Set_contains_테스트_중복제거(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:True", "2:True", "3:True", "4:False", "5:False"}, delimiter = ':')
    @DisplayName("Set 값 존재 확인 결과 테스트")
    void Set_contains_결과_테스트(int number, boolean expected) {
        assertEquals(numbers.contains(number), expected);
    }
}
