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

    @Before
    public void before(){
        player = new Player();
        card1 = new Card(SuitType.CLUBS, RankType.JACK);
        card2 = new Card(SuitType.CLUBS, RankType.TWO);
        card3 = new Card(SuitType.CLUBS, RankType.THREE);
    }

    @Test
    public void canAddCardToPlayer(){
        card1 = new Card(SuitType.CLUBS, RankType.JACK);
        player.addCard(card1);
        assertNotNull(player.getACard());
    }

    @Test
    public void dealerTwstsLessThan16(){
        player.addCard(card2);
        player.addCard(card3);
        player.lessThan16(card1);
        assertEquals(15, player.handValue());
    }

}
