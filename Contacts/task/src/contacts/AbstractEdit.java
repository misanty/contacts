package contacts;

public abstract class AbstractEdit {
    enum PersonEdit {
        LASTNAME {
            @Override
            Person editedPerson(String value) {
                mPerson.setLastName(value);
                return mPerson;
            }
        },
        BIRTH {
            @Override
            Person editedPerson(String value) {
                mPerson.setBirthday(value);
                return mPerson;
            }
        },
        GENDER {
            @Override
            Person editedPerson(String value) {
                mPerson.setGender(value);
                return mPerson;
            }
        };

        abstract Person editedPerson(String value);


    }

    enum OrganizationEdit {
        ADDRESS {
            @Override
            Organization editedOrganization(String value) {
                mOrganization.setAddress(value);
                return mOrganization;
            }
        };

        abstract Organization editedOrganization(String value);

    }

    static Person mPerson;
    static Organization mOrganization;

    /**
     *
     * @param person Person data
     * @param personEdit which Person field to edit
     * @param value setting value of the object
     * @return
     */
    public static Person editPerson(AbstractRecord person, PersonEdit personEdit, String value) {
        if (person instanceof Person)
        mPerson = (Person) person;
        personEdit.editedPerson(value);
        return mPerson;
    }

    /**
     *
     * @param organization Organization data
     * @param organizationEdit which organization action to edit
     * @param value  setting value of the object
     * @return
     */
    public static Organization editOrganization(AbstractRecord organization, OrganizationEdit organizationEdit, String value)
    {
        if (organization instanceof Organization)
        mOrganization =(Organization) organization;
        organizationEdit.editedOrganization(value);
        return mOrganization;
    }


}
