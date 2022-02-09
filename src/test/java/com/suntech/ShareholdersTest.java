package com.suntech;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.suntech.dao.ShareholdersDao;
import com.suntech.domain.Shareholders;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class ShareholdersTest {
	
	@Autowired
	private ShareholdersDao shareholdersDao;
	
	@Test
	public void testShareholders() {
		
		Shareholders createShareholders = createShareholders();
		try {
			Shareholders insertedShareholders = shareholdersDao.save(createShareholders);
			System.out.println("Data saved");
			// validaing created atm inserted atm.
			validateEquals(createShareholders, insertedShareholders);

			Shareholders changeShareholders = changeShareholders(insertedShareholders);
			// validating after updting the data
			Shareholders updatedShareholders = shareholdersDao.save(createShareholders);
			System.out.println("Data updated");
			validateEquals(changeShareholders, updatedShareholders);
		} catch (Exception e) {
			System.out.println("error during executing test case for CRUD ATM");
		} finally {
			if (null != createShareholders.getId()) {
				Optional<Shareholders> deleteShareholders = shareholdersDao.findById(createShareholders.getId());
				shareholdersDao.delete(deleteShareholders.get());
				System.out.println("data deleated");
			}

		}

	}

	public Shareholders createShareholders() {
		Shareholders shareholders = new Shareholders();
		shareholders.setName("XYZ");
		
		return shareholders;
	}

	public Shareholders changeShareholders(Shareholders shareholders) {
		
		shareholders.setName("ZZZ");
		
		
		return shareholders;
	}

	public void validateEquals(Shareholders shareholders, Shareholders updatedShareholders) {
		assertEquals(shareholders.getName(),updatedShareholders.getName());
		
		
		
	}

}
