import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.*;
import java.util.stream.Collectors;

public class Number {
    private final List<BigInteger> numbers;
    public Number(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("Список не может быть пустым.");
        }
        this.numbers = parseNumbers(input);
        if (this.numbers.isEmpty()) {
            throw new IllegalArgumentException("Список должен содержать хотя бы одно число.");
        }
        if (numbers.size() > 1000) {
            throw new IllegalArgumentException("Список не должен содержать более 1000 чисел.");
        }
    }
    private List<BigInteger> parseNumbers(String input) {
        try {
            return Arrays.stream(input.split("\\s+"))
                    .map(BigInteger::new) // Парсинг через BigInteger
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Список должен содержать только числа, разделенные пробелами.");
        }
    }
    public BigInteger getMax() {
        return numbers.stream().max(BigInteger::compareTo).orElse(BigInteger.ZERO);
    }

    public BigDecimal getAverage() {
        return numbers.stream()
                .map(BigDecimal::new)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .divide(new BigDecimal(numbers.size()), MathContext.DECIMAL64);
    }
    public List<BigInteger> getSorted() {
        return numbers.stream().sorted().collect(Collectors.toList());
    }
    public Set<BigInteger> getUnique() {
        return new TreeSet<>(numbers);
    }
    public List<BigInteger> getNumbers() {
        return numbers;
    }
}
