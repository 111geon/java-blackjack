package app.model;

import app.controller.PlayerDto;
import app.view.Viewer;

import java.util.ArrayList;
import java.util.List;

public class Dealer extends Player {
    private static final String DEALER_NAME_STR = "딜러";
    private static final int DRAW_UNDER = 17;

    private List<Result> results;

    public Dealer(Cards cards) {
        super(new PlayerName(DEALER_NAME_STR), cards);
        this.results = new ArrayList<>();
    }

    @Override
    public List<String> startingCardStrList() {
        return getCardStrList().subList(0, 1);
    }

    @Override
    public void rotateCards() {
        if (canDraw()) {
            drawCard(1);
            Viewer.dealerDraw(PlayerDto.of(this), getDrawUnder());
        }
    }

    public int getDrawUnder() {
        return DRAW_UNDER;
    }

    public List<Result> getResults() {
        return results;
    }

    @Override
    boolean canDraw() {
        return sumCards() < getDrawUnder();
    }

    void addResult(Result result) {
        results.add(result);
    }
}
