import org.junit.*;
import static org.junit.Assert.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TaskTest {

  @Test
  public void Task_instantiatesCorrectly_true() {
    Task myTask = new Task("Mow the lawn");
    assertEquals(true, myTask instanceof Task);
  }

  @Test
  public void Task_instantiatesWithDescription_String() {
    Task myTask = new Task("Mow the lawn");
    assertEquals("Mow the lawn", myTask.getDescription());
  }

  @Test
  public void isCompleted_isFalseAfterInstantiation_false() {
    Task myTask = new Task("Mow the lawn");
    assertEquals(false, myTask.isCompleted());
  }

  @Test
  public void getCreatedAt_instantiatesWithCurrentTime_today() {
    Task myTask = new Task("Mow the lawn");
    assertEquals(LocalDateTime.now().getDayOfWeek(), myTask.getCreatedAt().getDayOfWeek());
  }

  @Test
  public void all_returnsAllInstncesOfTask_true(){
    Task firstTask = new Task("Mow the lawn");
    Task secondTask = new Task("Shoot the neighbors squirrels with rubberbands");
    assertEquals(true, Task.all().contains(firstTask));
    assertEquals(true, Task.all().contains(secondTask));
  }

  @Test
  public void clear_emptiesAllTasksFromArrayList_0() {
    Task myTask = new Task("Empty the garbage");
    Task.clear();
    assertEquals(Task.all().size(), 0);
  }

  @Test
  public void getId_tasksInstantiateWithAnID_1() {
    Task.clear();
    Task myTask = new Task("Mow the lawn");
    assertEquals(1, myTask.getId());
  }

  @Test
  public void find_returnsTaskWithSameId_secondTask() {
    Task firstTask = new Task("Mow the lawn");
    Task secondTask = new Task("Buy groceries");
    assertEquals(secondTask, Task.find(secondTask.getId()));
  }
}
