import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        ArrayList<Task> tasks = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        int nextId = 1;

        while (running) {
            System.out.println("\n---Task Manager---");
            System.out.println("1. Add Task");
            System.out.println("2. View Task");
            System.out.println("3. Mark Task completed");
            System.out.println("4. Delete Task");
            System.out.println("5. Edit Task title");
            System.out.println("6. Exit");
            System.out.print("choose an option: ");

            int choice;
            try{
                choice = scanner.nextInt();
            }catch (Exception e){
                System.out.println("Invalid input. Please enter a number. ");
                scanner.nextLine(); // clear bad input
                continue;
            }

            if(choice==1) {
                scanner.nextLine();// clear leftover input
                System.out.print("Enter task title:");
                String title = scanner.nextLine();

                tasks.add(new Task(nextId, title));
                nextId++;
                System.out.println("Task added!");
            }else if (choice == 2){
                System.out.print("\n Your task: ");
                if (tasks.isEmpty()) {
                    System.out.println("No tasks yet");
                }else {
                    for(Task task : tasks){
                        System.out.println(task);
                    }

                }
            }else if (choice == 3){
                System.out.println("Enter task ID to mark completed: ");
                int idToComplete = scanner.nextInt();

                boolean found = false;
                for(Task task : tasks){
                    if(task.getId()==idToComplete){
                        task.markCompleted();
                        found = true;
                        break;
                    }
                }
                if (found){
                    System.out.println("Task marked as completed! ");
                }else{
                    System.out.println("Task not found");
                }
            }else if (choice == 4){
                System.out.print("Enter the task id to be deleted");
                int idToDelete = scanner.nextInt();

                Task taskToRemove = null;
                for(Task task:tasks){
                    if(task.getId()== idToDelete){
                        taskToRemove = task;
                        break;
                    }
                }
                if (taskToRemove != null){
                    tasks.remove(taskToRemove);
                    System.out.println("Task deleted");
                }else{
                    System.out.println("Task not found");
                }
            }else if (choice==5){
                System.out.println("Enter the task id to edit");
                int idToEdit = scanner.nextInt();
                scanner.nextLine();

                Task taskToEdit = null;
                for (Task task:tasks){
                    if(task.getId() == idToEdit){
                        taskToEdit = task;
                        break;
                    }
                }
                if(taskToEdit != null){
                    System.out.print("Enter the new title");
                    String newTitle = scanner.nextLine();
                    taskToEdit.setTitle(newTitle);
                    System.out.println("Title updated");

                }else{
                    System.out.println("Title not found");
                }
            }else if (choice == 6){
                running = false;
                System.out.println("GoodBye!");
            }
        }


    }
}