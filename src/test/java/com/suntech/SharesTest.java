package com.suntech;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.suntech.dao.SharesDao;
import com.suntech.domain.Shares;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class SharesTest {

	@Autowired
	private SharesDao sharesDao;

	@Test
	public void testShares() {

		Shares createShares = createShares();
		try {
			Shares insertedShares = sharesDao.save(createShares);
			System.out.println("Data saved");
			// validaing created atm inserted atm.
			validateEquals(createShares, insertedShares);

			Shares changeShares = changeShares(insertedShares);
			// validating after updting the data
			Shares updatedShares = sharesDao.save(createShares);
			System.out.println("Data updated");
			validateEquals(changeShares, updatedShares);
		} catch (Exception e) {
			System.out.println("error during executing test case for CRUD ATM");
		} finally {
			if (null != createShares.getId()) {
				Optional<Shares> deleteShares = sharesDao.findById(createShares.getId());
				sharesDao.delete(deleteShares.get());
				System.out.println("data deleated");
			}

		}

	}

	public Shares createShares() {
		Shares shares = new Shares();

		shares.setNumber(1234567d);
		shares.setValue(20000d);
		shares.setType("Ordinary share");
		shares.setEquity(1d);
		shares.setPreferrential("Cumulative preference shares");

		return shares;
	}

	public Shares changeShares(Shares shares) {

		shares.setNumber(1112246d);
		shares.setValue(40000d);
		shares.setType("Preference shares");
		shares.setEquity(2d);
		shares.setPreferrential("Redeemable preference shares");

		return shares;
	}

	public void validateEquals(Shares shares, Shares updatedShares) {
		assertEquals(shares.getNumber(), updatedShares.getNumber());

		assertEquals(shares.getValue(), updatedShares.getValue());
		assertEquals(shares.getType(), updatedShares.getType());
		assertEquals(shares.getEquity(), updatedShares.getEquity());
		assertEquals(shares.getPreferrential(), updatedShares.getPreferrential());

	}

}
