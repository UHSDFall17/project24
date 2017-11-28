package Group24.Trello;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Test;



public class BoardPrivacyTest {

	@Test
	public void Testinputoutput1(){
		Board b1= new Board();
		String input = "1";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		assertEquals("Public", b1.SetPrivacy());
	}

	@Test
	public void Testinputoutput2(){
		Board b1= new Board();
		String input = "2";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		assertEquals("Team", b1.SetPrivacy());
	}

	@Test
	public void Testinputoutput3(){
		Board b1= new Board();
		String input = "3";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		assertEquals("Private", b1.SetPrivacy());
	}

	@Test
	public void Testinputoutput4(){
		Board b1= new Board();
		String input = "4";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		assertEquals("NULL", b1.SetPrivacy());
	}


}
