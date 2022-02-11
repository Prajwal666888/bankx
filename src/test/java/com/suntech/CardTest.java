package com.suntech;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.suntech.dao.CardDao;
import com.suntech.domain.Card;
import com.suntech.utils.CardUtils;

/**
 * @author Sachin
 *
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class CardTest {

	@Autowired
	private CardDao cardDao;

	@Test
	public void testCard() {

		Card createCard = CardUtils.createCard();
		try {
			Card insertedCard = cardDao.save(createCard);
			System.out.println("Data saved");
			// validaing created atm inserted atm.
			validateEquals(createCard, insertedCard);

			Card changeCard = CardUtils.changeCard(insertedCard);
			// validating after updting the data
			Card updatedCard = cardDao.save(createCard);
			System.out.println("Data updated");
			validateEquals(changeCard, updatedCard);
		} catch (Exception e) {
			System.out.println("error during executing test case for CRUD ATM");
		} finally {
			if (null != createCard.getId()) {
				Optional<Card> deleteCard = cardDao.findById(createCard.getId());
				cardDao.delete(deleteCard.get());
				System.out.println("data deleated");
			}

		}

	}

	public void validateEquals(Card card, Card updatedCard) {

		assertEquals(card.getCardNo(), updatedCard.getCardNo());

		assertEquals(card.getValidFrom(), updatedCard.getValidFrom());
		assertEquals(card.getValidTo(), updatedCard.getValidTo());

	}

}
