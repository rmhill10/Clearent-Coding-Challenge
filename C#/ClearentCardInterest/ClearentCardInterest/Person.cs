using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ClearentCardInterest
{
    /// <summary>
    /// defines a person that can hold wallets
    /// </summary>
    public class Person
    {
		private String name;
		private List<Wallet> wallets;
		private decimal lastInterest;

		/// <summary>
		/// creates person with one wallet
		/// </summary>
		/// <param name="name">
		/// name of person
		/// </param>
		public Person(String name)
		{
			setName(name);
			// uses list for wallets so there is not limit to them
			setWallets(new List<Wallet>());
			addWallet();
		}

		// getters and setters
		public List<Wallet> getWallets()
		{
			return wallets;
		}

		public void setWallets(List<Wallet> wallets)
		{
			this.wallets = wallets;
		}

		public String getName()
		{
			return name;
		}

		public void setName(String name)
		{
			this.name = name;
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
		/// adds a new wallet to the person
		/// </summary>
		public void addWallet()
		{
			wallets.Add(new Wallet());
		}
	}
}
