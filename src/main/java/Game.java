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

    public Deck getDeck() {
        return this.deck;
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

    public ArrayList<Player> getPlayers() {
        return players;
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

    public Player getPlayerByName(String name){
        Player returnPlayer = null;
        for(Player player: players){
            if (player.getName() == name) {
                returnPlayer = player;
            }
        }
        return  returnPlayer;
    }

    public void stickOrTwist(Player player, String result){
        if (result.equals("twist") && player.handValue() <= 21) {
            Card card = getDeck().dealCard();
            player.addCard(card);
            stickOrTwist(player, result);
        }
    }

    public void blackJack(){
    }
}
