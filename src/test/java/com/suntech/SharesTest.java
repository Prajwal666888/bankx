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
import com.suntech.utils.SharesUtils;

/**
 * @author Sachin
 *
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class SharesTest {

	@Autowired
	private SharesDao sharesDao;

	@Test
	public void testShares() {

		Shares createShares = SharesUtils.createShares();
		try {
			Shares insertedShares = sharesDao.save(createShares);
			System.out.println("Data saved");
			// validaing created atm inserted atm.
			validateEquals(createShares, insertedShares);

			Shares changeShares = SharesUtils.changeShares(insertedShares);
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

	public void validateEquals(Shares shares, Shares updatedShares) {
		assertEquals(shares.getNumber(), updatedShares.getNumber());

		assertEquals(shares.getValue(), updatedShares.getValue());
		assertEquals(shares.getType(), updatedShares.getType());
		assertEquals(shares.getEquity(), updatedShares.getEquity());
		assertEquals(shares.getPreferrential(), updatedShares.getPreferrential());

	}

}
