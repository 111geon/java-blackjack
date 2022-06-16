package app.model;

import java.util.List;
import java.util.stream.IntStream;

public class Player {
    private final PlayerName playerName;
    private final Cards cards;

    public Player(PlayerName playerName, Cards cards) {
        this.playerName = playerName;
        this.cards = cards;
    }

    public String getPlayerNameStr() {
        return playerName.getPlayerNameStr();
    }

    public void drawCard(int num) {
        IntStream.range(0, num).forEach(i -> cards.drawCard());
    }

    public List<String> getCardStrList() {
        return cards.getCardStrList();
    }
}
