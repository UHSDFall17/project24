package Group24.Trello;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Test;

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
