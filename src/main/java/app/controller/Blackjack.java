package app.controller;

import app.model.*;
import app.view.Receiver;

import java.util.List;
import java.util.stream.Collectors;

public class Blackjack {
    private final Dealer dealer;

    public Blackjack(Dealer dealer) {
        this.dealer = dealer;
    }

    public void play() {
        Players players = createPlayers();
    }

    private Players createPlayers() {
        try {
            PlayerNames playerNames = createPlayerNames();
            List<Player> playerList = createPlayerList(playerNames);
            return new Players(playerList);
        } catch(IllegalArgumentException error) {
            System.err.println(error.getMessage());
            return createPlayers();
        }
    }

    private PlayerNames createPlayerNames() {
        List<PlayerName> playerNameList = Receiver.askPlayerNames().stream()
                .map(playerNameStr -> new PlayerName(playerNameStr))
                .collect(Collectors.toList());
        return new PlayerNames(playerNameList);
    }

    private List<Player> createPlayerList(PlayerNames playerNames) {
        return playerNames.getPlayerNames().stream()
                .map(playerName -> new Player(playerName))
                .collect(Collectors.toList());
    }

}
