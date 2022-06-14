package app;

import app.controller.Blackjack;
import app.model.Dealer;

public class App {
    public static void main(String[] args) {
        Dealer dealer = new Dealer();
        Blackjack blackjack = new Blackjack(dealer);
        blackjack.play();
    }
}
