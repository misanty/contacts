class User {
    private String firstName;
    private String lastName;

    public User() {
        this.firstName = "";
        this.lastName = "";
    }

    public void setFirstName(String firstName) {
        // write your code here
        this.firstName = firstName != null ? firstName : "";
    }

    public void setLastName(String lastName) {
        // write your code here
        this.lastName = lastName != null ? lastName : "";
    }

    public String getFullName() {

        return (!firstName.equals("") || !lastName.equals("")) ?
                (!firstName.equals("") && !lastName.equals("") ? firstName + " " + lastName : (firstName.equals("") ? lastName : firstName)) : "Unknown";


    }
}