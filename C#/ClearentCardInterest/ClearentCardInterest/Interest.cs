using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ClearentCardInterest
{
    /// <summary>
    /// contains methods to find interest
    /// </summary>
    public class Interest
    {
		// methods are static so an object does not have to made to find interest
		// only interest on person is public since that is 
		// currently all that is needed 

		/// <summary>
		/// find interest for card over one month
		/// </summary>
		/// <param name="card">
		/// card to find interest on
		/// </param>
		private static void calculateInterestForCard(Card card)
		{
			// find interest for current card
			decimal interest = card.getBalance() * (decimal)card.getInterest();

			// set last interest of card
			card.setLastInterest(interest);

			// add interest to balance
			card.setBalance(card.getBalance() + interest);
		}

		/// <summary>
		/// find interest for card over one month
		/// </summary>
		/// <param name="wallet">
		/// wallet to find interest on
		/// </param>
		private static void calculateInterestForWallet(Wallet wallet)
		{
			decimal walletInterest = 0.0M;

			// go through each card the person has
			foreach (Card card in wallet.getCards())
			{
				// find interest for current card
				calculateInterestForCard(card);

				// add interest to total wallet interest
				walletInterest += card.getLastInterest();
			}

			// set last interest of wallet
			wallet.setLastInterest(walletInterest);
		}

		/// <summary>
		/// find interest for person and each card over one month
		/// </summary>
		/// <param name="person">
		/// person to find interest on
		/// </param>
		public static void calculateInterestForPerson(Person person)
		{
			decimal totalInterest = 0.0M;

			// go through each wallet the person has
			foreach (Wallet wallet in person.getWallets())
			{
				// find interest for current wallet
				calculateInterestForWallet(wallet);

				// add interest to total person interest
				totalInterest += wallet.getLastInterest();
			}

			// set last interest of person
			person.setLastInterest(totalInterest);
		}
	}
}
