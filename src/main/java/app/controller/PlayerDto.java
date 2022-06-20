package app.controller;

import app.model.Player;

import java.util.List;

public class PlayerDto {
    public final String playerNameStr;
    public final List<String> cardsStrList;
    public final int sumCards;

    private PlayerDto(String playerNameStr, List<String> cardsStrList, int sumCards) {
        this.playerNameStr = playerNameStr;
        this.cardsStrList = cardsStrList;
        this.sumCards = sumCards;
    }

    public static PlayerDto startingOf(Player player) {
        return new PlayerDto(player.getPlayerNameStr(), player.startingCardStrList(), 0);
    }

    public static PlayerDto of(Player player) {
        return new PlayerDto(player.getPlayerNameStr(), player.getCardStrList(), 0);
    }

    public static PlayerDto sumOf(Player player) {
        return new PlayerDto(player.getPlayerNameStr(), player.getCardStrList(), player.sumCards());
    }
}
