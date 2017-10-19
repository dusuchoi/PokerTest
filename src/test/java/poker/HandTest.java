package poker;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class HandTest {

    @Test
    public void 덱에서_한장을뽑으면_핸드는_1장이다(){
        Deck deck = new Deck(1);
        Hand hand = new Hand();
        hand.addCard(deck.drawCard());
        assertTrue(hand.getCardCount() == 1 );
    }

    @Test(expected = NoMoreHandException.class)
    public void 핸드에는_5장까지_가능하다(){
        Deck deck = new Deck(1);
        Hand hand = new Hand();
        for(int i=0; i<5; i++){
            hand.addCard(deck.drawCard());
        }
        hand.addCard(deck.drawCard());

    }
}
