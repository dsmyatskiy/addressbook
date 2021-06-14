package dto;

import java.util.*;

public class ContactData {
    private final String firstName;
    private final String secondName;
    private final String lastName;
    private final String mobilePhone;

    @Override
    public String toString() {
        return "ContactData{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    private final String secondAddress;
    private String group;
    private Integer id;

    public ContactData(String firstName, String secondName, String lastName, String mobilePhone, String secondAddress, String group) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.mobilePhone = mobilePhone;
        this.secondAddress = secondAddress;
        this.group = group;
        this.id = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    public ContactData(String firstName, String lastName, Integer id) {
        this.firstName = firstName;
        this.secondName = null;
        this.lastName = lastName;
        this.mobilePhone = null;
        this.secondAddress = null;
        this.group = null;
        this.id = id;
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

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
