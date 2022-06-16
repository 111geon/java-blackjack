package app.view;

import static java.lang.System.out;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Viewer {
    public static void showInitialCards(Map<String, String> dealerCardStrMap,
                                        Map<String, List<String>> gamblerCardsStrMap) {
        String dealerName = trimBrackets(dealerCardStrMap.keySet().toString());
        String gamblerNames = trimBrackets(gamblerCardsStrMap.keySet().toString());
        int numCards = gamblerCardsStrMap.values().iterator().next().size();

        out.println(dealerName + "와 " + gamblerNames + "에게 " + numCards + "장을 나누었습니다.");
        out.println(dealerName + ": " + trimBrackets(dealerCardStrMap.values().toString()));
        for (Map.Entry<String, List<String>> entry: gamblerCardsStrMap.entrySet()) {
            String gamblerCards = trimBrackets(entry.getValue().toString());
            out.println(entry.getKey() + ": " + gamblerCards);
        }
    }

    private static String trimBrackets(String toTrim) {
        return toTrim.substring(1, toTrim.length()-1);
    }
}
