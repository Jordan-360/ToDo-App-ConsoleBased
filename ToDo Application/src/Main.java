import java.util.ArrayList;
import java.util.Scanner;

class Main {
    static ArrayList<String> tasks = new ArrayList<>();
    static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
        boolean isRunning = true;
        while(isRunning) {
            printMenu();
            System.out.print("please choose an option: ");
            int input = userInput.nextInt();
            userInput.nextLine();
            while(input <= 0 || input > 4) {
                System.out.print("Please enter a valid option: ");
                input = userInput.nextInt();
            }
            if(input == 1) {
                addTask();
            } else if(input == 2) {
                removeTask();
            } else if(input == 3) {
                displayTasks();
            } else {
                System.out.println("Goodbye!");
                isRunning = false;
            }
        }
    }


    public static void printMenu() {
        System.out.println("----------------");
        System.out.println("1: Add Task     ");
        System.out.println("2: Remove Task  ");
        System.out.println("3: Display Tasks");
        System.out.println("4: Exit         ");
        System.out.println("----------------");
    }

    public static void addTask() {
        System.out.print("Please input a task: ");
        String input = userInput.nextLine().trim();
        while(input.isEmpty()) {
            System.out.print("The task created cannot be empty. Please enter a task: ");
            input = userInput.nextLine().trim();

        }
        System.out.println("Task successfully added!");
        tasks.add(input);
    }

    public static void removeTask() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to remove.");
            return;
        }
        System.out.print("Please enter which task you would like to delete: (1 - " + tasks.size() + "): ");
        String input = userInput.nextLine().trim();

        while(!isValidIndex(input)) {
            System.out.print("Please enter a valid index 1 - " + tasks.size() + ": ");
            input = userInput.nextLine().trim();
        }
        tasks.remove(Integer.parseInt(input) - 1);
        System.out.println("Task successfully deleted!");

    }

    public static void displayTasks() {
        if(tasks.isEmpty()) {
            System.out.println("There are no tasks to display!");
        } else {
            System.out.println("Here are your tasks.");
        }
        listToString(tasks);
    }

    public static void listToString(ArrayList<String> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Task " + (i + 1) + ": " + list.get(i));
        }
    }

    public static boolean isValidIndex(String input) {
        try {
            int index = Integer.parseInt(input);
            return index >= 1 && index <= tasks.size();
        } catch (NumberFormatException e) {
            return false;
        }
    }
}