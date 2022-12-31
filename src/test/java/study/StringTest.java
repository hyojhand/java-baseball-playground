package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void _1과_2가_나눠지는지_테스트() {
        String[] str = "1,2".split(",");
        assertThat(str).contains("1","2");
    }
}
