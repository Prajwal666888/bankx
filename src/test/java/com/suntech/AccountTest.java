package com.suntech;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.suntech.dao.AccountDao;
import com.suntech.dao.AccountDao;
import com.suntech.domain.Account;
import com.suntech.domain.Atm;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class AccountTest {

	@Autowired
	private AccountDao accountDao;

	@Test
	public void testAccount() {
		Account createAccount = createAccount();

		try {

			Account insertedAccount = accountDao.save(createAccount);
			System.out.println("Data saved");
			// validating created atm inserted atm.
			validateEquals(createAccount, insertedAccount);

			Account changeAccount = changeAccount(insertedAccount);
			// validating after updting the data
			Account updatedAccount = accountDao.save(createAccount);
			System.out.println("Data updated");
			validateEquals(changeAccount, updatedAccount);
		} catch (Exception e) {
			System.out.println("error during executing test case for CRUD Account");
		} finally {
			if (null != createAccount.getId()) {
				Optional<Account> deleteAccount = accountDao.findById(createAccount.getId());
				accountDao.delete(deleteAccount.get());
				System.out.println("data deleated");
			}

		}

	}

	public Account createAccount() {
		Account account = new Account();
		account.setAccountno((long) 412564888);
		account.setBalance(10000.00);
		account.setOverdraft(100.00);
		return account;
	}

	public Account changeAccount(Account account) {
		account.setAccountno((long) 412564777);
		account.setBalance(11000.00);
		account.setOverdraft(110.00);
		return account;
	}

	public void validateEquals(Account account, Account updatedAccount) {
		assertEquals(account.getAccountno(), updatedAccount.getAccountno());
		assertEquals(account.getBalance(), updatedAccount.getBalance());
		assertEquals(account.getOverdraft(), updatedAccount.getOverdraft());
	}

}
