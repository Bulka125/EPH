public class Person {
    private String surname;
    private String name;
    private String patronymic;
    private String birthDate;
    private String phoneNumber;
    private String gender;

    public Person(String surname, String name, String patronymic, String birthDate, String phoneNumber, String gender) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return surname + " " + name + " " + patronymic + " " + birthDate + " " + phoneNumber + " " + gender;
    }
}
