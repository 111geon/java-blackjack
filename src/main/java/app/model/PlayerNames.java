package app.model;

import java.util.*;

public class PlayerNames {
    private final List<PlayerName> playerNames;

    public PlayerNames(List<PlayerName> playerNameList) {
        validate(playerNameList);
        this.playerNames = playerNameList;
    }

    public List<PlayerName> getPlayerNames() {
        return playerNames;
    }

    private void validate(List<PlayerName> playerNameList) {
        Set<PlayerName> playerNameSet = new HashSet<>(playerNameList);
        if(playerNameSet.size() != playerNameList.size()) {
            throw new PlayerNamesException("중복된 이름이 있습니다.");
        }
    }

    static class PlayerNamesException extends IllegalArgumentException {
        public PlayerNamesException(String message) {
            super(message);
        }
    }
}
