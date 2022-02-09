package com.suntech;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.suntech.dao.BranchDao;
import com.suntech.dao.BranchDao;
import com.suntech.domain.Branch;
import com.suntech.domain.Atm;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class BranchTest {

	@Autowired
	private BranchDao branchDao;

	@Test
	public void testBranch() {
		Branch createBranch = createBranch();

		try {

			Branch insertedBranch = branchDao.save(createBranch);
			System.out.println("Data saved");
			// validating created atm inserted atm.
			validateEquals(createBranch, insertedBranch);

			Branch changeBranch = changeBranch(insertedBranch);
			// validating after updting the data
			Branch updatedBranch = branchDao.save(createBranch);
			System.out.println("Data updated");
			validateEquals(changeBranch, updatedBranch);
		} catch (Exception e) {
			System.out.println("error during executing test case for CRUD Branch");
		} finally {
			if (null != createBranch.getId()) {
				Optional<Branch> deleteBranch = branchDao.findById(createBranch.getId());
				branchDao.delete(deleteBranch.get());
				System.out.println("data deleated");
			}

		}

	}

	public Branch createBranch() {
		Branch branch = new Branch();
		branch.setType("Local");
		branch.setLocation("Davangere");
		return branch;
	}

	public Branch changeBranch(Branch branch) {
		branch.setType("LCorporate");
		branch.setLocation("Harihar");
		return branch;
	}

	public void validateEquals(Branch Branch, Branch updatedBranch) {
		assertEquals(Branch.getId(), updatedBranch.getId());
		assertEquals(Branch.getType(), updatedBranch.getType());
		assertEquals(Branch.getLocation(), updatedBranch.getLocation());
	}

}
