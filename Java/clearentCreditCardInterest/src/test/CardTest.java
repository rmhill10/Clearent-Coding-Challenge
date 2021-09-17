package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import clearentCreditCardInterest.*;
import clearentCreditCardInterest.Card.CardType;

public class CardTest 
{
	private final Card card = new Card(CardType.Visa, new BigDecimal(100));
	
	@Test
	void getCardType()
	{
		assertEquals(CardType.Visa, card.getCardType());
	}
}
