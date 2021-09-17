package clearentCreditCardInterest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

// defines a person that can hold wallets
public class Person 
{
	
	private String name;
	private List<Wallet> wallets;
	private BigDecimal lastInterest;
	
	// creates person with one wallet
	public Person(String name)
	{
		setName(name);
		// uses list for wallets so there is not limit to them
		setWallets(new ArrayList<Wallet>());
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

	public BigDecimal getLastInterest() 
	{
		return lastInterest;
	}

	public void setLastInterest(BigDecimal lastInterest) 
	{
		this.lastInterest = lastInterest;
	}

	// add a new wallet to person
	public void addWallet() 
	{
		wallets.add(new Wallet());
	}	
	
}
