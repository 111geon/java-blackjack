package app.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Players {
    private static final int INITIAL_CARDS = 2;

    private final List<Gambler> gamblerList;
    private final Dealer dealer;

    public Players(List<Gambler> gamblerList, Dealer dealer) {
        this.gamblerList = gamblerList;
        this.dealer = dealer;
        validate(gamblerList);
    }

    public void receiveStartingCards() {
        dealer.drawCard(INITIAL_CARDS);
        gamblerList.stream().forEach(player -> player.drawCard(INITIAL_CARDS));
    }

    public List<Gambler> getGamblerList() {
        return gamblerList;
    }

    public Dealer getDealer() {
        return dealer;
    }

    private void validate(List<Gambler> gamblerList) {
        List<String> playerNameStrList = gamblerList.stream()
                .map(Player::getPlayerNameStr).collect(Collectors.toList());

        if (playerNameStrList.contains(dealer.getPlayerNameStr())) {
            throw new PlayerName.PlayerNameException("참가자 이름은 딜러일 수 없습니다.");
        }

        Set<String> playerNameSet = new HashSet<>(playerNameStrList);
        if (playerNameSet.size() != playerNameStrList.size()) {
            throw new PlayerName.PlayerNameException("중복된 이름이 있습니다.");
        }
    }

}
