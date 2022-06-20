package app.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {
    private Dealer dealer;
    private List<Gambler> gamblerList;
    private Players players;

    @BeforeEach
    void setDeckAndDealer() {
        DeckOfCards deckOfCards = new DeckOfCards();
        dealer = new Dealer(new Cards(deckOfCards));
        gamblerList = Arrays.asList(new Gambler(new PlayerName("tester"), new Cards(deckOfCards)));
        players = new Players(gamblerList, dealer);
        players.receiveStartingCards();
    }

    @Test
    @DisplayName("딜러는 startingCards로 한장을 보여준다.")
    void dealerStartingCardsTest() {
        assertThat(dealer.startingCardStrList().size()).isEqualTo(1);
    }

    @Test
    @DisplayName("Gambler는 startingCards로 두장 모두를 보여준다.")
    void gamblerStartingCardsTest() {
        assertThat(gamblerList.get(0).startingCardStrList().size()).isEqualTo(2);
    }

    @Test
    @DisplayName("Player는 가지고 있는 카드의 총합 점수를 구할 수 있다.")
    void cardsSumTest() {
        assertThat(dealer.sumCards()).isEqualTo(20);
        assertThat(gamblerList.get(0).sumCards()).isEqualTo(20);
    }

    @Test
    @DisplayName("Player는 자신의 패를 확인하고 자신이 죽었는지 알 수 있다.")
    void amIBusted() {
        dealer.drawCard(20);
        gamblerList.get(0).drawCard(20);
        assertThat(dealer.isBusted()).isEqualTo(true);
        assertThat(gamblerList.get(0).isBusted()).isEqualTo(true);
    }

    @Test
    @DisplayName("Player는 추가로 draw할 것인지 판단할 수 있다.")
    void shouldDraw() {
        assertThat(dealer.canDraw()).isEqualTo(false);
        assertThat(gamblerList.get(0).canDraw()).isEqualTo(true);
    }

    @Test
    @DisplayName("Dealer는 추가로 draw할지 확인한 후 카드를 추가로 뽑거나 안뽑을 수 있다.")
    void rotateCardForDealer() {
        dealer.rotateCards();
        assertThat(dealer.getCardStrList().size()).isEqualTo(2);
    }
}
