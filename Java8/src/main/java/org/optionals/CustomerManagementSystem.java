package org.optionals;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerManagementSystem
{

    public static void main(String[] args)
    {
        CustomerRepository repository = new CustomerRepository();

        repository.addCustomer(new Customer("Alice", "alice@example.com", null));
        repository.addCustomer(new Customer("Bob", null, "123-456-7890"));
        repository.addCustomer(new Customer("Charlie", "charlie@example.com", "987-654-3210"));

        displayCustomerInfo(repository, "Alice");
        displayCustomerInfo(repository, "Bob");
        displayCustomerInfo(repository, "Charlie");
        displayCustomerInfo(repository, "David"); // Non-existing customer

        System.out.println("\nAll customers:");
        repository.getAllCustomers().forEach(System.out::println);
    }

    private static void displayCustomerInfo(CustomerRepository repository, String name)
    {
        Optional<Customer> customer = repository.findCustomerByName(name);

        System.out.println("\nCustomer Information:");
        customer.ifPresent(c -> {
            System.out.println("Name: " + c.getName());
            System.out.println("Email: " + c.getEmail().orElse("No email provided"));
            System.out.println("Phone Number: " + c.getPhoneNumber().orElse("No phone number provided"));
        });
        if (!customer.isPresent()) {
            System.out.println("Customer " + name + " not found");
        }

    }
}

@AllArgsConstructor
@Getter
@ToString
class Customer
{
    private String name;
    private String email;
    private String phoneNumber;

    public Optional<String> getEmail()
    {
        return Optional.ofNullable(email);
    }

    public Optional<String> getPhoneNumber()
    {
        return Optional.ofNullable(phoneNumber);
    }
}

class CustomerRepository
{
    private final List<Customer> customers = new ArrayList<>();

    public void addCustomer(Customer customer)
    {
        customers.add(customer);
    }

    public Optional<Customer> findCustomerByName(String name)
    {
        return customers.stream()
                .filter(customer -> customer.getName().equalsIgnoreCase(name))
                .findFirst();
    }

    public List<Customer> getAllCustomers()
    {
        return new ArrayList<>(customers);
    }
}
