//Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float),
// и возвращает введенное значение. Ввод текста вместо числа не должно приводить
// к падению приложения, вместо этого, необходимо повторно запросить у пользователя ввод данных.

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        float number = readFloatInput("Введите дробное число:");
        System.out.println("Введенное число: " + number);
    }

    public static float readFloatInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        float number;

        while (true) {
            try {
                System.out.print(prompt + " ");
                number = Float.parseFloat(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат числа. Повторите ввод.");
            }
        }

        return number;
    }
}