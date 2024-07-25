package org.common;

import java.util.Objects;

public class Customer
{
    private final String id;
    private String firstName;
    private String lastName;
    private String email;
    private String membershipStatus;

    public Customer(String id, String firstName, String lastName, String email, String membershipStatus)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.membershipStatus = membershipStatus;
    }

    public String getId()
    {
        return id;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getMembershipStatus()
    {
        return membershipStatus;
    }

    public void setMembershipStatus(String membershipStatus)
    {
        this.membershipStatus = membershipStatus;
    }

    @Override
    public String toString()
    {
        return "Customer{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", membershipStatus='" + membershipStatus + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id) && Objects.equals(firstName, customer.firstName)
                && Objects.equals(lastName, customer.lastName) && Objects.equals(email, customer.email)
                && Objects.equals(membershipStatus, customer.membershipStatus);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, firstName, lastName, email, membershipStatus);
    }
}
