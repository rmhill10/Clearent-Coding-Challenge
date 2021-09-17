using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using static ClearentCardInterest.Card;

namespace ClearentCardInterest
{
    /// <summary>
    /// defines a wallet a person can hold
    /// </summary>
    public class Wallet
    {
		private List<Card> cards;
		private decimal lastInterest;

		/// <summary>
		/// creates wallet with zero cards
		/// </summary>
		public Wallet()
		{
			// uses list for cards to not limit number of cards
			setCards(new List<Card>());
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

		public decimal getLastInterest()
		{
			return lastInterest;
		}

		public void setLastInterest(decimal lastInterest)
		{
			this.lastInterest = lastInterest;
		}

		/// <summary>
		/// add a card to wallet
		/// </summary>
		/// <param name="type">
		/// card company
		/// </param>
		/// <param name="balance">
		/// amount of money on card
		/// </param>
		public void addCard(CardType type, decimal balance)
		{
			cards.Add(new Card(type, balance));
		}
	}
}
