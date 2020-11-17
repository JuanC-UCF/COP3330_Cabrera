import java.io.FileNotFoundException;
import java.util.*;
import java.io.File;

public class TaskList {
    List<TaskListItems> tasks;


    static class InvalidFileException extends IllegalArgumentException {
        public InvalidFileException(String msg) {
            super(msg);
        }
    }
    public TaskList(){

        tasks = new ArrayList<>();
    }

    public void add(TaskListItems items){
        tasks.add(items);
    }
public int getSize(){

        return tasks.size();
}
    public void write(String filename) {
        try(Formatter output = new Formatter(filename)) {
            for(int i = 0; i < tasks.size(); i++) {
                TaskListItems items = tasks.get(i);
                output.format("%s;%s;%s;%s%n", items.getTitle(),items.getDescription(), items.getDueDate(),items.getCompleted());
            }


}


        catch (FileNotFoundException ex) {
            System.out.println("Unable to find the file...");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    static class NotFoundException extends IllegalArgumentException {
        public NotFoundException(String msg) {
            super(msg);
        }
    }

    public void loadFileIntoTaskList(String filename){
        Scanner scan = null;
        try {
            scan = new Scanner(new File(filename));
            scan.useDelimiter(";");
            int count =0;
            while(scan.hasNext()){
                try{
                String title = scan.next();
                String description = scan.next();
                String duedate = scan.next();
                Boolean completed = Boolean.valueOf(scan.next());
                tasks.add(new TaskListItems(title,description,duedate, completed));
            }catch (NoSuchElementException ex){}
            }
        }
        catch(FileNotFoundException ex){
            System.out.println("Unable to find the file...");
            //ex.printStackTrace();
        }
        catch (Exception ex){
            ex.printStackTrace();


        }

    }


    public static boolean loadFileTest(String filename) {

        Scanner scan = null;

        try {
            scan = new Scanner(new File(filename));
            return true;

        }catch (FileNotFoundException ex) {
            System.out.println("Unable to find the file...");
            throw new InvalidFileException("item not there");
          //  ex.printStackTrace();
        } catch (InvalidFileException ex) {
            //ex.printStackTrace();


        }
        return false;
    }









    public void veiwCompletedList(){

        for (int i = 0; i < tasks.size(); i++) {
            TaskListItems items = tasks.get(i);
            if(items.getCompleted()){
            System.out.print(i + ") ");
            System.out.println("[" + items.getDueDate() + "] " + items.getTitle() + ": " + items.getDescription());
        }




    }}

    public void veiwList() {
        System.out.println("Current Tasks\n" +
                "-------------");
        for (int i = 0; i < tasks.size(); i++) {

            TaskListItems items = tasks.get(i);
            System.out.print(i + ") ");
            if(items.getCompleted()) System.out.print(" *** ");
            System.out.println("[" + items.getDueDate() + "] " + items.getTitle() + ": " + items.getDescription());
        }
    }
    public void editItem(int taskNum, TaskListItems edited) {
        tasks.set(taskNum,new TaskListItems(edited.getTitle(),edited.getDescription(),edited.getDueDate(), false));
    }

    public void editCompleted(int taskNum) {
        TaskListItems items = tasks.get(taskNum);
        tasks.set(taskNum,new TaskListItems(items.getTitle(),items.getDescription(),items.getDueDate(), true));
    }



    public void editNonCompleted(int taskNum) {
        TaskListItems items = tasks.get(taskNum);
        tasks.set(taskNum,new TaskListItems(items.getTitle(),items.getDescription(),items.getDueDate(), false));
    }


    public void removeItem(int taskNum){
        tasks.remove(taskNum);

    }

    }


