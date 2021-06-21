package dto;

import java.util.*;

public class ContactData {
    private String firstName;
    private String secondName;
    private String lastName;
    private String mobilePhone;
    private String secondAddress;
    private String group;
    private String home;



    private String work;
    private Integer id;

    @Override
    public String toString() {
        return "ContactData{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, id);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getSecondAddress() {
        return secondAddress;
    }

    public String getGroup() {
        return group;
    }

    public String getWork() {
        return work;
    }

    public String getHome() {
        return home;
    }

    public Integer getId() {
        return id;
    }

    public ContactData withId(Integer id) {
        this.id = id;
        return this;
    }

    public ContactData withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public ContactData withSecondName(String secondName) {
        this.secondName = secondName;
        return this;
    }

    public ContactData withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public ContactData withMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }

    public ContactData withSecondAddress(String secondAddress) {
        this.secondAddress = secondAddress;
        return this;
    }

    public ContactData withGroup(String group) {
        this.group = group;
        return this;
    }

    public ContactData withHome(String home) {
        this.home = home;
        return this;
    }

    public ContactData withWorkPhone(String work) {
        this.work = work;
        return this;
    }
}
