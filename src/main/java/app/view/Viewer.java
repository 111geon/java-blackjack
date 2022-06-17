package app.view;

import app.controller.PlayerDto;

import static java.lang.System.out;

import java.util.List;
import java.util.stream.Collectors;

public class Viewer {
    public static void startingAnnouncement(String dealerName, List<String> gamblerNameList, int numCards) {
        String gamblerNames = gamblerNameList.stream().collect(Collectors.joining(", "));
        out.println(dealerName + "와 " + gamblerNames + "에게 " + numCards + "장을 나누었습니다.");
    }

    public static void showCards(PlayerDto playerDto) {
        out.println(nameAndCards(playerDto));
    }

    public static void dealerDraw(PlayerDto dealerDto, int drawUnder) {
        out.println(dealerDto.playerNameStr + "는 " + (drawUnder-1) + "이하라 한장의 카드를 더 받았습니다.");
    }

    public static void showSumCards(PlayerDto playerDto) {
        out.println(nameAndCards(playerDto) + " - 결과: " + playerDto.sumCards);
    }

    private static String nameAndCards(PlayerDto playerDto) {
        return playerDto.playerNameStr + " 카드: "
                + playerDto.cardsStrList.stream().collect(Collectors.joining(", "));
    }

}
