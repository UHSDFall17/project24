package com.mycompany.trollo_gary;

import static org.junit.Assert.*;

import org.junit.*;

public class PasswordTest {

	@Test
	public void TestPasswordfail1() {
		User u = new User();
		boolean i = u.CheckPassword(new char[]{'D', 'A', 'R', 'T', 'H', 'V', 'A', 'D', 'E', 'R'});
		assertEquals(true, i);
	}
	@Test
	public void TestPasswordfail2() {
		User u = new User();
		boolean i = u.CheckPassword(new char[]{'D', 'A', 'R', 'T', 'H'});
		assertEquals(true, i);
	}
	@Test
	public void TestPasswordRight() {
		User u = new User();
		boolean i = u.CheckPassword(new char[]{'T', 'E', 'C', 'H', 'I','E','S','1'});
		assertEquals(false, i);
	}
}

