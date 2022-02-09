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

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class CardTest {

	@Autowired
	private CardDao cardDao;

	@Test
	public void testCard() {

		Card createCard = createCard();
		try {
			Card insertedCard = cardDao.save(createCard);
			System.out.println("Data saved");
			// validaing created atm inserted atm.
			validateEquals(createCard, insertedCard);

			Card changeCard = changeCard(insertedCard);
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

	public Card createCard() {
		Card card = new Card();
		card.setAccountNo(1234567l);
		card.setCardNo(224544554455l);
		card.setValidFrom("May2010");
		card.setValidTo("May2016");
		return card;
	}

	public Card changeCard(Card card) {

		card.setAccountNo(1111111l);
		card.setCardNo(222244446666l);
		card.setValidFrom("May2010");
		card.setValidTo("May2016");

		return card;
	}

	public void validateEquals(Card card, Card updatedCard) {
		assertEquals(card.getAccountNo(), updatedCard.getAccountNo());

		assertEquals(card.getCardNo(), updatedCard.getCardNo());

		assertEquals(card.getValidFrom(), updatedCard.getValidFrom());
		assertEquals(card.getValidTo(), updatedCard.getValidTo());

	}

}
