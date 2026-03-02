import java.util.ArrayList;
import java.util.Scanner;

public class To_Do {

    public static void main(String[] args) {

        ArrayList<String> tasks = new ArrayList<>();
        ArrayList<Boolean> done = new ArrayList<>();

        Scanner c = new Scanner(System.in);
        int choice;

        while (true) {

            System.out.println("\n=== TO DO LIST ===");
            System.out.println("1) Add Task");
            System.out.println("2) Change Task State");
            System.out.println("3) Delete Task");
            System.out.println("4) Exit");
            System.out.print("Choose: ");

            if (!c.hasNextInt()) {
                System.out.println("Wrong input! Please choose from 1, 2, 3, or 4.");
                c.nextLine();
                continue;
            }

            choice = c.nextInt();
            c.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("How many tasks do you want to add? ");

                    if (!c.hasNextInt()) {
                        System.out.println("Please enter a valid number.");
                        c.nextLine();
                        break;
                    }

                    int count = c.nextInt();
                    c.nextLine();

                    int startIndex = tasks.size();

                    for (int i = 0; i < count; i++) {
                        System.out.print("Enter task " + (i + 1) + ": ");
                        String task = c.nextLine();
                        tasks.add(task);
                    }

                    for (int i = startIndex; i < tasks.size(); i++) {

                        System.out.print("Is task \"" + tasks.get(i) + "\" done? (yes/no): ");
                        String input = c.nextLine().toLowerCase();

                        while (!input.equals("yes") && !input.equals("no")) {
                            System.out.println("Please enter yes or no.");
                            input = c.nextLine().toLowerCase();
                        }

                        boolean status = input.equals("yes");
                        done.add(status);
                    }

                    System.out.println("\n=== Current Tasks ===");
                    for (int i = 0; i < tasks.size(); i++) {
                        String state = done.get(i) ? "Done" : "Not Done";
                        System.out.println((i + 1) + ") " + state + " - " + tasks.get(i));
                    }

                    break;

                case 2:

                    if (tasks.size() == 0) {
                        System.out.println("No tasks available.");
                        break;
                    }

                    for (int i = 0; i < tasks.size(); i++) {
                        String state = done.get(i) ? "Done" : "Not Done";
                        System.out.println((i + 1) + ") " + state + " - " + tasks.get(i));
                    }

                    System.out.print("Enter task number: ");
                    int num = c.nextInt();
                    c.nextLine();

                    if (num >= 1 && num <= tasks.size()) {

                        System.out.print("Enter new state (yes/no): ");
                        String input = c.nextLine().toLowerCase();

                        while (!input.equals("yes") && !input.equals("no")) {
                            System.out.println("Please enter yes or no.");
                            input = c.nextLine().toLowerCase();
                        }

                        boolean newState = input.equals("yes");
                        done.set(num - 1, newState);

                        System.out.println("Updated!");

                    
                        System.out.println("\n=== Updated Tasks ===");
                        for (int i = 0; i < tasks.size(); i++) {
                            String state = done.get(i) ? "Done" : "Not Done";
                            System.out.println((i + 1) + ") " + state + " - " + tasks.get(i));
                        }

                    } else {
                        System.out.println("Wrong number.");
                    }

                    break;

                case 3:

                    if (tasks.size() == 0) {
                        System.out.println("No tasks to delete.");
                        break;
                    }

                    for (int i = 0; i < tasks.size(); i++) {
                        String state = done.get(i) ? "Done" : "Not Done";
                        System.out.println((i + 1) + ") " + state + " - " + tasks.get(i));
                    }

                    System.out.print("Enter task number to delete: ");
                    int deleteNum = c.nextInt();
                    c.nextLine();

                    if (deleteNum >= 1 && deleteNum <= tasks.size()) {
                        tasks.remove(deleteNum - 1);
                        done.remove(deleteNum - 1);
                        System.out.println("Deleted!");

               
                        System.out.println("\n=== Updated Tasks ===");
                        for (int i = 0; i < tasks.size(); i++) {
                            String state = done.get(i) ? "Done" : "Not Done";
                            System.out.println((i + 1) + ") " + state + " - " + tasks.get(i));
                        }

                    } else {
                        System.out.println("Wrong number.");
                    }

                    break;

                case 4:
                    System.out.println("Bye");
                    return;

                default:
                    System.out.println("Please choose from 1, 2, 3, or 4.");
            }
        }
    }
}
