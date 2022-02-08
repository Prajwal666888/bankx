package com.suntech;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.suntech.dao.AtmDao;
import com.suntech.domain.Atm;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class AtmTest {

	@Autowired
	private AtmDao atmDao;

	@Test
	public void testAtm() {
		Atm createAtm = createAtm();
		try {
			Atm insertedAtm = atmDao.save(createAtm);
			System.out.println("Data saved");
			// validaing created atm inserted atm.
			validateEquals(createAtm, insertedAtm);

			Atm changeAtm = changeAtm(insertedAtm);
			// validating after updting the data
			Atm updatedAtm = atmDao.save(createAtm);
			System.out.println("Data updated");
			validateEquals(changeAtm, updatedAtm);
		} catch (Exception e) {
			System.out.println("error during executing test case for CRUD ATM");
		} finally {
			if (null != createAtm.getId()) {
				Optional<Atm> deleteAtm = atmDao.findById(createAtm.getId());
				atmDao.delete(deleteAtm.get());
				System.out.println("data deleated");
			}

		}

	}

	public Atm createAtm() {
		Atm atm = new Atm();
		atm.setLocation("banglore");
		atm.setAmountOfCash(111d);
		return atm;
	}

	public Atm changeAtm(Atm atm) {
		atm.setLocation("Manglore");
		atm.setAmountOfCash(222d);
		return atm;
	}

	public void validateEquals(Atm atm, Atm updatedAtm) {
		assertEquals(atm.getAmountOfCash(), updatedAtm.getAmountOfCash());
		assertEquals(atm.getLocation(), updatedAtm.getLocation());
	}

}
