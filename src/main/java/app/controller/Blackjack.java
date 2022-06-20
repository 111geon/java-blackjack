package app.controller;

import app.model.*;
import app.view.Receiver;
import app.view.Viewer;

import java.util.List;
import java.util.stream.Collectors;

public class Blackjack {
    private final Dealer dealer;
    private final DeckOfCards deckOfCards;
    private Players players;

    public Blackjack(Dealer dealer, DeckOfCards deckOfCards) {
        this.dealer = dealer;
        this.deckOfCards = deckOfCards;
    }

    public void play() {
        setPlayers();
        rotateFirstCards();
        showFirstCards();
        rotatePlayers();
        showSumCards();
        showWins();
    }

    private void setPlayers() {
        try {
            List<Gambler> gamblerList = createGamblerList();
            players = new Players(gamblerList, dealer);
        } catch(IllegalArgumentException error) {
            System.err.println(error.getMessage());
            setPlayers();
        }
    }

    private List<Gambler> createGamblerList() {
        return Receiver.askPlayerNames().stream()
                .map(playerNameStr -> new PlayerName(playerNameStr))
                .map(playerName -> new Gambler(playerName, new Cards(deckOfCards)))
                .collect(Collectors.toList());
    }

    private void rotateFirstCards() {
        deckOfCards.shuffleDeck();
        players.receiveStartingCards();
    }

    private void showFirstCards() {
        List<String> gamblerNameList = players.getGamblerList().stream()
                .map(gambler -> gambler.getPlayerNameStr())
                .collect(Collectors.toList());
        int numCards = players.getGamblerList().get(0).startingCardStrList().size();

        Viewer.startingAnnouncement(dealer.getPlayerNameStr(), gamblerNameList, numCards);

        Viewer.showCards(PlayerDto.startingOf(dealer));
        for (Gambler gambler: players.getGamblerList()) {
            Viewer.showCards(PlayerDto.startingOf(gambler));
        }
    }

    private void rotatePlayers() {
        for (Gambler gambler: players.getGamblerList()) { gambler.rotateCards(); }
        dealer.rotateCards();
    }

    private void showSumCards() {
        Viewer.showSumCards(PlayerDto.sumOf(dealer));
        for (Gambler gambler: players.getGamblerList()) {
            Viewer.showSumCards(PlayerDto.sumOf(gambler));
        }
    }

    private void showWins() {
        players.checkWins();
        Viewer.winsAnnouncement();
        Viewer.showWins(PlayerWinDto.from(dealer));
        for (Gambler gambler: players.getGamblerList()) {
            Viewer.showWins(PlayerWinDto.from(gambler));
        }
    }
}
