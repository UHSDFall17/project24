package com.mycompany.trollo_gary;;

import org.junit.Test;
import java.io.*;
import static org.junit.Assert.*;

public class BoardPrivacyTest {

	@Test
	public void Testinputoutput1(){
		Board b1= new Board();
		String input = "Public";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		assertEquals("Public", b1.SetPrivacy());
	}

	@Test
	public void Testinputoutput2(){
		Board b1= new Board();
		String input = "Private";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		assertEquals("Private", b1.SetPrivacy());
	}

	@Test
	public void Testinputoutput3(){
		Board b1= new Board();
		String input = "Public";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		assertEquals("Public", b1.SetPrivacy());
	}

	@Test
	public void Testinputoutput4(){
		Board b1= new Board();
		String input = "NULL";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		assertEquals("NULL", b1.SetPrivacy());
	}

}