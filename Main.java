import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные в формате: Фамилия Имя Отчество датарождения номертелефона пол");
        String input = scanner.nextLine();
        
        try {
            Person person = parseInput(input);
            writeToFile(person);
            System.out.println("Данные успешно записаны в файл.");
        } catch (InvalidInputException | IOException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

    public static Person parseInput(String input) throws InvalidInputException {
        if (input == null) {
            throw new InvalidInputException("Входная строка не должна быть null.");
        }

        String[] parts = input.split(" ");
        if (parts.length != 6) {
            throw new InvalidInputException("Неверное количество данных. Ожидалось 6, а получено " + parts.length);
        }
        
        String surname = parts[0];
        String name = parts[1];
        String patronymic = parts[2];
        String birthDate = parts[3];
        String phoneNumber = parts[4];
        String gender = parts[5];
        
        if (!birthDate.matches("\\d{2}\\.\\d{2}\\.\\d{4}")) {
            throw new InvalidInputException("Неверный формат даты рождения. Ожидался формат dd.mm.yyyy.");
        }
        
        if (!phoneNumber.matches("\\d+")) {
            throw new InvalidInputException("Неверный формат номера телефона. Ожидалось целое число.");
        }
        
        if (!gender.matches("[fm]")) {
            throw new InvalidInputException("Неверный формат пола. Ожидался символ 'f' или 'm'.");
        }
        
        return new Person(surname, name, patronymic, birthDate, phoneNumber, gender);
    }

    public static void writeToFile(Person person) throws IOException {
        String filename = person.getSurname() + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write(person.toString());
            writer.newLine();
        } catch (IOException e) {
            throw new IOException("Ошибка при записи в файл " + filename, e);
        }
    }
}
