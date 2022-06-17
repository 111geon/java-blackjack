package app.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Receiver {
    private static final Scanner sc = new Scanner(System.in);

    public static List<String> askPlayerNames() {
        System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");
        return Arrays.stream(sc.nextLine().split(","))
                .map(String::strip)
                .collect(Collectors.toList());
    }

    public static boolean askDraw(String gamblerNameStr) {
        System.out.println(gamblerNameStr + "는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)");
        String input = sc.nextLine();
        Answer answer = Answer.findBy(input);

        if (answer.equals(Answer.RETRY)) {
            System.err.println("y 또는 n으로 대답하세요.");
            return askDraw(gamblerNameStr);
        }

        return answer.isTrue();
    }

}
