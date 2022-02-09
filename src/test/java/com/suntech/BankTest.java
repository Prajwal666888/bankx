package com.suntech;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.suntech.dao.BankDao;
import com.suntech.domain.Bank;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class BankTest {

	@Autowired
	private BankDao bd;
	

	@Test
	public void testBank() {
		Bank b=createBank();
		try {
			Bank ib=bd.save(b);
			System.out.println("Data saved");
//			compare the created and inserted bank
			validateEquals(b, ib);
			
//			change the inserted Bank 
			Bank cb=changeBank(ib);
//			validate after updating
			Bank cbb=bd.save(cb);
//			compare the strored data and created data
			validateEquals(cb, cbb);
			
		}catch (Exception e) {
			System.out.println("Error during the creation of the banking");
		}finally {
			
			if(null!=b.getId()) {
				Optional<Bank> db=bd.findById(b.getId());
				bd.delete(db.get());
				System.out.println("Bank Record is deleted");
			}
		}
	}
	
	
	private Bank createBank() {
//		Bank b = new Bank("Federal Bank", "Savings Bank", "USA");
		Bank b = new Bank();
		b.setName("Federal Bank");
		b.setType("Savings");
		b.setHead_office("USA");
		return b;
	}
	
	private Bank changeBank(Bank b) {
		b.setName("NYFB");
		b.setType("SB");
		b.setHead_office("UK");
		return b;
		
	}
	
	
	public void validateEquals(Bank b,Bank ub) {
		assertEquals(b.getName(), ub.getName());
		assertEquals(b.getHead_office(), ub.getHead_office());
		assertEquals(b.getType(), ub.getType());
	}
	
}
