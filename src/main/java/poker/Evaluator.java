package poker;

import java.util.*;

public class Evaluator {

    public String evaluate(Hand hand) {
        if(hand.getCardCount()!=5){
            throw new NotFullhandException();
        }
        boolean isRoyalStraightFlush= true;
        List<Integer> royalRank = new ArrayList<Integer>();
        royalRank.add(1);
        royalRank.add(10);
        royalRank.add(11);
        royalRank.add(12);
        royalRank.add(13);

        List<Card> handList = hand.getCardList();
        for(Card card: handList){
            if(card.getSuit() != Suit.SPADE){
                isRoyalStraightFlush = false;
                break;
            }
            if(royalRank.contains(card.getRank())){
                royalRank.remove(new Integer(card.getRank()));
            }
        }
        if(royalRank.size()!=0){
            isRoyalStraightFlush = false;
        }

        if(isRoyalStraightFlush){
            return "ROYAL_STRAIGHT_FLUSH";
        }

        return null;
    }

    //포카드
    public String evaluateFourCard(Hand hand) {
        if (hand.getCardCount() != 5) {
            throw new NotFullhandException();
        }
        Hashtable<Integer, Integer> ht = new Hashtable<Integer, Integer>();
        List<Card> list = hand.getCardList();
        for (Card card : list) {
            int rank = card.getRank();
            int count = 1;
            if (ht.containsKey(rank)) {
                count = ht.get(rank);
                count++;
                ht.put(rank, count);
            }
            ht.put(card.getRank(), count);
        }
        if(ht.containsValue(4))
            return "FOURCARD";
        return null;
    }

    //플러쉬
    public String evaluateFlush(Hand hand){
        if (hand.getCardCount() != 5) {
            throw new NotFullhandException();
        }
        boolean isFlush = true;
        List<Card> list = hand.getCardList();
        Suit temp = list.remove(0).getSuit();
        for (Card card : list) {
            Suit current = card.getSuit();
            if (temp != current)
                isFlush = false;
        }
        if (isFlush)
            return "FLUSH";
        return null;
    }

    //스트레이트
    public String evaluateStraight(Hand hand){
        if (hand.getCardCount() != 5) {
            throw new NotFullhandException();
        }
        boolean isStraight = true;
        List<Card> list = hand.getCardList();
        Collections.sort(list, Collections.<Card>reverseOrder());

        int temp = list.remove(0).getRank();
        for (Card card : list) {
            int current = card.getRank();
            if (temp -current != 1)
                isStraight = false;
            temp=current;
        }
        if (isStraight)
            return "STRAIGHT";
        return null;
    }


}
