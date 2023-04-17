package seleniumTestProject.model;

public class ContactData {
    private final String name;
    private final String secondName;
    private final String lastName;
    private final String nickname;
    private final String title;
    private final String company;
    private final String address;
    private final String home;
    private final String mobile;
    private final String work;
    private final String fax;
    private final String email;
    private final String homepage;
    private final String bday;
    private final String bmont;
    private final String byear;
    private final String notes;

    public ContactData(String name, String secondName, String lastName, String nickname, String title, String company,
                       String address, String home, String mobile, String work, String fax, String email,
                       String homepage, String bday, String bmont, String byear, String notes) {
        this.name = name;
        this.secondName = secondName;
        this.lastName = lastName;
        this.nickname = nickname;
        this.title = title;
        this.company = company;
        this.address = address;
        this.home = home;
        this.mobile = mobile;
        this.work = work;
        this.fax = fax;
        this.email = email;
        this.homepage = homepage;
        this.bday = bday;
        this.bmont = bmont;
        this.byear = byear;
        this.notes = notes;
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

    public String getNickname() {
        return nickname;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public String getAddress() {
        return address;
    }

    public String getHome() {
        return home;
    }

    public String getMobile() {
        return mobile;
    }

    public String getWork() {
        return work;
    }

    public String getFax() {
        return fax;
    }

    public String getEmail() {
        return email;
    }

    public String getHomepage() {
        return homepage;
    }

    public String getBday() {
        return bday;
    }

    public String getBmont() {
        return bmont;
    }

    public String getByear() {
        return byear;
    }

    public String getNotes() {
        return notes;
    }
}
