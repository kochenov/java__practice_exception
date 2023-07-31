package builder;

import exceptions.InvalidPhoneNumberException;
import model.User;

import java.text.ParseException;

/**
 * Интерфейс строителя пользователя.
 */
public interface UserBuilder {
    User build() throws ParseException;
    UserBuilder setFirstName(String firstName);
    UserBuilder setLastName(String lastName);
    UserBuilder setMiddleName(String middleName);
    UserBuilder setBirthDate(String birthDate);
    UserBuilder setPhoneNumber(String phoneNumber) throws InvalidPhoneNumberException;
    UserBuilder setGender(char gender);
}
