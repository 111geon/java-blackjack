package app.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerNamesTest {
    @Test
    @DisplayName("중복된 이름이 존재하면 에러를 반환한다.")
    void duplicatedPlayerNames() {
        List<String> playerNameStrList = Arrays.asList("a", "b", "a");
        assertThatThrownBy(() -> new PlayerNames(playerNameStrList))
                .isInstanceOf(IllegalArgumentException.class);
    }

}