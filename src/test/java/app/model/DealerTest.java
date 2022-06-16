package app.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DealerTest {
    private DeckOfCards deckOfCards;

    @BeforeEach
    void setDeckAndDealer() {
        deckOfCards = new DeckOfCards();
    }

    @Test
    @DisplayName("딜러는 자신이 가지고 있는 카드를 한장만 보여줄 수 있다")
    void peekCardTest() {
        Dealer dealer = new Dealer(new Cards(deckOfCards));
        dealer.drawCard(1);
        assertThat(dealer.peekCardStr()).isEqualTo("K다이아몬드");
    }
}
