import java.util.ArrayList;

public class Player {
    private ArrayList<Card> hand;

    public Player() {
        this.hand = new ArrayList<Card>();
    }

    public ArrayList<Card> getHand() {
        return this.hand;
    }

    public void addCard(Card card) {
        this.hand.add(card);
    }

    public int handValue(){
        ArrayList<Card> playersHand = getHand();
        int totalValue = 0;
        for(Card card : playersHand){
            totalValue += card.getValueFromCard();
        }
        return totalValue;
    }

//    Delete this
    public  Card getHandCard(){
         Card cardReturn = null;
            for (Card card : getHand()){
                cardReturn = card;
                }
        return cardReturn;
    }

}
