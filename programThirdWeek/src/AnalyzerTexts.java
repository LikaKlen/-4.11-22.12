import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AnalyzerTexts {
    private final String inputText;
    private final String VOWELS = "аеёиоуыэюяaeiou";
    private final String PUNCTUATION = ".,!?;:\"()-";

    public AnalyzerTexts(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("Строка не может быть пустой или содержать только пробелы");
        }
        if (Pattern.compile("^[0-9]+$").matcher(input).matches()) {
            throw new IllegalArgumentException("Строка не должна состоять только из цифр");
        }
        if (!Pattern.compile("[a-zA-Zа-яА-Я]").matcher(input).find()) {
            throw new IllegalArgumentException("Строка не должна состоять только из знаков препинания и символов");
        }
        this.inputText = input;
    }

    public int countWords() {
        String[] words = inputText.trim().split("\\s+");
        return words.length;
    }

    public int countLetters() {
        return (int) inputText.chars().filter(Character::isLetter).count();
    }

    public int countVowels() {
        return (int) inputText.toLowerCase().chars().filter(c -> VOWELS.indexOf(c) >= 0).count();
    }

    public int countConsonants() {
        return (int) inputText.toLowerCase().chars()
                .filter(Character::isLetter)
                .filter(c -> VOWELS.indexOf(c) == -1)
                .count();
    }

    public int countPunctuation() {
        return (int) inputText.chars().filter(c -> PUNCTUATION.indexOf(c) >= 0).count();
    }

    public int countSpaces() {
        return (int) inputText.chars().filter(Character::isWhitespace).count();
    }
    public int countNumber(){
        Pattern pattern = Pattern.compile("\\b\\d+\\b");
        Matcher matcher = pattern.matcher(inputText);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }

}
