//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.ArrayList;
import java.util.Scanner;


       class Todolistapp {
    static class Task {
        String description;
        boolean isCompleted;

        public  Task(String description) {
            this.description = description;
            this.isCompleted = false;
        }

        public void markAsCompleted() {
            this.isCompleted = true;
        }

        @Override
        public String toString() {
            return (isCompleted ? "[Completed] " : "[Pending] ") + description;
        }
    }

    public static void main(String[] args) {
        ArrayList<Task> tasks = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Todo List App ---");
            System.out.println("1. Add a new task");
            System.out.println("2. View all tasks");
            System.out.println("3. Mark a task as completed");
            System.out.println("4. Delete a task");
            System.out.println("5. Exit");
            System.out.print("Choose an option (1-5): ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter the task description: ");
                    String description = scanner.nextLine();
                    tasks.add(new Task(description));
                    System.out.println("Task added successfully!");
                    break;

                case 2:
                    System.out.println("\n--- Task List ---");
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks available.");
                    } else {
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println((i + 1) + ". " + tasks.get(i));
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter the task number to mark as completed: ");
                    int taskNumToComplete = scanner.nextInt();
                    if (taskNumToComplete > 0 && taskNumToComplete <= tasks.size()) {
                        tasks.get(taskNumToComplete - 1).markAsCompleted();
                        System.out.println("Task marked as completed!");
                    } else {
                        System.out.println("Invalid task number.");
                    }
                    break;

                case 4:
                    System.out.print("Enter the task number to delete: ");
                    int taskNumToDelete = scanner.nextInt();
                    if (taskNumToDelete > 0 && taskNumToDelete <= tasks.size()) {
                        tasks.remove(taskNumToDelete - 1);
                        System.out.println("Task deleted successfully!");
                    } else {
                        System.out.println("Invalid task number.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting Todo List App...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
}




