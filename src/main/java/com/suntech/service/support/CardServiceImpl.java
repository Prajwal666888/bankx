package com.suntech.service.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suntech.dao.CardDao;
import com.suntech.domain.Card;
import com.suntech.service.CardService;

@Service
public class CardServiceImpl implements CardService {

	@Autowired
	private CardDao cardDao;
	
	@Override
	public Card addCard(Card card) {
		
		cardDao.save(card);
		return card;
		
	}

	
}
