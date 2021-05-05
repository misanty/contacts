class Employee {

    // write fields
    String name;
    String email;
    int experience;

    // write constructor
    public Employee(String name, String email, int experience) {
        this.name = name;
        this.email = email;
        this.experience = experience;
    }
    // write getters

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getExperience() {
        return experience;
    }
}

class Developer extends Employee {

    // write fields
    String mainLanguage;
    String[] skills;

    public Developer(String name, String email, int experience, String mainLanguage, String[] skills) {
        super(name, email, experience);
        this.mainLanguage = mainLanguage;
        this.skills = skills;
    }

    public String getMainLanguage() {
        return mainLanguage;
    }

    public String[] getSkills() {
        return skills;
    }

}

class DataAnalyst extends Employee {

    boolean phd;
    String[] methods;

    public DataAnalyst(String name, String email, int experience, boolean phd, String[] skills) {
        super(name, email, experience);
        this.phd = phd;
        this.methods = skills;
    }

    public boolean isPhd() {
        return phd;
    }

    public String[] getMethods() {
        return methods;
    }
}