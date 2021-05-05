package domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Organization extends Contact {
    private enum Fields {
        NAME,
        ADDRESS,
        NUMBER;

        @Override
        public String toString() {
            return name().toLowerCase();
        }
    }

    private String address;

    public String getAddress() {
        return address;
    }

    public boolean setAddress(String address) {
        this.address = address;
        return true;
    }


    @Override
    public List<String> possibleFields() {
        //return List.of("name", "address", "number");
        return Stream.of(Fields.values()).map(Fields::toString).collect(Collectors.toList());
    }

    @Override
    public boolean changeFieldValue(String fieldName, String value) {

        Fields fields = Fields.valueOf(fieldName.toUpperCase());


        switch (fields) {
            case NAME:
                return setName(value);

            case NUMBER:
                return isNumberCorrectIfSoSetNumber(value);

            case ADDRESS:
                return setAddress(value);
            default:
                return false;
        }

    }

    @Override
    public boolean checkFieldName(String fieldName) {
        return possibleFields().contains(fieldName);
    }

    @Override
    public String getValueOfFieldName(String fieldName) {
        try {
            Fields fields = Fields.valueOf(fieldName.toUpperCase());
            switch (fields) {
                case NAME:
                    return getName();
                case ADDRESS:
                    return getAddress();
                case NUMBER:
                    return getPhoneNumber();
            }
        } catch (Exception e) {
            return "";
        }
        return "";
    }

    @Override
    public String getShortInfo() {

        return "Name: " + getName() + " Address: " + getAddress();
    }


    @Override
    public String getDetailedInfo() {
        return "Organization name: " + getName() + "\r\n" +
                "Address: " + getAddress() + "\r\n" +
                "Number: " + getPhoneNumber() + "\r\n" +
                "Time created: " + getDateCreated() + "\r\n" +
                "Time last edit: " + getDateEdited() + "\r\n"
                ;
    }
}
