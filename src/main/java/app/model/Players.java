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

    public void checkWins() {
        gamblerList.stream().forEach(gambler -> checkWin(gambler).run());
    }

    private Runnable checkWin(Gambler gambler) {
        if (gambler.isBusted()) { return () -> dealerWins(gambler); }
        if (dealer.isBusted()) { return () -> gamblerWins(gambler); }
        if (dealer.sumCards() > gambler.sumCards()) { return () -> dealerWins(gambler); }
        if (gambler.sumCards() > dealer.sumCards()) { return () -> gamblerWins(gambler); }
        return () -> dealerGamblerTies(gambler);
    }

    private void gamblerWins(Gambler gambler) {
        gambler.setResult(Result.WIN);
        dealer.addResult(Result.LOSE);
    }

    private void dealerWins(Gambler gambler) {
        gambler.setResult(Result.LOSE);
        dealer.addResult(Result.WIN);
    }

    private void dealerGamblerTies(Gambler gambler) {
        gambler.setResult(Result.TIE);
        dealer.addResult(Result.TIE);
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
