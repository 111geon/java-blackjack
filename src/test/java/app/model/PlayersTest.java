package app.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayersTest {
    private DeckOfCards deckOfCards;
    private Dealer dealer;

    @BeforeEach
    void setDeckAndDealer() {
        deckOfCards = new DeckOfCards();
        dealer = new Dealer(new Cards(deckOfCards));
    }

    @Test
    @DisplayName("중복된 이름이 존재하면 에러를 반환한다.")
    void duplicatedGamblerNames() {
        List<Gambler> gamblerList = Arrays.asList("a", "b", "a").stream()
                .map(playerNameStr -> new PlayerName(playerNameStr))
                .map(playerName -> new Gambler(playerName, new Cards(deckOfCards)))
                .collect(Collectors.toList());
        assertThatThrownBy(() -> new Players(gamblerList, dealer))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Gambler의 이름이 딜러라면 에러를 반환한다.")
    void avoidDealerName() {
        List<Gambler> gamblerList = Arrays.asList("딜러").stream()
                .map(playerNameStr -> new PlayerName(playerNameStr))
                .map(playerName -> new Gambler(playerName, new Cards(deckOfCards)))
                .collect(Collectors.toList());
        assertThatThrownBy(() -> new Players(gamblerList, dealer))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("2장씩 패 돌리기를 할 수 있다.")
    void playersGo() {
        List<Gambler> gamblerList = Arrays.asList("a", "b", "c").stream()
                .map(playerNameStr -> new PlayerName(playerNameStr))
                .map(playerName -> new Gambler(playerName, new Cards(deckOfCards)))
                .collect(Collectors.toList());
        Players players = new Players(gamblerList, dealer);
        deckOfCards.shuffleDeck();
        players.receiveStartingCards();
        assertThat(players.getDealer().getCardStrList().size()).isEqualTo(2);
        assertThat(players.getGamblerList().get(0).getCardStrList().size()).isEqualTo(2);
    }
}