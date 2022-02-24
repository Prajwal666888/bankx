package com.suntech;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.suntech.dao.LoanDao;
import com.suntech.domain.Loans;
import com.suntech.utils.LoanUtils;

/**
 * @author Sachin
 *
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class LoanTest {

	@Autowired
	private LoanDao loanDao;

	@Test
	@Rollback(false)
	public void testLoan() {
		Loans createLoan = LoanUtils.createLoan();
		try {
			Loans insertedLoan = loanDao.save(createLoan);
			System.out.println("Data saved");
			// validaing created loans inserted loan.
			validateEquals(createLoan, insertedLoan);

			Loans changeLoan = LoanUtils.changeLoan(insertedLoan);
			// validating after updting the data
			Loans updatedLoan = loanDao.save(createLoan);
			System.out.println("Data updated");
			validateEquals(changeLoan, updatedLoan);
		} catch (Exception e) {
			System.out.println("error during executing test case for CRUD ATM");
		} finally {
//			if (null != createLoan.getId()) {
//				Optional<Loans> deleteLoan = loanDao.findById(createLoan.getId());
//				loanDao.delete(deleteLoan.get());
//				System.out.println("data deleated");
//			}

		}

	}

	

	public void validateEquals(Loans loan, Loans updatedLoan) {
		assertEquals(loan.getAmount(), updatedLoan.getAmount());
		assertEquals(loan.getLoanType(), updatedLoan.getLoanType());
		assertEquals(loan.getRateOfInterest(), updatedLoan.getRateOfInterest());
		assertEquals(loan.getTerm(), updatedLoan.getTerm());

	}

}