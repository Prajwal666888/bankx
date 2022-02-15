package com.suntech;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.suntech.dao.AccountTypeDao;
import com.suntech.domain.AccountType;
import com.suntech.utils.AccountTypeUtils;

/**
 * @author Sachin
 *
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class AccountTypeTest {

	@Autowired
	private AccountTypeDao accountTypeDao;

	@Test
	public void testAccountType() {
		AccountType createAccountType = AccountTypeUtils.createAccountType();

		try {

			AccountType insertedAccountType = accountTypeDao.save(createAccountType);
			System.out.println("Data saved");
			// validating created atm inserted atm.
			validateEquals(createAccountType, insertedAccountType);

			AccountType changeAccountType = AccountTypeUtils.changeAccountType(insertedAccountType);
			// validating after updting the data
			AccountType updatedAccountType = accountTypeDao.save(createAccountType);
			System.out.println("Data updated");
			validateEquals(changeAccountType, updatedAccountType);
		} catch (Exception e) {
			System.out.println("error during executing test case for CRUD AccountType");
		} finally {
			if (null != createAccountType.getId()) {
				Optional<AccountType> deleteAccountType = accountTypeDao.findById(createAccountType.getId());
				accountTypeDao.delete(deleteAccountType.get());
				System.out.println("data deleated");
			}

		}

	}

	public void validateEquals(AccountType AccountType, AccountType updatedAccountType) {
		assertEquals(AccountType.getTransactionLimit(), updatedAccountType.getTransactionLimit());
		assertEquals(AccountType.getDepositAmount(), updatedAccountType.getDepositAmount());
		assertEquals(AccountType.getWithdrawlLimit(), updatedAccountType.getWithdrawlLimit());
		assertEquals(AccountType.getInterestRate(), updatedAccountType.getInterestRate());
	}
}
