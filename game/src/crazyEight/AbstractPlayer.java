package crazyEight;

abstract class Player 
{
	protected Hand hand;
	
	public Player()
	{
		hand = new Hand();
	}
	
	public void addCard(Card toAdd)
	{
		hand.addCard(toAdd);
	}
	
	abstract public Card playCard(Card topCard, Deck deck);
	
	public Card playAgain(Card topCard, Hand deck){
		for(int i= 0; i<deck.getCardCount(); i++){
			Card playable = deck.removeCard(i);
			if(playable.getSuit() == topCard.getSuit() || playable.getValue() == 8 
					|| playable.getValue() == topCard.getValue()){
				return playable;
			}
			else{
				hand.addCard(playable);
			}
		}
		return null;
	}//if deck runs out of card this is used
	
	public abstract Card selectCard();	
}
