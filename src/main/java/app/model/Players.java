package app.model;

import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private final List<Player> players;

    public Players(PlayerNames playerNames) {
        this.players = playerNames.getPlayerNames().stream()
                .map(playerName -> new Player(playerName))
                .collect(Collectors.toList());
    }

}
