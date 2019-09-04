import java.util.Collection;

import org.junit.*;
import org.junit.Test;
import junit.framework.*;


public class ToDoListTest extends TestCase{
	// Define Test Fixtures
	String description;
	String description2;
	ToDoList toDoList;
	Task newTask;
	Task newTask2;
	
	public ToDoListTest() {
		super();
	}
	@Before
	 public void setUp() throws Exception{
		//Initialise Test Fixtures
		description = "description";
		description2 = "description2";
		toDoList = new ToDoList();
		newTask = new Task(description);
		newTask2 = new Task(description2);
	}
	@After
	 public void tearDown() throws Exception{
		// Uninitialise test Fixtures
		description = "";
		description2 = "";
		toDoList = null;
		newTask = null;
		newTask2 = null;
	}

	@Test
	public void testAddTask() {
		assertTrue("Initial Tasks state", toDoList.getAllTasks().isEmpty());
		toDoList.addTask(newTask);
		assertFalse("Tasks should not be empty after addTask", toDoList.getAllTasks().isEmpty());
	}
	@Test
	public void testCompleteTask() {
		toDoList.addTask(newTask);
		assertFalse("Newly added task is incomplete", toDoList.getStatus(description));
		toDoList.completeTask(description);
		assertTrue("Completed newly added task", toDoList.getStatus(description));
	}
	
	@Test
	public void testGetStatus() {
		toDoList.addTask(newTask);
		assertFalse("Status of newly added task is false (incomplete)", toDoList.getStatus(description));
		toDoList.completeTask(description);
		assertTrue("Status of newly added task is true (complete)", toDoList.getStatus(description));
	}
	@Test
	public void testGetTask() {
		assertNull("No Tasks exist yet", toDoList.getTask(description));
		toDoList.addTask(newTask);
		assertSame("One Task has been added", toDoList.getTask(description), newTask);
	}
	@Test
	public void testRemoveTask() {
		assertNull("Cannot remove task as tasks don't exist", toDoList.removeTask(description));
		toDoList.addTask(newTask);
		assertSame("Removed task matches newly added task", toDoList.removeTask(description), newTask);
	}
	@Test
	public void testGetCompletedTasks() {
		toDoList.addTask(newTask);
		toDoList.addTask(newTask2);
		assertNull("No completed tasks exist yet", toDoList.getCompletedTasks());
		toDoList.completeTask(description);
		newTask.setComplete(true);
		assertNotNull("One completed task exists", toDoList.getCompletedTasks());
		//assertTrue("Verified that one task is completed", toDoList.getCompletedTasks().);
	}
}
