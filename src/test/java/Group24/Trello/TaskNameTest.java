package Group24.Trello;

import static org.junit.Assert.*;

import org.junit.Test;

public class TaskNameTest {

	@Test
	public void Test(){
		task t=new task();
		t.setTask_name("Software design Report3");
		assertEquals("Software design Report3",t.getTask_name());

	}

}
