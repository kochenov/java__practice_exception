package builder;

import exceptions.InvalidDateFormatException;
import exceptions.InvalidPhoneNumberException;
import model.User;
import utils.FileUtils;

import java.text.ParseException;

/**
 * Директор, который управляет строителем для создания пользователя.
 */
public class UserDirector {
    private final UserBuilder builder;

    public UserDirector(UserBuilder builder) {
        this.builder = builder;
    }

    /**
     * Метод, который создает пользователя из данных, введенных пользователем.
     * В случае ошибок в формате данных, выбрасывает соответствующее исключение.
     *
     * @param userData Введенные пользователем данные.
     * @return Созданный пользователь.
     * @throws InvalidDateFormatException  Исключение при неверном формате даты.
     * @throws InvalidPhoneNumberException Исключение при неверном формате номера телефона.
     * @throws ParseException             Исключение при ошибке парсинга даты.
     */
    public User createUser(String userData) throws InvalidDateFormatException, InvalidPhoneNumberException, ParseException {
        String[] data = userData.split(" ");
        if (data.length != 6) {
            throw new IllegalArgumentException("Неверное количество данных");
        }

        return builder
                .setLastName(data[0])
                .setFirstName(data[1])
                .setMiddleName(data[2])
                .setBirthDate(data[3])
                .setPhoneNumber(data[4])
                .setGender(data[5].charAt(0))
                .build();
    }
}
