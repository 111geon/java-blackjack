package app.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cards {
    private static final int BLACKJACK = 21;
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

    int bestSum() {
        int sum = cardList.stream().map(card -> card.getCardIntHigh()).reduce(0, Integer::sum);
        if (isHigherThanBlackJack(sum)) {
            return cardList.stream().map(card -> card.getCardIntLow()).reduce(0, Integer::sum);
        }
        return sum;
    }

    boolean isBusted() {
        return isHigherThanBlackJack(bestSum());
    }

    private boolean isHigherThanBlackJack(int num) {
        return num > BLACKJACK;
    }
}
