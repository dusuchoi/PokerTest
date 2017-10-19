package poker;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class EvaluatorTest {

    @Test
    public void 로열스트레이트_플러쉬_검증_성공(){
        Hand hand = new Hand();
        hand.addCard(new Card(10,Suit.SPADE));
        hand.addCard(new Card(11,Suit.SPADE));
        hand.addCard(new Card(12,Suit.SPADE));
        hand.addCard(new Card(13,Suit.SPADE));
        hand.addCard(new Card(1,Suit.SPADE));

        Evaluator evaluator = new Evaluator();
        String result = evaluator.evaluate(hand);
        assertTrue(result.equals("ROYAL_STRAIGHT_FLUSH"));

    }

    @Test
    public void 포카드_검증_성공(){
        Hand hand = new Hand();
        hand.addCard(new Card(3,Suit.HEART));
        hand.addCard(new Card(3,Suit.SPADE));
        hand.addCard(new Card(3,Suit.DIAMOND));
        hand.addCard(new Card(3,Suit.CLUB));
        hand.addCard(new Card(4,Suit.HEART));

        Evaluator evaluator = new Evaluator();
        String result = evaluator.evaluateFourCard(hand);
        assertTrue(result.equals("FOURCARD"));
    }

    @Test
    public void 플러쉬_검증_성공(){
        Hand hand = new Hand();
        hand.addCard(new Card(9,Suit.HEART));
        hand.addCard(new Card(7,Suit.HEART));
        hand.addCard(new Card(3,Suit.HEART));
        hand.addCard(new Card(2,Suit.HEART));
        hand.addCard(new Card(1,Suit.HEART));

        Evaluator evaluator = new Evaluator();
        String result = evaluator.evaluateFlush(hand);
        assertTrue(result.equals("FLUSH"));
    }


    @Test
    public void 스트레이트_검증_성공(){
        Hand hand = new Hand();
        hand.addCard(new Card(3,Suit.SPADE));
        hand.addCard(new Card(5,Suit.HEART));
        hand.addCard(new Card(4,Suit.DIAMOND));
        hand.addCard(new Card(2,Suit.CLUB));
        hand.addCard(new Card(1,Suit.SPADE));

        Evaluator evaluator = new Evaluator();
        String result = evaluator.evaluateStraight(hand);
        assertTrue(result.equals("STRAIGHT"));

    }


}
