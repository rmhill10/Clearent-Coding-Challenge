using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ClearentCardInterest
{
	/// <summary>
	/// credit card from Visa, MC, or Discover
	/// </summary>
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
		private decimal balance;
		private decimal lastInterest;
		// BigDecimal used for precision 


		public Card(CardType cardType, decimal balance)
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
			if (cardType == CardType.Visa)
				this.interest = 0.1;
			else if (cardType == CardType.MC)
				this.interest = 0.05;
			else
				this.interest = 0.01;

		}

		public double getInterest()
		{
			return interest;
		}

		public decimal getBalance()
		{
			return balance;
		}

		public void setBalance(decimal balance)
		{
			this.balance = balance;
		}

		public decimal getLastInterest()
		{
			return lastInterest;
		}

		public void setLastInterest(decimal lastInterest)
		{
			this.lastInterest = lastInterest;
		}
	}
}
