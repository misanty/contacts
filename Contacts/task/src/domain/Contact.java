package domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Contact implements Serializable {
    private final Pattern phonePattern = Pattern.compile("\\+?" +
            "((\\([0-9A-Za-z]+\\)|[0-9A-Za-z]+)"
            + "|([0-9A-Za-z]+[ -]\\([0-9A-Za-z]{2,}\\))|[0-9A-Za-z]+[ -][0-9A-Za-z]{2,})"
            + "([ -][0-9A-Za-z]{2,}[ -]?)*");

    protected Contact()
    {this.dateCreated = this.dateEdited = LocalDate.now();}

    public String getName() {
        return name;
    }

    public boolean setName(String name) {
        this.name = name;
        return true;
    }

    private String name;

    private String phoneNumber;
    private final LocalDate dateCreated;
    private final LocalDate dateEdited;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    abstract public String getInfo();

    abstract public List<String> possibleFields();

    abstract public boolean changeFieldValue(String fieldName, String value);



    abstract public boolean checkFieldName(String fieldName);

    abstract public String getValueOfFieldName(String fieldName);


    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public LocalDate getDateEdited() {
        return dateEdited;
    }

    public boolean isNumberCorrectIfSoSetNumber(String phoneNumber) {
        boolean returnMatch;
        Matcher matcher = phonePattern.matcher(phoneNumber);
        returnMatch = matcher.matches();
        this.phoneNumber = returnMatch ? phoneNumber : "";
        return returnMatch;
    }




}
