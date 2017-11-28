package Group24.Trello;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Test;


public class ConsoleTest {

	@Test
	public void shouldTakeStringUserInputTestForConsole() 
	{
		Board inputOutput= new Board();

		String input = "Hello";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		assertEquals("Hello", inputOutput.enterString());
	}

}
