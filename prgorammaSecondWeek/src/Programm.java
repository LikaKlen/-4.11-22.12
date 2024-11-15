import java.util.*;
public class Programm {
    public void startProgram() {
        System.out.println("Введите число: ");
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        List<Integer> sequence = generateRandomSequence(number);
        System.out.println("Все числа последовательности: " + sequence);
        List<Integer> simpleNumbers = findSimpleNumbers(sequence);
        if (!simpleNumbers.isEmpty()) {
            System.out.println("Простые числа в последовательности: " + simpleNumbers);
        } else {
            System.out.println("Простых чисел в последовательности нет.");
        }
    }
    public List<Integer> generateRandomSequence(int number) {
        List<Integer> sequence = new ArrayList<>();
        for (int i = 1; i <= number; i++) {
            sequence.add(i);
        }
        Collections.shuffle(sequence);
        return sequence;
    }
    public List<Integer> findSimpleNumbers(List<Integer> sequence) {
        List<Integer> simpleNumbers = new ArrayList<>();
        for (int num : sequence) {
            if (isSimpleNumber(num)) {
                simpleNumbers.add(num);
            }
        }
        Collections.sort(simpleNumbers);
        return simpleNumbers;
    }
    private boolean isSimpleNumber(int number) {
        if (number < 2) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

}
