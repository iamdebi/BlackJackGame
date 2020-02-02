import java.util.ArrayList;

public class Game {

    private ArrayList<Player> players;
    private Deck deck;
    private Player dealer;

    public Game() {
        this.players = new ArrayList<Player>();
        this.deck = new Deck();
        this.dealer = new Player("dealer");
        this.players.add(this.dealer);

    }

    public int countPlayers() {
        return this.players.size();
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public int countDeck() {
        return this.deck.countCards();
    }

    public void deal() {
        for (Player player : players){
            Card card1  = this.deck.dealCard();
            Card card2  = this.deck.dealCard();
            player.addCard(card1);
            player.addCard(card2);
        }

        this.dealer.lessThan16(this.deck.dealCard());
    }

    public Player winner() {
        Player winningPlayer = players.get(0);
        for(Player player : players){
            int winnerHand =  winningPlayer.handValue();
            if(player.handValue() > winnerHand && player.handValue() <= 21){
                winningPlayer = player;
            }
        }
        return winningPlayer;
    }

}
