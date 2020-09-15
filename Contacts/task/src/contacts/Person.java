package contacts;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

public class Person extends AbstractRecord {
   private enum Gender {
        M,
        F,
        INVALID;
       @Override
       public String toString() {
           return name();
       }
    }

    private String mLastName;
    private Gender mGender;
    private LocalDate mBirthday;

    //TODO add some sort of regex to check if birthday is in correct format, although the format is not specified- but it specified by the LocalDate object itself

    public String getGender() {
        return mGender.toString();
    }

    public void setGender(String gender) {

        mGender = ( "M".equals(gender.toUpperCase()) || "F".equals(gender.toUpperCase())) ? Gender.valueOf(gender.toUpperCase()) : Gender.INVALID;
    }

    public LocalDate getBirthday() {
        return mBirthday;
    }

    public void setBirthday(String birthday) {
        try {
            this.mBirthday = LocalDate.parse(birthday);
        } catch (DateTimeParseException exception) {
            this.mBirthday = null;
        }

    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String lastName) {
        mLastName = lastName;
    }

    /**
     * @param name        String Person's name
     * @param lastName    String Person's lastname
     * @param birthday    String Person's birthday in a LocalDate datatype format
     * @param gender      char Person's gender, could be 'M' or 'F'
     * @param phoneNumber String Person's phone number
     */
    public Person(String name, String lastName, String birthday, String gender, String phoneNumber) {
        super(name, phoneNumber);
        setLastName(lastName);
        setGender(gender);
        setBirthday(birthday);

    }

    public Person() {
    }

    @Override
    public void setDateTimeLastEdit(LocalDateTime dateTimeLastEdit) {
        super.setDateTimeLastEdit(dateTimeLastEdit);
    }

    @Override
    public String toString() {
        return "Person{"
                + "Name: " + getName() +

                " LastName= " + mLastName + '\'' +
                ", Gender= " + mGender +
                ", Birthday= " + mBirthday +
                " PhoneNumber: " + getPhoneNumber() +
                '}';
    }
}
