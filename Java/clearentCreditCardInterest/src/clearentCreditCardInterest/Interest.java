package clearentCreditCardInterest;

import java.math.BigDecimal;

// contains methods to find interest
public class Interest 
{
		// find interest for card over given months
		public static void calculateInterestForCard(Card card) 
		{
			// find interest for current card
			BigDecimal interest = card.getBalance().multiply(new BigDecimal(card.getInterest()));
			
			// set last interest of card
			card.setLastInterest(interest);
			
			// add interest to balance
			card.setBalance(card.getBalance().add(interest));		
		}
		
		// find interest for card over given months
		public static void calculateInterestForWallet(Wallet wallet) 
		{
			BigDecimal walletInterest = new BigDecimal("0.0");
			
			// go through each card the person has
			for (Card card : wallet.getCards()) 
			{
				// find interest for current card
				calculateInterestForCard(card);
				
				walletInterest = walletInterest.add(card.getLastInterest());
			}
			
			// set last interest of wallet
			wallet.setLastInterest(walletInterest);
		}
		
		// find interest for person and each card over given months
		public static void calculateInterestForPerson(Person person) 
		{
			BigDecimal totalInterest = new BigDecimal("0.0");
			
			// go through each wallet the person has
			for (Wallet wallet : person.getWallets()) 
			{
				calculateInterestForWallet(wallet);
				totalInterest = totalInterest.add(wallet.getLastInterest());
			}	
			
			person.setLastInterest(totalInterest);
		}	
}
