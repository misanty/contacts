package domain;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

public class Person extends Contact {
    private enum Gender {
        M,
        F,
        INVALID;

        @Override
        public String toString() {
            return name();
        }
    }

    private String surname;
    private Gender gender;
    private LocalDate birthdate;
    private boolean hasGender;
    private boolean hasBirthday;


    public String getSurname() {
        return surname;
    }

    public boolean setSurname(String surname) {
        this.surname = surname;
        return true;
    }

    public boolean setGender(String genderInp) {

        gender = ("M".equalsIgnoreCase(genderInp.trim()) || "F".equalsIgnoreCase(genderInp.trim())) ? Gender.valueOf(genderInp.trim().toUpperCase()) : Gender.INVALID;
        return hasGender();
    }

    public boolean hasGender() {
        return !gender.equals(Gender.INVALID);
    }

    public String getGender() {
        return hasGender() ? gender.toString() : "[no data]";
    }


    public boolean setBirthday(String birthday) {
        try {
            this.birthdate = LocalDate.parse(birthday);
        } catch (DateTimeParseException exception) {
            this.birthdate = null;
        }
        return hasBirthday();
    }

    public boolean hasBirthday() {
        return birthdate != null;
    }

    public LocalDate getBirthday() {
        return birthdate;
    }

    @Override
    public String getShortInfo() {

        return  getName() + " " + getSurname();
    }

    @Override
    public List<String> possibleFields() {
        return List.of("name", "surname", "gender", "birth date", "number");
    }

    @Override
    public boolean checkFieldName(String fieldName) {
        return possibleFields().contains(fieldName);
    }

    @Override
    public String getValueOfFieldName(String fieldName) {

        switch (fieldName) {
            case "name":
                return getName();
            case "surname":
                return getSurname();

            case "gender":
                return getGender();

            case "birth date":
                return getBirthday().toString();

            case "number":
                return getPhoneNumber();
            default: return "";


        }
    }

    @Override
    public boolean changeFieldValue(String fieldName, String value) {

        switch (fieldName) {
            case "name": return setName(value);
            case "surname" : return setSurname(value);
            case "gender" : return setGender(value);
            case "birth date" : return setBirthday(value);
            case "number" : return isNumberCorrectIfSoSetNumber(value);
            default : return false;
        }

    }

    @Override
    public String getDetailedInfo() {
        return "Name: " + getName() + "\r\n" +
                "Surname: " + getSurname() + "\r\n" +
                "Birth date: " + (getBirthday() != null ? getBirthday() : "[no data]") + "\r\n" +
                "Gender: " + getGender() + "\r\n" +
                "Number: " + getPhoneNumber() + "\r\n" +
                "Time created: " + getDateCreated() + "\r\n" +
                "Time last edit: " + getDateEdited()+ "\r\n"
                ;
    }
}
