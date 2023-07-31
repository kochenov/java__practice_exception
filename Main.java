import builder.UserBuilder;
import builder.UserBuilderImpl;
import builder.UserDirector;
import exceptions.InvalidDateFormatException;
import exceptions.InvalidPhoneNumberException;
import model.User;
import utils.FileUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Главный класс приложения для ввода пользовательских данных и создания файлов с информацией.
 */
public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        UserBuilder userBuilder = new UserBuilderImpl();
        UserDirector userDirector = new UserDirector(userBuilder);

        boolean validInput = false;
        String userData = "";

        System.out.println("Введите Фамилию Имя Отчество датуРождения телефон пол, разделенные пробелом:\nПример, Фамилия Имя Очество 19.05.1985 89991112233 m");

        while (!validInput) {
            userData = scanner.nextLine();
            try {
                User user = userDirector.createUser(userData);
                validInput = true;
            } catch (InvalidDateFormatException | ParseException e) {
                showError("Ошибка в формате даты: " + e.getMessage());
            } catch (InvalidPhoneNumberException e) {
                showError("Ошибка в формате номера телефона: " + e.getMessage());
            } catch (Exception e) {
                showError("Произошла непредвиденная ошибка: " + e.getMessage());
            }
        }

        try {
            User user = userDirector.createUser(userData);
            String filename = user.getLastName() + ".txt";
            String formattedPhoneNumber = String.valueOf(user.getPhoneNumber());
            String dataToWrite = user.getLastName() + " " + user.getFirstName() + " " + user.getMiddleName() + " " +
                    new SimpleDateFormat("dd.MM.yyyy").format(user.getBirthDate()) + " " +
                    formattedPhoneNumber + " " + user.getGender() + "\n";
            FileUtils.writeToFile(filename, dataToWrite);
            System.out.println("Данные успешно записаны в файл " + filename);
        } catch (Exception e) {
            showError("Произошла непредвиденная ошибка при сохранении данных в файл: " + e.getMessage());
        }

        scanner.close();
    }

    private static void showError(String message) {
        System.out.println(message);
        System.out.println("Пожалуйста, введите данные заново:");
    }
}
