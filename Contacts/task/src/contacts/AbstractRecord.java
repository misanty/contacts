package contacts;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class AbstractRecord {

    private String name;
    private String phoneNumber = "";
    private boolean hasNumber;
    private final LocalDateTime mDateTimeCreated = LocalDateTime.now();
    private LocalDateTime mDateTimeLastEdit;
    static List<AbstractRecord> recordList = new ArrayList<>();


    public AbstractRecord() {
        recordList.add(this);
    }

    public AbstractRecord(String name, String phoneNumber) {
        setName(name);
        setPhoneNumber(phoneNumber);
        recordList.add(this);
    }

    public static List<AbstractRecord> getRecordList() {
        return recordList;
    }

    public LocalDateTime getDateTimeCreated() {
        return mDateTimeCreated;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return (HasNumber() ? phoneNumber : "[no number]");
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = checkNumberValidity(phoneNumber) ? phoneNumber : "";

    }


    private void setHasNumber() {
        this.hasNumber = !this.phoneNumber.equals("");

    }

    public boolean HasNumber() {
        setHasNumber();
        return hasNumber;
    }

    private boolean checkNumberValidity(String phoneNumber) {

        String pat = "^(\\+?\\(\\d{1,3}\\)()?)[\\-\\s]?((\\d{2,4})|\\d{2,4})[\\-\\s]?(\\d{2,4})[\\-\\s]?(\\d{2,4})[\\-\\s]?([a-zA-Z0-9]{2,4})?$"
                + "|^(\\+?\\d{1,3}( )?)?(\\d{2,4}[\\s\\-]?){1,4}\\d{2,4}$"
                + "|^(\\+\\([a-zA-Z]{2,}\\)[ ]?)$"
                + "|^(\\+?\\d{1,3}?()?)?[- ]((\\(\\d{2,4}\\))|\\d{2,4})[-\\s]?(\\d{2,4}){0,4}$"
                + "|^(\\+?\\d{1,3}( )?)?[\\s-](\\d{2}[ -]?){2}\\d{2}$"
                + "|^(\\+?\\(?\\d{1,3}\\)?)$"
                + "|^(\\+?\\d{1,3}?()?)?[-\\s]((\\(\\d{2,4}\\))|\\d{2,4})[-\\s]?(\\d{2,4})[- ]?(\\d{2,4})[-\\s]?([a-zA-Z0-9]{2,})?$"
                + "|^(\\+?\\(?\\d{1,3}\\)?)[-\\s]?[a-zA-Z]{2,4}$"
                + "|^(\\+?\\d{1,3}( )?)?(\\d{2,4}[\\s\\-]?){1,4}\\d{2,4}[\\s\\-]?[a-zA-Z]{2,}$"
                + "|^(\\+?\\d{1,3}( )?)?(\\d{2,4}[\\s\\-]?){1,4}\\d{2,4}[\\s\\-]?[a-zA-Z]{0,4}[\\s\\-]?\\d{2,}$"
                + "|^(\\+?\\(?\\d{1,3}\\))[\\s\\-]?(\\d{2,4}[- ]?){0,3}$";

        Pattern pattern = Pattern.compile(pat);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }

    public LocalDateTime getDateTimeLastEdit() {
        return mDateTimeLastEdit;
    }

    public void setDateTimeLastEdit(LocalDateTime dateTimeLastEdit) {
        this.mDateTimeLastEdit = dateTimeLastEdit == null ? LocalDateTime.now() : dateTimeLastEdit;
    }

    @Override
    public String toString() {
        return "AbstractRecord{" +
                "name='" + getName() + '\'' +
                ", phoneNumber='" + getPhoneNumber() + '\'' +
                ", hasNumber=" + hasNumber +
                ", mDateTimeCreated=" + mDateTimeCreated +
                ", mDateTimeLastEdit=" + mDateTimeLastEdit +
                '}';
    }
}
