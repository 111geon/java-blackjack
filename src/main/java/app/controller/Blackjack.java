package app.controller;

import app.model.*;
import app.view.Receiver;
import app.view.Viewer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Blackjack {
    private final Dealer dealer;
    private final DeckOfCards deckOfCards;

    public Blackjack(Dealer dealer, DeckOfCards deckOfCards) {
        this.dealer = dealer;
        this.deckOfCards = deckOfCards;
    }

    public void play() {
        Players players = createPlayers();
        deckOfCards.shuffleDeck();
        players.go();

        Map<String, String> dealerCardStrMap = new HashMap<>();
        Map<String, List<String>> gamblerCardsStrMap = new HashMap<>();
        dealerCardStrMap.put(dealer.getPlayerNameStr(), dealer.peekCardStr());
        players.getGamblerList().stream().forEach(player -> gamblerCardsStrMap.put(
                player.getPlayerNameStr(), player.getCardStrList()));
        Viewer.showInitialCards(dealerCardStrMap, gamblerCardsStrMap);
    }

    private Players createPlayers() {
        try {
            List<Gambler> gamblerList = createGamblerList();
            return new Players(gamblerList, dealer);
        } catch(IllegalArgumentException error) {
            System.err.println(error.getMessage());
            return createPlayers();
        }
    }

    private List<Gambler> createGamblerList() {
        return Receiver.askPlayerNames().stream()
                .map(playerNameStr -> new PlayerName(playerNameStr))
                .map(playerName -> new Gambler(playerName, new Cards(deckOfCards)))
                .collect(Collectors.toList());
    }
}
