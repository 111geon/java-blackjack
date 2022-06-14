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
}
