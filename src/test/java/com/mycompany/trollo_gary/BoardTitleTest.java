package com.mycompany.trollo_gary;

import static org.junit.Assert.*;

import org.junit.Test;
import java.io.*;

public class BoardTitleTest {

	@Test
	public void Testinputoutput1(){
		Board b1= new Board();
		String input = "Group24";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		assertEquals("Group24", b1.CreateBoardTitle());
	}

}
