import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите данные: ");
        String inputData = scanner.nextLine();
        scanner.close();

        String[] dataArr = inputData.split(" ");
        if (dataArr.length != 6) {
            System.out.println("Ошибка: неверное количество данных.");
            return;
        }

        String lastName = dataArr[0];
        String firstName = dataArr[1];
        String middleName = dataArr[2];
        String birthDateStr = dataArr[3];
        String phoneNumStr = dataArr[4];
        String genderStr = dataArr[5];

        try {
            LocalDate birthDate = parseBirthDate(birthDateStr);
            long phoneNum = parsePhoneNum(phoneNumStr);
            Gender gender = parseGender(genderStr);

            String fileName = lastName + ".txt";
            String userData = lastName + firstName + middleName + birthDateStr + " " + phoneNum + gender;

            writeToFile(fileName, userData);
            System.out.println("Данные успешно записаны в файл " + fileName);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл:");
            e.printStackTrace();
        }
    }

    private static LocalDate parseBirthDate(String birthDateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate birthDate = LocalDate.parse(birthDateStr, formatter);
        return birthDate;
    }

    private static long parsePhoneNum(String phoneNumStr) {
        try {
            long phoneNum = Long.parseLong(phoneNumStr);
            if (phoneNum < 0) {
                throw new IllegalArgumentException("неверный формат номера телефона");
            }
            return phoneNum;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("неверный формат номера телефона");
        }
    }

    private static Gender parseGender(String genderStr) {
        if (genderStr.equalsIgnoreCase("f")) {
            return Gender.FEMALE;
        } else if (genderStr.equalsIgnoreCase("m")) {
            return Gender.MALE;
        } else {
            throw new IllegalArgumentException("неверный формат пола");
        }
    }

    private static void writeToFile(String fileName, String userData) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
        writer.append(userData);
        writer.newLine();
        writer.close();
    }

    private enum Gender {
        FEMALE,
        MALE
    }
}