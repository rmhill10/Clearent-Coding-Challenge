package clearentCreditCardInterest;

import java.math.BigDecimal;

// a credit card that can be a Visa, MC or Discover
public class Card 
{
	// card types
	public enum CardType
	{
		Visa, MC, Discover 
		// American Express and JCB can be added later
	}
	
	private CardType cardType;
	private double interest;
	private BigDecimal balance;
	private BigDecimal lastInterest;
	// BigDecimal used for precision 
	
	
	public Card(CardType cardType, BigDecimal balance)
	{
		this.setCardType(cardType);
		this.setBalance(balance);		
	}
	
	// getters and setters
	public CardType getCardType() 
	{
		return cardType;
	}

	public void setCardType(CardType cardType) 
	{
		this.cardType = cardType;
		
		// sets interest based on card type
		if(cardType == CardType.Visa)
			this.interest = 0.1;
		else if(cardType == CardType.MC)
			this.interest = 0.05;
		else 
			this.interest = 0.01;
		
	}

	public double getInterest() 
	{
		return interest;
	}

	public BigDecimal getBalance() 
	{
		return balance;
	}

	public void setBalance(BigDecimal balance) 
	{
		this.balance = balance;
	}

	public BigDecimal getLastInterest() 
	{
		return lastInterest;
	}

	public void setLastInterest(BigDecimal lastInterest) 
	{
		this.lastInterest = lastInterest;
	}
	
}
