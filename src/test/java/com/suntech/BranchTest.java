package com.suntech;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.suntech.dao.BranchDao;
import com.suntech.domain.Branches;
import com.suntech.utils.BranchUtils;

/**
 * @author Sachin
 *
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class BranchTest {

	@Autowired
	private BranchDao branchDao;

	@Test
	public void testBranch() {
		Branches createBranch = BranchUtils.createBranch();

		try {

			Branches insertedBranch = branchDao.save(createBranch);
			System.out.println("Data saved");
			// validating created atm inserted atm.
			validateEquals(createBranch, insertedBranch);

			Branches changeBranch = BranchUtils.changeBranch(insertedBranch);
			// validating after updting the data
			Branches updatedBranch = branchDao.save(createBranch);
			System.out.println("Data updated");
			validateEquals(changeBranch, updatedBranch);
		} catch (Exception e) {
			System.out.println("error during executing test case for CRUD Branch");
		} finally {
			if (null != createBranch.getId()) {
				Optional<Branches> deleteBranch = branchDao.findById(createBranch.getId());
				branchDao.delete(deleteBranch.get());
				System.out.println("data deleated");
			}

		}

	}

	public void validateEquals(Branches Branch, Branches updatedBranch) {
		assertEquals(Branch.getId(), updatedBranch.getId());
		assertEquals(Branch.getType(), updatedBranch.getType());
		assertEquals(Branch.getLocation(), updatedBranch.getLocation());
	}

}
