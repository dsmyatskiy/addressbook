package dto;

public class ContactData {
    private final String firstName;
    private final String secondName;
    private final String lastName;
    private final String mobilePhone;
    private final String secondAddress;

    public ContactData(String firstName, String secondName, String lastName, String mobilePhone, String secondAddress) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.mobilePhone = mobilePhone;
        this.secondAddress = secondAddress;
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
}
