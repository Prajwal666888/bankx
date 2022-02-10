package com.suntech;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.suntech.dao.LoanDao;
import com.suntech.domain.Loans;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class LoanTest {

	@Autowired
	private LoanDao loanDao;

	@Test
	public void testLoan() {
		Loans createLoan = createLoan();
		try {
			Loans insertedLoan = loanDao.save(createLoan);
			System.out.println("Data saved");
			// validaing created loans inserted loan.
			validateEquals(createLoan, insertedLoan);

			Loans changeLoan = changeLoan(insertedLoan);
			// validating after updting the data
			Loans updatedLoan = loanDao.save(createLoan);
			System.out.println("Data updated");
			validateEquals(changeLoan, updatedLoan);
		} catch (Exception e) {
			System.out.println("error during executing test case for CRUD ATM");
		} finally {
			if (null != createLoan.getId()) {
				Optional<Loans> deleteLoan = loanDao.findById(createLoan.getId());
				loanDao.delete(deleteLoan.get());
				System.out.println("data deleated");
			}

		}

	}

	private Loans createLoan() {
		Loans loan = new Loans();
		loan.setAmount(120000d);

		loan.setLoanType("home loan");
		loan.setRateOfInterest(5d);
		loan.setTerm("short");

		return loan;
	}

	private Loans changeLoan(Loans loan) {
		loan.setAmount(156600d);

		loan.setLoanType("car loan");
		loan.setRateOfInterest(10d);
		loan.setTerm("long");

		return loan;
	}

	public void validateEquals(Loans loan, Loans updatedLoan) {
		assertEquals(loan.getAmount(), updatedLoan.getAmount());
		assertEquals(loan.getLoanType(), updatedLoan.getLoanType());
		assertEquals(loan.getRateOfInterest(), updatedLoan.getRateOfInterest());
		assertEquals(loan.getTerm(), updatedLoan.getTerm());

	}

}