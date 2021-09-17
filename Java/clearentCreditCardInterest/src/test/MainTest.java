package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import clearentCreditCardInterest.*;
import clearentCreditCardInterest.Card.CardType;

public class MainTest 
{		
	@Test
	void onePersonTest1()
	{
		// set up person
		Person personOne = new Person("Person1");
		personOne.getWallets().get(0).addCard(CardType.Visa, new BigDecimal("100"));		
		personOne.getWallets().get(0).addCard(CardType.MC, new BigDecimal("100"));	
		personOne.getWallets().get(0).addCard(CardType.Discover, new BigDecimal("100"));
		
		// get interest
		Interest.calculateInterestForPerson(personOne);
		
		// test per person and per card
		assertEquals(10, personOne.getWallets().get(0).getCards().get(0).getLastInterest().doubleValue());
		assertEquals(5, personOne.getWallets().get(0).getCards().get(1).getLastInterest().doubleValue());
		assertEquals(1, personOne.getWallets().get(0).getCards().get(2).getLastInterest().doubleValue());
		assertEquals(16, personOne.getLastInterest().doubleValue());
	}
	
	@Test
	void onePersonTest2()
	{
		// set up person
		Person personOne = new Person("Person1");
		personOne.getWallets().get(0).addCard(CardType.Visa, new BigDecimal("100"));		
		personOne.getWallets().get(0).addCard(CardType.Discover, new BigDecimal("100"));	
		personOne.addWallet();
		personOne.getWallets().get(1).addCard(CardType.MC, new BigDecimal("100"));
		
		// get interest
		Interest.calculateInterestForPerson(personOne);
		
		// test per person and per wallet
		assertEquals(11, personOne.getWallets().get(0).getLastInterest().doubleValue());
		assertEquals(5, personOne.getWallets().get(1).getLastInterest().doubleValue());
		assertEquals(16, personOne.getLastInterest().doubleValue());
	}
	
	@Test
	void onePersonTest3()
	{
		// set up person
		Person personOne = new Person("Person1");
		personOne.getWallets().get(0).addCard(CardType.Visa, new BigDecimal("575.75"));		
		personOne.getWallets().get(0).addCard(CardType.Discover, new BigDecimal("35.33"));	
		personOne.addWallet();
		personOne.getWallets().get(1).addCard(CardType.MC, new BigDecimal("168.12"));
		
		// get interest
		Interest.calculateInterestForPerson(personOne);
		
		// test per person and per wallet with decimals
		assertEquals(57.575, personOne.getWallets().get(0).getCards().get(0).getLastInterest().doubleValue());
		assertEquals(0.3533, personOne.getWallets().get(0).getCards().get(1).getLastInterest().doubleValue());
		assertEquals(57.9283, personOne.getWallets().get(0).getLastInterest().doubleValue());
		assertEquals(8.406, personOne.getWallets().get(1).getLastInterest().doubleValue());
		assertEquals(66.3343, personOne.getLastInterest().doubleValue());
	}
	
	@Test
	void twoPeopleTest1()
	{
		// set up person 1
		Person personOne = new Person("Person1");
		personOne.getWallets().get(0).addCard(CardType.MC, new BigDecimal("100"));		
		personOne.getWallets().get(0).addCard(CardType.Visa, new BigDecimal("100"));	
		
		// set up person 2
		Person personTwo = new Person("Person2");
		personTwo.getWallets().get(0).addCard(CardType.Visa, new BigDecimal("100"));		
		personTwo.getWallets().get(0).addCard(CardType.MC, new BigDecimal("100"));	
		
		// get interest
		Interest.calculateInterestForPerson(personOne);
		Interest.calculateInterestForPerson(personTwo);
		
		// test per person and per wallet
		
		// person 1
		assertEquals(15, personOne.getWallets().get(0).getLastInterest().doubleValue());
		assertEquals(15, personOne.getLastInterest().doubleValue());
		
		// person 2
		assertEquals(15, personTwo.getWallets().get(0).getLastInterest().doubleValue());
		assertEquals(15, personTwo.getLastInterest().doubleValue());
	}
	
