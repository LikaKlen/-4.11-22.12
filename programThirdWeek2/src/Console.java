import java.util.Scanner;

public class Console {
    private final Scanner scanner = new Scanner(System.in);

    public String readInput(String message) {
        System.out.println(message + " (Введите 'выход' для выхода):");
        String input = scanner.nextLine().trim();
        if (input.equalsIgnoreCase("выход")) {
            System.out.println("Программа завершена.");
            System.exit(0);
        }
        return input;
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public <T> void displayList(String message, Iterable<T> list) {
        System.out.print(message);
        for (T item : list) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
