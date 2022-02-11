package com.suntech;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.suntech.dao.InsuranceDao;
import com.suntech.domain.Insurance;
import com.suntech.utils.InsuranceUtils;

/**
 * @author Sachin
 *
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class InsuranceTest {

	@Autowired
	private InsuranceDao ida;

	@Test
	public void testInsurance() {
		Insurance ic = InsuranceUtils.createInsurance();
		try {
			Insurance ii = ida.save(ic);

			System.out.println("Data Saved");

			// validate created insurance and inserted insurance
			validateEquals(ic, ii);

			Insurance ci = InsuranceUtils.changeInsurance(ii);
			System.out.println("Data updated successfully");
			Insurance ui = ida.save(ci);
			System.out.println("Data saved success");
			validateEquals(ci, ui);
		} catch (Exception e) {
			System.out.println("Creating insurance has encountered a problem ;( ");
		} finally {
			if (null != ic.getId()) {
				Optional<Insurance> di = ida.findById(ic.getId());
				ida.delete(di.get());
				System.out.println("Insurance deleted successfully");
			}
		}

	}

	public void validateEquals(Insurance i, Insurance ic) {
		assertEquals(i.getIssuing_company(), ic.getIssuing_company());
		assertEquals(i.getPremium_payment(), ic.getPremium_payment());
		assertEquals(i.getTerm(), ic.getTerm());
		assertEquals(i.getType(), ic.getType());
	}
}
