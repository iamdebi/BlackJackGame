import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PlayerTest

{
    private Player player;
    private Card card1;
    private Card card2;
    private Card card3;
    private Card card4;

    @Before
    public void before(){
        player = new Player("player1");
        card1 = new Card(SuitType.CLUBS, RankType.JACK);
        card2 = new Card(SuitType.CLUBS, RankType.TWO);
        card3 = new Card(SuitType.CLUBS, RankType.THREE);
        card4 = new Card(SuitType.HEARTS, RankType.ACE);
    }

    @Test
    public void canAddCardToPlayer(){
        card1 = new Card(SuitType.CLUBS, RankType.JACK);
        player.addCard(card1);
        assertNotNull(player.getACard(0));
    }

    @Test
    public void dealerTwstsLessThan16(){
        player.addCard(card2);
        player.addCard(card3);
        player.lessThan16(card1);
        assertEquals(15, player.handValue());
    }

    @Test
    public void canFindAceLast(){
        player.addCard(card1);
        player.addCard(card2);
        player.addCard(card3);
        player.addCard(card4);
        assertEquals(card4, player.findAce());
    }

    @Test
    public void canFindAceFirst(){
        player.addCard(card4);
        player.addCard(card1);
        player.addCard(card2);
        player.addCard(card3);
        assertEquals(card4, player.findAce());
    }

    @Test
    public void canFindAceMiddle(){
        player.addCard(card1);
        player.addCard(card2);
        player.addCard(card4);
        player.addCard(card3);
        assertEquals(card4, player.findAce());
    }

    @Test
    public void canFindAceNoAce(){
        player.addCard(card1);
        player.addCard(card2);
        player.addCard(card3);
        assertEquals(null, player.findAce());
    }

}
