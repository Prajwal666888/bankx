package com.suntech;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.suntech.dao.BankDao;
import com.suntech.domain.Bank;
import com.suntech.utils.BankUtils;

/**
 * @author Sachin
 *
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class BankTest {

	@Autowired
	private BankDao bd;

	@Test
	public void testBank() {
		Bank b = BankUtils.createBank();
		try {
			Bank ib = bd.save(b);
			System.out.println("Data saved");
//			compare the created and inserted bank
			validateEquals(b, ib);

//			change the inserted Bank 
			Bank cb = BankUtils.changeBank(ib);
//			validate after updating
			Bank cbb = bd.save(cb);
//			compare the strored data and created data
			validateEquals(cb, cbb);

		} catch (Exception e) {
			System.out.println("Error during the creation of the banking");
		} finally {

			if (null != b.getId()) {
				Optional<Bank> db = bd.findById(b.getId());
				bd.delete(db.get());
				System.out.println("Bank Record is deleted");
			}
		}
	}

	public void validateEquals(Bank b, Bank ub) {
		assertEquals(b.getName(), ub.getName());
		assertEquals(b.getHead_office(), ub.getHead_office());
		assertEquals(b.getType(), ub.getType());
	}

}
