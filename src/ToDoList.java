import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class ToDoList {
private HashMap<String, Task> tasks = new HashMap<String, Task>();
	public void addTask (Task task) {
		//Add code here
		tasks.put(task.getDescription(), task);
	}
	public void completeTask(String description) {
		// Add code here
		if(getTask(description) != null)
			getTask(description).setComplete(true);
	}
	
	//mingyan
	public boolean getStatus(String description) {
		if(getTask(description) != null)
			return getTask(description).isComplete();
		return false;
	}
	public Task getTask(String description) {
		// Add code here
		if(!tasks.isEmpty())
			return tasks.get(description);
		return null;
	}
	public Task removeTask(String description) {
		// Add code here
		if(!tasks.isEmpty())
			return tasks.remove(description);
		return null;
	}
	public Collection<Task> getAllTasks() {
		return tasks.values();
	}
	public Collection<Task> getCompletedTasks() {
		// Add code here
		return null;
	}
}
