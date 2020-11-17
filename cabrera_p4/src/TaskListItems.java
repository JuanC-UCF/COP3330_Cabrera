public class TaskListItems {
    private String title;
    private String description;
    private String dueDate;
    private Boolean completed;









    public TaskListItems(String title, String description, String dueDate, Boolean completed)   {



                this.title = title;



        this.dueDate = dueDate;
        this.description = description;
        this.completed = completed;






    }






/*
    public static boolean isValidDueDate(String dueDate){

        if(dueDate.length()==8 && dueDate.indexOf("-")==4 && dueDate.lastIndexOf("-")==7){

            try{
                Integer.parseInt(dueDate.replace("-", "0"));
            } catch (NumberFormatException e) {
               return false;
            }


        }
        else{
            return false;
        }
        return true;
    }
*/
    public String getTitle(){
        return this.title;
    }

    public String getDescription(){
        return this.description;
    }

    public String getDueDate(){
        return this.dueDate;
    }

    public Boolean getCompleted(){
        return this.completed;
    }

    class InvalidTitleException extends IllegalArgumentException {
        public InvalidTitleException(String msg) {
            super(msg);
        }
    }




}
