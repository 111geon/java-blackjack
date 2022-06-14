package app.model;

import java.util.*;
import java.util.stream.Collectors;

public class PlayerNames {
    private final List<PlayerName> playerNames;

    public PlayerNames(List<String> playerNameStrList) {
        validate(playerNameStrList);
        this.playerNames = playerNameStrList.stream()
                .map(playerNameStr -> new PlayerName(playerNameStr))
                .collect(Collectors.toList());
    }

    public List<PlayerName> getPlayerNames() {
        return playerNames;
    }

    private void validate(List<String> playerNameStrList) {
        Set<String> playerNameStrSet = new HashSet<>(playerNameStrList);
        if(playerNameStrSet.size() != playerNameStrList.size()) {
            throw new PlayerNamesException("중복된 이름이 있습니다.");
        }
    }

    static class PlayerNamesException extends IllegalArgumentException {
        public PlayerNamesException(String message) {
            super(message);
        }
    }
}
