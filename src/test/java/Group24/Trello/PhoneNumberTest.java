package Group24.Trello;

import static org.junit.Assert.*;

import org.junit.Test;

public class PhoneNumberTest {

	@Test
	public void phNolengthfail1() {
		User u = new User();
		long num1=u.phnumber(111111111111L);
		assertEquals(-1,num1);
	}

	@Test
	public void phNolengthfail2() {
		User u = new User();
		long num1=u.phnumber(1111111);
		assertEquals(-1,num1);
	}

	@Test
	public void phNolengthpass() {
		User u = new User();
		long num1=u.phnumber(5555555555L);
		assertEquals(5555555555L,num1);
	}
}
