package app;

import app.controller.Blackjack;
import app.model.Cards;
import app.model.Dealer;
import app.model.DeckOfCards;

public class App {
    public static void main(String[] args) {
        DeckOfCards deckOfCards = new DeckOfCards();
        Dealer dealer = new Dealer(new Cards(deckOfCards));
        Blackjack blackjack = new Blackjack(dealer, deckOfCards);
        blackjack.play();
    }
}
