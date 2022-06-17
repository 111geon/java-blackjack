package app.model;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public abstract class Player {
    private final PlayerName playerName;
    private final Cards cards;

    public Player(PlayerName playerName, Cards cards) {
        this.playerName = playerName;
        this.cards = cards;
    }

    public String getPlayerNameStr() {
        return playerName.getPlayerNameStr();
    }

    public List<String> getCardStrList() {
        return cards.getCardStrList();
    }

    public void drawCard(int num) {
        IntStream.range(0, num).forEach(i -> cards.drawCard());
    }

    public int sumCards() {
        return cards.bestSum();
    }

    public boolean isBusted() {
        return cards.isBusted();
    }

    public abstract List<String> startingCardStrList();

    public abstract boolean canDraw();
}
