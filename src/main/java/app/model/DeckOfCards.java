package app.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class DeckOfCards {
    private final List<Card> cardList;

    public DeckOfCards() {
        this.cardList = Arrays.stream(CardNumber.values())
                .flatMap(cardNumber -> Arrays.stream(CardShape.values())
                        .map(cardShape -> new Card(cardNumber, cardShape)))
                .collect(Collectors.toList());
    }

    public void shuffleDeck() {
        Collections.shuffle(cardList);
    }

    Card pop() {
        return cardList.remove(cardList.size()-1);
    }

}
