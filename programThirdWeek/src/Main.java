public class Main {
    public static void main(String[] args){
        Printer printer = new Printer();
        while (true) {
            try {
                String input = printer.readInput();
                if ("выход".equalsIgnoreCase(input)) {
                    printer.printMessage("Выход из программы.");
                    break;
                }
                AnalyzerTexts analyzer = new AnalyzerTexts(input);

                printer.printMessage(String.format("""
                        В данном тексте:
                        Кол-во слов: %d
                        Кол-во букв: %d
                        Кол-во гласных: %d
                        Кол-во согласных: %d
                        Кол-во знаков препинания: %d
                        Кол-во пробелов: %d
                        Кол-во числа: %d
                        """,
                        analyzer.countWords(),
                        analyzer.countLetters(),
                        analyzer.countVowels(),
                        analyzer.countConsonants(),
                        analyzer.countPunctuation(),
                        analyzer.countSpaces(),
                        analyzer.countNumber()//Если пользователь вводит текст с датой или другим любым числом, для подсчета количесвта чисел
                ));
            } catch (Exception e) {
                printer.printMessage("Ошибка: " + e.getMessage());
            }
        }
    }
}
