import java.util.Scanner;

public class Main1_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите строку: ");
        String input = scanner.nextLine();

        try {
            if (input.isEmpty()) {
                throw new IllegalArgumentException("Пустые строки вводить нельзя!");
            } else {
                System.out.println("Вы ввели: " + input);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}