	@Test
	void twoPeopleTest2()
	{
		// set up person 1
		Person personOne = new Person("Person1");
		personOne.getWallets().get(0).addCard(CardType.MC, new BigDecimal("100"));		
		personOne.getWallets().get(0).addCard(CardType.Visa, new BigDecimal("100"));	
		personOne.getWallets().get(0).addCard(CardType.Discover, new BigDecimal("100"));	
		personOne.addWallet();
		personOne.getWallets().get(1).addCard(CardType.MC, new BigDecimal("100"));		
		personOne.getWallets().get(1).addCard(CardType.Visa, new BigDecimal("100"));	
		personOne.getWallets().get(1).addCard(CardType.Discover, new BigDecimal("100"));
		personOne.addWallet();
		personOne.getWallets().get(2).addCard(CardType.MC, new BigDecimal("100"));		
		personOne.getWallets().get(2).addCard(CardType.Visa, new BigDecimal("100"));	
		personOne.getWallets().get(2).addCard(CardType.Discover, new BigDecimal("100"));	
		
		// set up person 2
		Person personTwo = new Person("Person2");
		personTwo.getWallets().get(0).addCard(CardType.Visa, new BigDecimal("100"));		
		personTwo.getWallets().get(0).addCard(CardType.MC, new BigDecimal("100"));	
		personTwo.addWallet();
		personTwo.getWallets().get(1).addCard(CardType.MC, new BigDecimal("100"));		
		personTwo.getWallets().get(1).addCard(CardType.Visa, new BigDecimal("100"));	
		personTwo.getWallets().get(1).addCard(CardType.Discover, new BigDecimal("100"));	
		
		// get interest
		Interest.calculateInterestForPerson(personOne);
		Interest.calculateInterestForPerson(personTwo);
		
		// test per person and per wallet and per card
		
		// person 1
		assertEquals(5, personOne.getWallets().get(0).getCards().get(0).getLastInterest().doubleValue());
		assertEquals(10, personOne.getWallets().get(0).getCards().get(1).getLastInterest().doubleValue());
		assertEquals(1, personOne.getWallets().get(0).getCards().get(2).getLastInterest().doubleValue());
		assertEquals(16, personOne.getWallets().get(0).getLastInterest().doubleValue());
		assertEquals(5, personOne.getWallets().get(1).getCards().get(0).getLastInterest().doubleValue());
		assertEquals(10, personOne.getWallets().get(1).getCards().get(1).getLastInterest().doubleValue());
		assertEquals(1, personOne.getWallets().get(1).getCards().get(2).getLastInterest().doubleValue());
		assertEquals(16, personOne.getWallets().get(1).getLastInterest().doubleValue());
		assertEquals(5, personOne.getWallets().get(2).getCards().get(0).getLastInterest().doubleValue());
		assertEquals(10, personOne.getWallets().get(2).getCards().get(1).getLastInterest().doubleValue());
		assertEquals(1, personOne.getWallets().get(2).getCards().get(2).getLastInterest().doubleValue());
		assertEquals(16, personOne.getWallets().get(2).getLastInterest().doubleValue());
		assertEquals(48, personOne.getLastInterest().doubleValue());
		
		// person 2
		assertEquals(10, personTwo.getWallets().get(0).getCards().get(0).getLastInterest().doubleValue());
		assertEquals(5, personTwo.getWallets().get(0).getCards().get(1).getLastInterest().doubleValue());
		assertEquals(15, personTwo.getWallets().get(0).getLastInterest().doubleValue());
		assertEquals(5, personTwo.getWallets().get(1).getCards().get(0).getLastInterest().doubleValue());
		assertEquals(10, personTwo.getWallets().get(1).getCards().get(1).getLastInterest().doubleValue());
		assertEquals(1, personTwo.getWallets().get(1).getCards().get(2).getLastInterest().doubleValue());
		assertEquals(16, personTwo.getWallets().get(1).getLastInterest().doubleValue());
		assertEquals(31, personTwo.getLastInterest().doubleValue());
	}
}
