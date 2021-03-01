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
    private boolean mHasBirthday;

    public boolean hasBirthday() {
        return mBirthday != null;
    }

    public boolean hasGender() {
        return !mGender.equals(Gender.INVALID);
    }

    private boolean hasGender;

    public String getGender() {
        return !mGender.equals(Gender.INVALID) ? mGender.toString() : "[no data]";
    }

    public void setGender(String gender) {

        mGender = ("M".equalsIgnoreCase(gender.trim()) || "F".equalsIgnoreCase(gender.trim())) ? Gender.valueOf(gender.trim().toUpperCase()) : Gender.INVALID;
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
     * @param gender      String Person's gender, could be 'M' or 'F'
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
        return "Name: " + getName() + "\r\n" +
                "Surname: " + getLastName() + "\r\n" +
                "Birth date: " + (getBirthday() != null ? getBirthday() : "[no data]") + "\r\n" +
                "Gender: " + getGender() + "\r\n" +
                "Number: " + super.getPhoneNumber() + "\r\n" +
                "Time created: " + super.getDateTimeCreated() + "\r\n" +
                "Time last edit: " + super.getDateTimeLastEdit()
                ;
    }
}
