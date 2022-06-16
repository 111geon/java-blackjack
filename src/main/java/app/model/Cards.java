package app.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cards {
    private final List<Card> cardList;
    private final DeckOfCards deckOfCards;

    public Cards(DeckOfCards deckOfCards) {
        this.cardList = new ArrayList<>();
        this.deckOfCards = deckOfCards;
    }

    void drawCard() {
        cardList.add(deckOfCards.pop());
    }

    List<String> getCardStrList() {
        return cardList.stream().map(card -> card.getCardStr()).collect(Collectors.toList());
    }
}
