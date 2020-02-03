import java.util.ArrayList;

public class Player {
    private ArrayList<Card> hand;
    private String name;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<Card>();
    }

    public String getName() {
        return name;
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

    public Card getACard(int index) {
        return hand.get(index);
    }

    public Card findAce(){
        Card card = null;
        for(int i = 0; i < handSize(); i ++){
            if (getACard(i).getValueFromCard() == 1)
                card = getACard(i);
        }
        return card;
    }

    private int handSize() {
        return this.hand.size();
    }

    public void lessThan16(Card card){
        if (handValue() < 16){
            addCard(card);
        }
    }

}
