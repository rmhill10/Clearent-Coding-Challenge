package clearentCreditCardInterest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import clearentCreditCardInterest.Card.CardType;

// defines a wallet a person can hold
public class Wallet 
{
	private List<Card> cards;
	private BigDecimal lastInterest;
	
	// creates wallet with zero cards
	public Wallet()
	{
		// uses list for cards to not limit number of cards
		setCards(new ArrayList<Card>());
	}
	
	// getters and setters
	public List<Card> getCards() 
	{
		return cards;
	}
	
	public void setCards(List<Card> cards) 
	{
		this.cards = cards;
	}
	
	public BigDecimal getLastInterest() 
	{
		return lastInterest;
	}

	public void setLastInterest(BigDecimal lastInterest) 
	{
		this.lastInterest = lastInterest;
	}

	// add a card to wallet
	public void addCard(CardType type, BigDecimal balance)
	{
		cards.add(new Card(type, balance));
	}
	
	
}
