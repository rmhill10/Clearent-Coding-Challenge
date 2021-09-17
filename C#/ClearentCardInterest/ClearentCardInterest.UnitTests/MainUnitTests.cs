using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace ClearentCardInterest.UnitTests
{
    [TestClass]
    public class MainUnitTests
    {
        [TestMethod]
        public void onePersonTest1()
        {
			// set up person
			Person personOne = new Person("Person1");
			personOne.getWallets()[0].addCard(Card.CardType.Visa, 100M);
			personOne.getWallets()[0].addCard(Card.CardType.MC, 100M);
			personOne.getWallets()[0].addCard(Card.CardType.Discover, 100M);

			// get interest
			Interest.calculateInterestForPerson(personOne);

			// test per person and per card
			Assert.AreEqual(10M, personOne.getWallets()[0].getCards()[0].getLastInterest());
			Assert.AreEqual(5M, personOne.getWallets()[0].getCards()[1].getLastInterest());
			Assert.AreEqual(1M, personOne.getWallets()[0].getCards()[2].getLastInterest());
			Assert.AreEqual(16M, personOne.getLastInterest());
		}

		[TestMethod]
		public void onePersonTest2()
        {
			// set up person
			Person personOne = new Person("Person1");
			personOne.getWallets()[0].addCard(Card.CardType.Visa, 100M);
			personOne.getWallets()[0].addCard(Card.CardType.Discover, 100M);
			personOne.addWallet();
			personOne.getWallets()[1].addCard(Card.CardType.MC, 100M);

			// get interest
			Interest.calculateInterestForPerson(personOne);

			// test per person and per wallet
			Assert.AreEqual(11M, personOne.getWallets()[0].getLastInterest());
			Assert.AreEqual(5M, personOne.getWallets()[1].getLastInterest());
			Assert.AreEqual(16M, personOne.getLastInterest());
		}

		[TestMethod]
		public void onePersonTest3()
        {
			// set up person
			Person personOne = new Person("Person1");
			personOne.getWallets()[0].addCard(Card.CardType.Visa, 575.75M);
			personOne.getWallets()[0].addCard(Card.CardType.Discover, 35.33M);
			personOne.addWallet();
			personOne.getWallets()[1].addCard(Card.CardType.MC, 168.12M);

			// get interest
			Interest.calculateInterestForPerson(personOne);

			// test per person and per wallet with decimals
			Assert.AreEqual(57.575M, personOne.getWallets()[0].getCards()[0].getLastInterest());
			Assert.AreEqual(0.3533M, personOne.getWallets()[0].getCards()[1].getLastInterest());
			Assert.AreEqual(57.9283M, personOne.getWallets()[0].getLastInterest());
			Assert.AreEqual(8.406M, personOne.getWallets()[1].getLastInterest());
			Assert.AreEqual(66.3343M, personOne.getLastInterest());
		}

		[TestMethod]
		public void twoPeopleTest1()
        {
			// set up person 1
			Person personOne = new Person("Person1");
			personOne.getWallets()[0].addCard(Card.CardType.MC, 100M);
			personOne.getWallets()[0].addCard(Card.CardType.Visa, 100M);

			// set up person 2
			Person personTwo = new Person("Person2");
			personTwo.getWallets()[0].addCard(Card.CardType.Visa, 100M);
			personTwo.getWallets()[0].addCard(Card.CardType.MC, 100M);

			// get interest
			Interest.calculateInterestForPerson(personOne);
			Interest.calculateInterestForPerson(personTwo);

			// test per person and per wallet

			// person 1
			Assert.AreEqual(15M, personOne.getWallets()[0].getLastInterest());
			Assert.AreEqual(15M, personOne.getLastInterest());

			// person 2
			Assert.AreEqual(15M, personTwo.getWallets()[0].getLastInterest());
			Assert.AreEqual(15M, personTwo.getLastInterest());
		}

		[TestMethod]
		public void twoPeopleTest2()
        {
			// set up person 1
			Person personOne = new Person("Person1");
			personOne.getWallets()[0].addCard(Card.CardType.MC, 100M);
			personOne.getWallets()[0].addCard(Card.CardType.Visa, 100M);
			personOne.getWallets()[0].addCard(Card.CardType.Discover, 100M);
			personOne.addWallet();
			personOne.getWallets()[1].addCard(Card.CardType.MC, 100M);
			personOne.getWallets()[1].addCard(Card.CardType.Visa, 100M);
			personOne.getWallets()[1].addCard(Card.CardType.Discover, 100M);
			personOne.addWallet();
			personOne.getWallets()[2].addCard(Card.CardType.MC, 100M);
			personOne.getWallets()[2].addCard(Card.CardType.Visa, 100M);
			personOne.getWallets()[2].addCard(Card.CardType.Discover, 100M);

			// set up person 2
			Person personTwo = new Person("Person2");
			personTwo.getWallets()[0].addCard(Card.CardType.Visa, 100M);
			personTwo.getWallets()[0].addCard(Card.CardType.MC, 100M);
			personTwo.addWallet();
			personTwo.getWallets()[1].addCard(Card.CardType.MC, 100M);
			personTwo.getWallets()[1].addCard(Card.CardType.Visa, 100M);
			personTwo.getWallets()[1].addCard(Card.CardType.Discover, 100M);

			// get interest
			Interest.calculateInterestForPerson(personOne);
			Interest.calculateInterestForPerson(personTwo);

			// test per person and per wallet and per card

			// person 1
			Assert.AreEqual(5M, personOne.getWallets()[0].getCards()[0].getLastInterest());
			Assert.AreEqual(10M, personOne.getWallets()[0].getCards()[1].getLastInterest());
			Assert.AreEqual(1M, personOne.getWallets()[0].getCards()[2].getLastInterest());
			Assert.AreEqual(16M, personOne.getWallets()[0].getLastInterest());
			Assert.AreEqual(5M, personOne.getWallets()[1].getCards()[0].getLastInterest());
			Assert.AreEqual(10M, personOne.getWallets()[1].getCards()[1].getLastInterest());
			Assert.AreEqual(1M, personOne.getWallets()[1].getCards()[2].getLastInterest());
			Assert.AreEqual(16M, personOne.getWallets()[1].getLastInterest());
			Assert.AreEqual(5M, personOne.getWallets()[2].getCards()[0].getLastInterest());
			Assert.AreEqual(10M, personOne.getWallets()[2].getCards()[1].getLastInterest());
			Assert.AreEqual(1M, personOne.getWallets()[2].getCards()[2].getLastInterest());
			Assert.AreEqual(16M, personOne.getWallets()[2].getLastInterest());
			Assert.AreEqual(48M, personOne.getLastInterest());

			// person 2
			Assert.AreEqual(10M, personTwo.getWallets()[0].getCards()[0].getLastInterest());
			Assert.AreEqual(5M, personTwo.getWallets()[0].getCards()[1].getLastInterest());
			Assert.AreEqual(15M, personTwo.getWallets()[0].getLastInterest());
			Assert.AreEqual(5M, personTwo.getWallets()[1].getCards()[0].getLastInterest());
			Assert.AreEqual(10M, personTwo.getWallets()[1].getCards()[1].getLastInterest());
			Assert.AreEqual(1M, personTwo.getWallets()[1].getCards()[2].getLastInterest());
			Assert.AreEqual(16M, personTwo.getWallets()[1].getLastInterest());
			Assert.AreEqual(31M, personTwo.getLastInterest());
		}

	}
}
