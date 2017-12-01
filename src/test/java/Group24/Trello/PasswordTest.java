package Group24.Trello;

import static org.junit.Assert.*;

import org.junit.Test;

public class PasswordTest {

	@Test
	public void testPasswordfail1() {
		User u = new User();
		boolean i = u.checkPassword(new char[]{'D', 'A', 'R', 'T', 'H', 'V', 'A', 'D', 'E', 'R'});
		assertEquals(true, i);
	}
	@Test
	public void testPasswordfail2() {
		User u = new User();
		boolean i = u.checkPassword(new char[]{'D', 'A', 'R', 'T', 'H'});
		assertEquals(true, i);
	}
	@Test
	public void testPasswordRight() {
		User u = new User();
		boolean i = u.checkPassword(new char[]{'T', 'E', 'C', 'H', 'I','E','S','1'});
		assertEquals(false, i);
	}

}
