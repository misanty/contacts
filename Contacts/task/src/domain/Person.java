package domain;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

public class Person extends Contact {
    private String surname;
    private String gender;
    private LocalDate birthdate;

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }


    @Override
    public String getInfo() {

        return "Name: "+getName()+ "Surname: "+getSurname();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {

        this.gender = "F".equalsIgnoreCase(gender) || "M".equalsIgnoreCase(gender) ? gender.toUpperCase() : "[no data]";
    }

    public String getBirthdate() {
        return birthdate != null ? birthdate.toString() : "[no data]";
    }

    public void setBirthdate(String birthdate) {
        try {
            this.birthdate = LocalDate.parse(birthdate);
        } catch (DateTimeParseException exception) {
            this.birthdate = null;
        }
    }

    @Override
    public List<String> possibleFields() {
        return List.of("name","surname","gender","birth date","number");
    }

    @Override
    public boolean checkFieldName(String fieldName) {
        return possibleFields().contains(fieldName);
    }

    @Override
    public String getValueOfFieldName(String fieldName) {

        switch (fieldName) {
            case "surname":
                return getSurname();
            case "name":
                return getName();
            case "gender":
                return getGender();
            case "birth date":
                return getBirthdate();
            case "number":
                return getPhoneNumber();
            default:
                return "";
        }
    }

    @Override
    public boolean changeFieldValue(String fieldName, String value) {

        switch (fieldName) {
            case "surname" : setSurname(value);
            return true;
            case "name" : setName(value); return true;
            case "gender" : setGender(value); return true;
            case "birth date" : setBirthdate(value); return true;
            case "number" : isNumberCorrectIfSoSetNumber(value); return true;
            default: return false;
        }

    }
}
