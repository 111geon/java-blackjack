package app.model;

public enum CardNumber {
    ACE("A", 1, 11),
    TWO("2", 2, 2),
    THREE("3", 3, 3),
    FOUR("4", 4, 4),
    FIVE("5", 5, 5),
    SIX("6", 6, 6),
    SEVEN("7", 7, 7),
    EIGHT("8", 8, 8),
    NINE("9", 9, 9),
    TEN("10", 10, 10),
    JACK("J", 10, 10),
    QUEEN("Q", 10, 10),
    KING("K", 10, 10);

    private final String cardNumberStr;
    private final int cardNumberIntLow;
    private final int cardNumberIntHigh;

    CardNumber(String cardNumberStr, int cardNumberIntLow, int cardNumberIntHigh) {
        this.cardNumberStr = cardNumberStr;
        this.cardNumberIntLow = cardNumberIntLow;
        this.cardNumberIntHigh = cardNumberIntHigh;
    }

    String getCardNumberStr() { return cardNumberStr; }

    int getCardNumberIntHigh() { return cardNumberIntHigh; }

    int getCardNumberIntLow() { return cardNumberIntLow; }
}
