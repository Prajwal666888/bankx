package com.suntech;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.suntech.dao.CustomerDao;
import com.suntech.domain.Customer;
import com.suntech.utils.DateTimeUtils;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class CustomerTest {

	@Autowired
	private CustomerDao customerDao;

	@Test
	public void testCustomer() {
		Customer createCustomer = createCustomer();
		
		try {
			Customer insertedCustomer = customerDao.save(createCustomer);
			System.out.println("Data saved");
			// validating created Customer inserted Customer.
			validateEquals(createCustomer, insertedCustomer);

			Customer changeCustomer = changeCustomer(insertedCustomer);
			// validating after updating the data
			Customer updatedCustomer = customerDao.save(createCustomer);
			System.out.println("Data updated");
			validateEquals(changeCustomer, updatedCustomer);
		} catch (Exception e) {
			System.out.println("error during executing test case for CRUD Customer");
		} finally {
			if (null != createCustomer.getId()) {
				Optional<Customer> deleteCustomer = customerDao.findById(createCustomer.getId());
				customerDao.delete(deleteCustomer.get());
				System.out.println("data deleated");
			}
		}
	}

	public Customer createCustomer() {
		Customer customer = new Customer();
		customer.setName("James");
		customer.setAccountNo(1212121212l);
		customer.setPanNo("HS10JB33");
		customer.setDob(DateTimeUtils.getDateIn("dd-mm-yyyy", "20-01-1996"));
		return customer;
	}

	public Customer changeCustomer(Customer customer) {
		customer.setName("Scott");
		customer.setAccountNo(132132132l);
		customer.setPanNo("PSO3033");
		customer.setDob(DateTimeUtils.getDateIn("dd-mm-yyyy", "20-01-1989"));
		return customer;
	}

	public void validateEquals(Customer customer, Customer updatedCustomer) {
		assertEquals(customer.getName(),updatedCustomer.getName());
		assertEquals(customer.getAccountNo(),updatedCustomer.getAccountNo());
		assertEquals(customer.getPanNo(),updatedCustomer.getPanNo());
		assertEquals(customer.getDob(),updatedCustomer.getDob());
	}
}
