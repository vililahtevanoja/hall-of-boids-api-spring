package fi.lahtevanoja.springtest.card;

import fi.lahtevanoja.springtest.models.Employee;

public class CardEmployeeInfo {
    private String firstName;

    private String lastName;

    private String title;

    CardEmployeeInfo(String firstName, String lastName, String title) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
    }

    CardEmployeeInfo(Employee employee) {
        this.firstName = employee.getFirstName();
        this.lastName = employee.getLastName();
        this.title = employee.getTitle();
    }

    CardEmployeeInfo() {
        this("", "", "");
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
