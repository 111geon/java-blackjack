package app.model;

public class Card {
    private final CardNumber cardNumber;
    private final CardShape cardShape;

    public Card(CardNumber cardNumber, CardShape cardShape) {
        this.cardNumber = cardNumber;
        this.cardShape = cardShape;
    }

    String getCardStr() {
        return cardNumber.getCardNumberStr() + cardShape.getCardShape();
    }

    int getCardIntHigh() {
        return cardNumber.getCardNumberIntHigh();
    }

    int getCardIntLow() {
        return cardNumber.getCardNumberIntLow();
    }
}
