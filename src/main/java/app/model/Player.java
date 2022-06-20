package app.model;

import java.util.List;

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
        for (; num > 0; num--) {
            cards.drawCard();
        }
    }

    public int sumCards() {
        return cards.bestSum();
    }

    public boolean isBusted() {
        return cards.isBusted();
    }

    public abstract List<String> startingCardStrList();

    public abstract void rotateCards();

    abstract boolean canDraw();
}
