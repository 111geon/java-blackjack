package app.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CardsTest {
    private DeckOfCards deckOfCards;

    @BeforeEach
    void setDeckAndDealer() {
        deckOfCards = new DeckOfCards();
    }

    @Test
    @DisplayName("DeckOfCard에서 카드 한장을 뽑아 Cards에 추가할 수 있다.")
    void drawCard() {
        Cards cards = new Cards(deckOfCards);
        cards.drawCard();
        assertThat(cards.getCardStrList().size()).isEqualTo(1);
        assertThat(cards.getCardStrList().get(0)).isEqualTo("K다이아몬드");
    }

    @Test
    @DisplayName("Cards는 자신이 죽었는지 알 수 있다.")
    void checkIfBusted() {
        Cards cards = new Cards(deckOfCards);
        cards.drawCard();
        cards.drawCard();
        cards.drawCard();
        assertThat(cards.isBusted()).isEqualTo(true);
    }
}
