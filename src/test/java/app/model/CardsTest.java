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
        Cards card = new Cards(deckOfCards);
        card.drawCard();
        assertThat(card.getCardStrList().size()).isEqualTo(1);
        assertThat(card.getCardStrList().get(0)).isEqualTo("K다이아몬드");
    }
}
