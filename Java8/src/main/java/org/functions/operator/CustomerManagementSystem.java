package org.functions.operator;

import org.common.Customer;

import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class CustomerManagementSystem
{

    public static void main(String[] args)
    {
        // Sample data
        List<Customer> customerList = Arrays.asList(
                new Customer("1", "john", "doe", "john.doe@example.com", ""),
                new Customer("2", "jane", "smith", "jane.smith@example.com", "Premium"),
                new Customer("3", "ALICE", "JOHNSON", "alice.johnson@example.com", null));

        // UnaryOperator to mask email
        UnaryOperator<Customer> maskEmail = customer ->
        {
            customer.setEmail(CustomerUtils.maskEmail(customer.getEmail()));
            return customer;
        };

        // UnaryOperator to normalize names
        UnaryOperator<Customer> normalizeNames = customer ->
        {
            customer.setFirstName(CustomerUtils.capitalizeName(customer.getFirstName()));
            customer.setLastName(CustomerUtils.capitalizeName(customer.getLastName()));
            return customer;
        };

        // UnaryOperator to set default membership status
        UnaryOperator<Customer> setDefaultMembershipStatus = customer ->
        {
            customer.setMembershipStatus(CustomerUtils.setDefaultMembershipStatus(customer.getMembershipStatus()));
            return customer;
        };

        // Process customer profiles: mask email, normalize names, and set default membership status
        List<Customer> processedCustomerList = customerList.stream()
                .map(maskEmail.andThen(normalizeNames).andThen(setDefaultMembershipStatus))
                .collect(Collectors.toList());

        System.out.println("Processed Customer Profiles:");
        processedCustomerList.forEach(System.out::println);
    }
}
