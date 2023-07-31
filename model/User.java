package model;

import java.util.Date;
import java.util.Objects;

/**
 * Класс, представляющий пользователя.
 */
public class User {
    private final String firstName;
    private final String lastName;
    private final String middleName;
    private final Date birthDate;
    private final long phoneNumber;
    private final char gender;

    /**
     * Конструктор класса пользователя.
     *
     * @param firstName  Имя пользователя.
     * @param lastName   Фамилия пользователя.
     * @param middleName Отчество пользователя.
     * @param birthDate  Дата рождения пользователя.
     * @param phoneNumber Номер телефона пользователя.
     * @param gender     Пол пользователя.
     */
    public User(String firstName, String lastName, String middleName,
                Date birthDate, long phoneNumber, char gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    /**
     * Получить имя пользователя.
     *
     * @return Имя пользователя.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Получить фамилию пользователя.
     *
     * @return Фамилия пользователя.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Получить отчество пользователя.
     *
     * @return Отчество пользователя.
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * Получить дату рождения пользователя.
     *
     * @return Дата рождения пользователя.
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * Получить номер телефона пользователя.
     *
     * @return Номер телефона пользователя.
     */
    public long getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Получить пол пользователя.
     *
     * @return Пол пользователя.
     */
    public char getGender() {
        return gender;
    }

    /**
     * Переопределение метода equals() для сравнения объектов класса User.
     * Объекты считаются равными, если все их поля совпадают.
     *
     * @param o Объект, с которым выполняется сравнение.
     * @return true, если объекты равны, иначе - false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return phoneNumber == user.phoneNumber &&
                gender == user.gender &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(middleName, user.middleName) &&
                Objects.equals(birthDate, user.birthDate);
    }

    /**
     * Переопределение метода hashCode() для использования объекта User в коллекциях.
     * Вычисляет хэш-код на основе полей объекта.
     *
     * @return Хэш-код объекта.
     */
    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, middleName, birthDate, phoneNumber, gender);
    }
}
