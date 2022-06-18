package app.controller;

import app.model.Dealer;
import app.model.Gambler;
import app.model.Result;

import java.util.List;

public class PlayerWinDto{
    public final String name;
    public final String result;

    private PlayerWinDto(String name, String result) {
        this.name = name;
        this.result = result;
    }

    public static PlayerWinDto from(Gambler gambler) {
        return new PlayerWinDto(gambler.getPlayerNameStr(), gambler.getResultStr());
    }

    public static PlayerWinDto from(Dealer dealer) {
        List<Result> resultList = dealer.getResults();
        long numWins = resultList.stream().filter(result -> result.equals(Result.WIN)).count();
        long numLoses = resultList.stream().filter(result -> result.equals(Result.LOSE)).count();
        long numTies = resultList.stream().filter(result -> result.equals(Result.TIE)).count();
        String result = numWins + "승 " + numLoses + "패 " + numTies + "무";
        return new PlayerWinDto(dealer.getPlayerNameStr(), result);
    }
}
