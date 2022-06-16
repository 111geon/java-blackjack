package app.model;

public class Dealer extends Player {
    private static final String dealerNameStr = "딜러";

    public Dealer(Cards cards) {
        super(new PlayerName(dealerNameStr), cards);
    }

    public String peekCardStr() {
        return getCardStrList().get(0);
    }
}
