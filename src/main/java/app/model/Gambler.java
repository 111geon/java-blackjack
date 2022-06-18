package app.model;

import java.util.List;

public class Gambler extends Player {
    private Result result;

    public Gambler(PlayerName playerName, Cards cards) {
        super(playerName, cards);
    }

    @Override
    public List<String> startingCardStrList() {
        return getCardStrList();
    }

    @Override
    public boolean canDraw() {
        return !isBusted();
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public String getResultStr() {
        return result.getResultStr();
    }
}
