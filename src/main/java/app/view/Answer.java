package app.view;

import java.util.Arrays;
import java.util.List;

public enum Answer {
    TRUE(true, Arrays.asList("y", "yes", "ok")),
    FALSE(false, Arrays.asList("n", "no", "stop")),
    RETRY(false, Arrays.asList());

    private boolean isTrue;
    private List<String> strList;

    Answer(boolean isTrue, List<String> strList) {
        this.isTrue = isTrue;
        this.strList = strList;
    }

    boolean isTrue() {
        return isTrue;
    }

    static app.view.Answer findBy(String input) {
        return Arrays.stream(app.view.Answer.values()).filter(answer -> answer.has(input)).findAny().orElse(RETRY);
    }

    private boolean has(String input) {
        return strList.stream().anyMatch(s -> s.equals(input));
    }
}