package com.mycompany.trollo_gary;

import java.io.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class ConsoleTest {

	public void shouldTakeStringUserInputTestForConsole() 
	{
		Board inputOutput= new Board();

		String input = "Hello";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		assertEquals("Hello", inputOutput.enterString());
	}

}
