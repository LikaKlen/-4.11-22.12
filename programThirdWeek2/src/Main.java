public class Main {
    public static void main(String[] args) {
        Console ui= new Console();
        try {
            Number list1 = getValidatedNumber(ui, "Введите числа для первого списка через пробел:");
            printNumberStats(ui, list1, "Результаты для первого списка:");

            Number list2 = getValidatedNumber(ui, "Введите числа для второго списка через пробел:");
            printNumberStats(ui, list2, "Результаты для второго списка:");

            ListManager manager = new ListManager(list1, list2);
            ui.displayList("Объединенный список: ", manager.getUnion());

        } catch (Exception e) {
            ui.printMessage("Неизвестная ошибка: " + e.getMessage());
            e.printStackTrace();
        }
    }
    private static Number getValidatedNumber(Console ui, String message) {
        while (true) {
            try {
                String input = ui.readInput(message);
                return new Number(input);
            } catch (IllegalArgumentException e) {
                ui.printMessage("Ошибка: " + e.getMessage());
            }
        }
    }
    private static void printNumberStats(Console ui, Number number, String header) {
        ui.printMessage(header);
        ui.printMessage("Максимальное число: " + number.getMax());
        ui.printMessage("Среднее арифметическое: " + number.getAverage());
        ui.displayList("Отсортированный список: ", number.getSorted());
        ui.displayList("Уникальные элементы: ", number.getUnique());
        ui.printMessage("Всего чисел в списке: " + number.getNumbers().size());
    }
}
