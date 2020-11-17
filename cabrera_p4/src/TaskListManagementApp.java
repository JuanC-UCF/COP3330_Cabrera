import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;


public class TaskListManagementApp {
    private static Scanner input = new Scanner(System.in);
    private TaskList tasks;

    public TaskListManagementApp(){
        tasks = new TaskList();
    }

    public static boolean testListSize(int selection, int size){

        try{
        if(selection <= size && selection >=0){
            return true;
        }
        else{
            throw new InvalidTaskException("task not there");
        }}
        catch(InvalidTaskException ex){
        System.out.print("Warning: your choice does not exist, please double check it and try again");
    }
        return false;
}


    public static boolean testOptionIsCorrectlyInputed(String rawIn, int listSize) {
         try {
             int check = Integer.parseInt(rawIn);
            if(check <= listSize){
            return true;
        }
         else{
            throw new InvalidTaskException("item not there");
        }}
        catch (NumberFormatException ex){

            System.out.print("Warning: your choice does not exist on menue, please double check it and try again: ");

        }
         catch (InvalidTaskException ex){
             System.out.print("Warning: your choice does not exist on menue, please double check it and try again: ");
         }
        return false;
    }


    class InvalidTitleException extends IllegalArgumentException {
        public InvalidTitleException(String msg) {
            super(msg);
        }
    }
    static class InvalidTaskException extends IllegalArgumentException {
        public InvalidTaskException(String msg) {
            super(msg);
        }
    }
    class InvalidDateException extends IllegalArgumentException {
        public InvalidDateException(String msg) {
            super(msg);
        }
    }
    public void taskManageAppWriting(){
        printMainMenu();
        String tempState = readRawInput();
        while(!(tempState.contains("3")) && testOptionIsCorrectlyInputed(tempState,3)) {


            if(Integer.parseInt(tempState)==2){
                System.out.print("Enter the filename to load:");
                String name =askFileName();
                if(tasks.loadFileTest(name))
                    tasks.loadFileIntoTaskList(name);

            }







        while(!tempState.contains("8")){


            while(testOptionIsCorrectlyInputed(tempState,8)&& !(Integer.parseInt(tempState)==8)){
                printMenu();
                tempState =readRawInput();


            if(tempState.startsWith("1")) {
                tasks.veiwList();
            }
            else if(tempState.startsWith("2")){
                TaskListItems items = getTaskListItems();
                storeTaskListItems(items);
            }
            else if(tempState.startsWith("3")){
                try {
                    tasks.veiwList();
                    System.out.print("Which task will you edit?");
                    int temp = Integer.parseInt(readRawInput());
                    if(testListSize(temp, tasks.getSize()))
                    getEditItems(temp);
                    else throw new InvalidTaskException("task");
                }
                catch(InvalidTaskException ex){
                    System.out.print("Warning: your choice does not exist, please double check it and try again");
                }

            }
            else if(tempState.startsWith("4")){
                try {
                    tasks.veiwList();
                    System.out.print("Which task will you remove?");
                    int temp = Integer.parseInt(readRawInput());

                    if(temp < tasks.getSize())
                    tasks.removeItem(temp);
                    else throw new InvalidTaskException("task");
                }
                catch(InvalidTaskException ex){
                    System.out.print("Warning: your choice does not exist, please double check it and try again");
                }


            }
            else if(tempState.startsWith("5")){
                try {
                    tasks.veiwList();
                    System.out.print("Which task will you mark as completed?");
                    int temp = Integer.parseInt(readRawInput());
                    if(temp < tasks.getSize())
                        tasks.editCompleted(temp);
                    else throw new InvalidTaskException("task");

                }
                catch(InvalidTaskException ex){
                    System.out.print("Warning: your choice does not exist, please double check it and try again");
                }
            }
            else if(tempState.startsWith("6")){
                try {
                    tasks.veiwCompletedList();
                    System.out.print("Which task will you unmark as completed?");
                    int temp = Integer.parseInt(readRawInput());
                    if(temp < tasks.getSize())
                        tasks.editNonCompleted(temp);
                    else throw new InvalidTaskException("task");

                }
                catch(InvalidTaskException ex){
                    System.out.print("Warning: your choice does not exist, please double check it and try again");
                }
            }
            else if(tempState.startsWith("7")){

                System.out.print("Enter the filename to save as: ");
                tasks.write(askFileName());

            }
            else if(tempState.startsWith("8")){
                System.out.println("quit");
            }
            else{
                System.out.println("Warning: the option you entered was invalid, try again");
            }


        }



    }printMainMenu();
            tempState = readRawInput();}
            }


    public static String readRawInput(){


        while(!input.hasNext()){

            }
        return input.nextLine();
    }




    public void storeTaskListItems(TaskListItems items){
        tasks.add(items);
    }

    private String askFileName(){
       return input.nextLine();
    }



    public TaskListItems getTaskListItems() {
        TaskListItems items = null;
        while(true) {
            String title = getTaskTitle();
try {

    if (title.length() < 1) {
        throw new InvalidTitleException("title");
    }


                String description = getTaskDescription();

                String dueDate = getTaskDueDate();
                if(!(dueDate.length()==10 && dueDate.indexOf("-")==4 && dueDate.lastIndexOf("-")==7))
                    throw new InvalidDateException("date");


                boolean completed=false;

                items = new TaskListItems(title, description, dueDate, completed);

                break;

        }catch(InvalidTitleException ex) {
    System.out.println("Warning: your title was invalid, please double check it and try again");
}catch(InvalidDateException ex){
    System.out.println("Warning: your date was invalid, please double check it and try again");
}}

return items;
    }





    public void getEditItems(int taskNum){
        TaskListItems editedItems = null;
        String title = getTaskTitle();
        String description = getTaskDescription();
        String dueDate = getTaskDueDate();
        boolean completed=false;
        editedItems = new TaskListItems(title, description, dueDate,completed);

    tasks.editItem(taskNum,editedItems);

    }



    private String getTaskTitle() {
        System.out.print("Task title: ");
        return input.nextLine();
    }

    private String getTaskDescription() {
        System.out.print("Task description: ");
        return input.nextLine();
    }

    private String getTaskDueDate() {
        System.out.print("Task due date (YYYY-MM-DD):");

        return input.nextLine();

    }


    public static void main(String[] args) {
        TaskListManagementApp m = new TaskListManagementApp();

        m.taskManageAppWriting();


    }
    private void printMainMenu(){
        System.out.println("\n"+
                "Main Menu\n" +
                "---------\n" +
                "\n" +
                "1) create a new list\n" +
                "2) load an existing list\n" +
                "3) quit\n");


    }
    private void printMenu(){
        //lazy
        System.out.println("\n"+
                "List Operation Menu\n" +
                "---------\n" +
                "\n" +
                "1) view the list\n" +
                "2) add an item\n" +
                "3) edit an item\n" +
                "4) remove an item\n" +
                "5) mark an item as completed\n" +
                "6) unmark an item as completed\n" +
                "7) save the current list\n" +
                "8) quit to the main menu\n");
    }





}

