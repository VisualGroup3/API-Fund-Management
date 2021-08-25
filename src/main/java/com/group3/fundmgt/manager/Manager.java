package com.group3.fundmgt.manager;


import com.group3.fundmgt.fund.Fund;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Manager {
    @Id
    private String employeeId;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String Email;

    @OneToMany(mappedBy = "manager", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    private List<Fund> funds;

    public Manager() { }

    public Manager(String employeeId, String firstName, String lastName, String email, List<Fund> funds) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        Email = email;
        this.funds = funds;
    }


    public String getEmployeeId() {
        return employeeId;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public void setEmail(String email) {
        Email = email;
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

    public List<Fund> getFunds() {
        return funds;
    }

    public void setFunds(List<Fund> funds) {
        this.funds = funds;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", funds=" + funds +
                '}';
    }
}
