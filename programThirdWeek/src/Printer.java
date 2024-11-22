import java.util.Scanner;

public class Printer {
    private final Scanner scanner = new Scanner(System.in);

    public void printMessage(String message) {
        System.out.println(message);
    }

    public String readInput() {
        printMessage("Введите строку или 'выход' для выхода: ");
        return scanner.nextLine();
    }
}
