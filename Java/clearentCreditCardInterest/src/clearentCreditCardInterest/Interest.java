package clearentCreditCardInterest;

import java.math.BigDecimal;

// contains methods to find interest
public class Interest 
{
		// methods are static so an object does not have to made to find interest
		// only interest on person is public since that is 
		// currently all that is needed 
	
		// find interest for card over one month
		private static void calculateInterestForCard(Card card) 
		{
			// find interest for current card
			BigDecimal interest = card.getBalance().multiply(new BigDecimal(card.getInterest()));
			
			// set last interest of card
			card.setLastInterest(interest);
			
			// add interest to balance
			card.setBalance(card.getBalance().add(interest));		
		}
		
		// find interest for card over one month
		private static void calculateInterestForWallet(Wallet wallet) 
		{
			BigDecimal walletInterest = new BigDecimal("0.0");
			
			// go through each card the person has
			for (Card card : wallet.getCards()) 
			{
				// find interest for current card
				calculateInterestForCard(card);
				
				// add interest to total wallet interest
				walletInterest = walletInterest.add(card.getLastInterest());
			}
			
			// set last interest of wallet
			wallet.setLastInterest(walletInterest);
		}
		
		// find interest for person and each card over one month
		public static void calculateInterestForPerson(Person person) 
		{
			BigDecimal totalInterest = new BigDecimal("0.0");
			
			// go through each wallet the person has
			for (Wallet wallet : person.getWallets()) 
			{
				// find interest for current wallet
				calculateInterestForWallet(wallet);
				
				// add interest to total person interest
				totalInterest = totalInterest.add(wallet.getLastInterest());
			}	
			
			// set last interest of person
			person.setLastInterest(totalInterest);
		}	
}
