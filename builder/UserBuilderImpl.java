package builder;

import exceptions.InvalidDateFormatException;
import exceptions.InvalidPhoneNumberException;
import model.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Реализация интерфейса строителя пользователя.
 */
public class UserBuilderImpl implements UserBuilder {
    private String firstName;
    private String lastName;
    private String middleName;
    private Date birthDate;
    private long phoneNumber;
    private char gender;

    @Override
    public User build() {
        return new User(firstName, lastName, middleName, birthDate, phoneNumber, gender);
    }

    @Override
    public UserBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @Override
    public UserBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @Override
    public UserBuilder setMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    @Override
    public UserBuilder setBirthDate(String birthDate) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            this.birthDate = sdf.parse(birthDate);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Неверный формат даты рождения");
        }
        return this;
    }

    @Override
    public UserBuilder setPhoneNumber(String phoneNumber) throws InvalidPhoneNumberException {
        if (!phoneNumber.matches("[0-9]+") || String.valueOf(phoneNumber).length() != 11) {
            throw new InvalidPhoneNumberException("Неверный формат номера телефона");
        }
        this.phoneNumber = Long.parseLong(phoneNumber);
        return this;
    }

    @Override
    public UserBuilder setGender(char gender) {
        this.gender = gender;
        return this;
    }
}
