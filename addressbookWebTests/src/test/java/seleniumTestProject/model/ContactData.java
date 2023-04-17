package seleniumTestProject.model;

public class ContactData {
    private String name;
    private String secondName;
    private String lastName;
    private String nickname;
    private String title;
    private String company;
    private String address;
    private String home;
    private String mobile;
    private String work;
    private String fax;
    private String email;
    private String homepage;
    private String bday;
    private String bmont;
    private String byear;
    private String notes;

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

    public ContactData(String name, String secondName, String lastName){
        this.name = name;
        this.secondName = secondName;
        this.lastName = lastName;
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
