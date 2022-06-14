package app.controller;

import app.model.*;
import app.view.Receiver;

import java.util.List;

public class Blackjack {
    private final Dealer dealer;
    private Players players;

    public Blackjack(Dealer dealer) {
        this.dealer = dealer;
    }

    public void play() {
        createPlayers();
    }

    private void createPlayers() {
        try {
            List<String> playerNameStrList = Receiver.askPlayerNames();
            PlayerNames playerNames = new PlayerNames(playerNameStrList);
            this.players = new Players(playerNames);
        } catch(IllegalArgumentException error) {
            System.err.println(error.getMessage());
            createPlayers();
        }
    }
}
