package app.model;

import app.controller.PlayerDto;
import app.view.Viewer;

import java.util.List;

import static app.view.Receiver.askDraw;

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
    public void rotateCards() {
        while (canDraw() && askDraw(getPlayerNameStr())) {
            drawCard(1);
            Viewer.showCards(PlayerDto.of(this));
        }
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public String getResultStr() {
        return result.getResultStr();
    }

    @Override
    boolean canDraw() {
        return !isBusted();
    }

}
