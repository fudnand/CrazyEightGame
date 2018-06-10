package crazyEight;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HumanPlayer extends Player{	
	Scanner  keyboard = new Scanner(System.in);
	
	public HumanPlayer()
	{
		hand = new Hand();
	}

	public Card selectCard(List<Card> pHand) 
	{
		if(pHand.isEmpty()) return null;
		int selection = 0;
		
		System.out.println("Select a card to play");
		selection = keyboard.nextInt();
		
		while(selection<=0 || selection>pHand.size())
		{
			System.out.println("Invalid Card Input. Try a different card: ");
			selection = keyboard.nextInt();
		}
		
		return pHand.get(selection-1);
	}
	
	private List<Card> cardsToPlay(Card topCard, Hand hand)
	{
		if(hand == null) return null;
		
		List<Card> returnList = new ArrayList<Card>();
		for(int i = 0; i< hand.getHand().size(); i++)
		{
			if(topCard.getSuit() == hand.getHand().get(i).getSuit() || topCard.getValue() == hand.getHand().get(i).getValue())
				returnList.add(hand.getHand().get(i));
		}
		
		return returnList;
	}
	
	public Card playCard(Card topCard, Deck deck) {
		
		System.out.println("\n\tTop card is " + topCard);
		
		List<Card> playerHand = cardsToPlay(topCard,hand);
		
		System.out.println("\n===================You can play===================\n");
		for(int i = 0; i<playerHand.size();i++)
		{
			System.out.println((i+1)+") "+playerHand.get(i).toString());
		}
		
		return selectCard(playerHand);		
	}
	
	public Card playAgain(Card topCard, Hand deck){
		return null;
	}//if deck runs out of card this is used

	public Card selectCard() {
		
		return null;
	}
	
}
