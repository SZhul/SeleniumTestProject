package seleniumTestProject.model;

import java.util.Objects;

public class ContactData {

    private int id;
    private String name;
    private String secondName;
    private String lastName;
    private String group;


    public ContactData(int id, String name, String lastName) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
    }

    public ContactData(String name, String lastName) {
        this.id = Integer.MAX_VALUE;
        this.name = name;
        this.lastName = lastName;
    }

    public ContactData(int id, String name, String lastName, String group) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "ContactData{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (!Objects.equals(name, that.name)) return false;
        return Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        return result;
    }


}
