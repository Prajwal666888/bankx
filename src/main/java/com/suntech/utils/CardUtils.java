package com.suntech.utils;

import com.suntech.domain.Card;

public class CardUtils {
	
	public static Card createCard() {
		Card card = new Card();
		card.setCardNo(224544554455l);
		card.setValidFrom("May2010");
		card.setValidTo("May2016");
		return card;
	}

	public static Card changeCard(Card card) {

		card.setCardNo(222244446666l);
		card.setValidFrom("May2010");
		card.setValidTo("May2016");

		return card;
	}

}
