package com.mycompany.trollo_gary;

import org.junit.Test;
import static org.junit.Assert.*;

public class PhoneNumberTest {

	@Test
	public void PhNolengthfail1() {
		User u = new User();
		long num1=u.phnumber(111111111111L);
		assertEquals(-1,num1);
	}

	@Test
	public void PhNolengthfail2() {
		User u = new User();
		long num1=u.phnumber(1111111);
		assertEquals(-1,num1);
	}

	@Test
	public void PhNolengthpass() {
		User u = new User();
		long num1=u.phnumber(5555555555L);
		assertEquals(5555555555L,num1);
	}
}