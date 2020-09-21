package contacts;

import java.time.LocalDateTime;

public class Organization extends AbstractRecord {

        private String address;

        public Organization() {
        }

        /**
         * @param organizationName String name of the organization
         * @param address          String address of the organization
         * @param phoneNumber      String phone number of the organization
         */
        public Organization(String organizationName, String address, String phoneNumber) {
                super(organizationName, phoneNumber);
                setAddress(address);
        }

        public String getAddress() {
                return address;
        }

        public void setAddress(String address) {
                this.address = address;
        }

        @Override
        public void setDateTimeLastEdit(LocalDateTime dateTimeLastEdit) {
                super.setDateTimeLastEdit(dateTimeLastEdit);
        }

        @Override
        public String toString() {
                return "Organization name: " + super.getName() + "\r\n" +
                        "Address: " + getAddress() + "\r\n" +
                        "Number: " + super.getPhoneNumber() + "\r\n" +
                        "Time created: " + super.getDateTimeCreated() + "\r\n" +
                        "Time last edit: " + super.getDateTimeLastEdit()
                        ;
        }
}
