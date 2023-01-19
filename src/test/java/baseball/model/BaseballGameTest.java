package baseball.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;


class BaseballGameTest {

    private BaseballGame baseballGame;
    private List<Integer> randomNumbers;

    @BeforeEach
    void setUp() {
        baseballGame = new BaseballGame();
        randomNumbers = List.of(1, 3, 5);
    }

    @Test
    @DisplayName("게임 종료 테스트")
    void game_result_테스트() {
        List<Integer> numbers = List.of(1, 3, 5);
        assertAll(
                () -> assertThat(baseballGame.game(randomNumbers, numbers).getGameStatus()).isEqualTo(GameStatus.END),
                () -> assertThat(baseballGame.game(randomNumbers, numbers).getMessage()).isEqualTo("3스트라이크"));
    }

    @Test
    @DisplayName("게임 결과 2볼 1스트라이크 테스트")
    void twoBall_oneStrike_테스트() {
        List<Integer> numbers = List.of(1, 5, 3);
        assertAll(
                () -> assertThat(baseballGame.game(randomNumbers, numbers).getGameStatus()).isEqualTo(GameStatus.PLAY),
                () -> assertThat(baseballGame.game(randomNumbers, numbers).getMessage()).isEqualTo("2볼 1스트라이크"));
    }

    @Test
    @DisplayName("게임 nothing 테스트")
    void nothing_테스트() {
        List<Integer> numbers = List.of(2, 4, 6);
        assertAll(
                () -> assertThat(baseballGame.game(randomNumbers, numbers).getGameStatus()).isEqualTo(GameStatus.PLAY),
                () -> assertThat(baseballGame.game(randomNumbers, numbers).getMessage()).isEqualTo("nothing"));
    }

}