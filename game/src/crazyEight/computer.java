package crazyEight;

public class computer extends Player{

	public Card playCard(Card topCard, Deck deck) {
		for(Card k : hand.getHand()){
			if(topCard.getSuit() == k.getSuit()){
				hand.removeCard(k);
				return k;
			}
			if(topCard.getValue() == k.getValue() || k.getValue() == 8){
				hand.removeCard(k);
				return k;
			}
		}
		boolean played = false;//hasn't played
		
		do{ 
			if(deck.cardsLeft() == 0){
				return null;	//if deck is empty return asking for discount pile
			}
			Card j = deck.dealCard();
			if(topCard.getSuit() == j.getSuit()){
				return j;
			}//plays card if suit is the same
			if(topCard.getValue() == j.getValue()|| j.getValue() == 8){
				return j;
			}//plays card if value is the same
			played = false;
			hand.addCard(j);
		}while(!played);
	
		return null;// means deck is empty and they should pick from discount pile
	}

	public Card selectCard() 
	{
		return null;
	}	
}
