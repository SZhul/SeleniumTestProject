package seleniumTestProject.model;

public class ContactData {
    private String name;
    private String secondName;
    private String lastName;
    private String group;


    public ContactData(String name, String secondName, String lastName){
        this.name = name;
        this.secondName = secondName;
        this.lastName = lastName;
    }

    public ContactData(String name, String secondName, String lastName, String group){
        this.name = name;
        this.secondName = secondName;
        this.lastName = lastName;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGroup() {
        return group;
    }
}
