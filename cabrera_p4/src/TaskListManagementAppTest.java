
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class TaskListManagementAppTest {



    @Test
    public void creatATaskwithitems() {
        assertDoesNotThrow(() -> new TaskListItems("Task 1", "Task", "2000-01-01", false));
    }
    @Test
    public void creatATaskwithitems_nodiscription() {
        assertDoesNotThrow(() -> new TaskListItems("Task 1", "", "2000-01-01", false));
    }

    @Test
    public void test_opens_file() {

        assertDoesNotThrow(() ->  TaskList.loadFileTest("SampleFile.txt")  );
    }

    @Test
    public void test_try_open_file() {

        assertThrows(TaskList.InvalidFileException.class,() -> TaskList.loadFileTest("SamplFile.txt"));
    }




/*
    @Test
    public void SimulateUserInputRun(){



        String[] input = {"1","1"};
        for (String inLine : input) {
            InputStream in = new ByteArrayInputStream(inLine.getBytes());
            System.setIn(in);
        }
        InputStream in = new ByteArrayInputStream("8".getBytes());
        System.setIn();
        in = new ByteArrayInputStream("8".getBytes());
        System.setIn(in);
        System.lineSeparator();
        in = new ByteArrayInputStream("1 %n 8".getBytes());
        System.setIn(in);

create new lines between input


        input = "Task 1";
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        TaskListManagementApp.main(new String[]{"null"});
        //assertThrows(TaskListItems.InvalidTitleException.class,() -> TaskList//.editCompleted(5));

}
*/


}