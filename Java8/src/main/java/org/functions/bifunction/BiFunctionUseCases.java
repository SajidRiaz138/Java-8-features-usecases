package org.functions.bifunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.ToDoubleBiFunction;
import java.util.function.ToIntBiFunction;
import java.util.function.ToLongBiFunction;

public class BiFunctionUseCases
{

    public static void main(String[] args)
    {
        BiFunction<Double, Integer, Double> calculateTotalPrice = (price, quantity) -> price * quantity;

        System.out.println(calculateTotalPrice.apply(3.1, 5));

        BiFunction<String, String, String> combineString = (firstName, lastName) -> firstName + lastName;

        System.out.println(combineString.apply("Sajid", "Riaz"));

        BiFunction<Double, Double, Double> calculateDiscount = (price, discount) -> price - (price * discount / 100);

        System.out.println(calculateDiscount.apply(100.0, 10.0));

        BiFunction<Integer, Integer, Integer> mergeFunction = (value1, value2) -> value1 + value2;

        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("C", 12);
        map2.put("B", 20);

        Map<String, Integer> mergedMap = new HashMap<>();
        map2.forEach((key, value) -> mergedMap.merge(key, value, mergeFunction));
        mergedMap.forEach((k, v) -> System.out.println(k + "-" + v));

        BiFunction<String, String, Boolean> validate = (input, pattern) -> input.matches(pattern);
        String input = "89898976";
        String pattern = "\\d+";
        System.out.println(validate.apply(input, pattern));

        BiFunction<double[], double[], Double> calculateDistance = (p1, p2) ->
        {
            double x = p2[0] - p1[0];
            double y = p2[1] - p1[1];
            return Math.sqrt(x * x + y * y);
        };

        double[] point1 = { 1.0, 2.0 };
        double[] point2 = { 4.0, 6.0 };
        System.out.println("Distance: " + calculateDistance.apply(point1, point2));

        BiFunction<List<String>, List<String>, List<String>> mergeList = (list1, list2) ->
        {

            List<String> mergedList = new ArrayList<>();

            int size = Math.min(list1.size(), list2.size());

            for (int i = 0; i < size; i++)
            {
                mergedList.add(list1.get(i) + list2.get(i));
            }
            return mergedList;
        };

        List<String> list1 = Arrays.asList("Apple", "Banana", "Cherry");
        List<String> list2 = Arrays.asList("Pie", "Split", "Tart");
        List<String> combinedList = mergeList.apply(list1, list2);
        combinedList.forEach(System.out::println);

        BiFunction<User, Account, UserAccount> mergeObjects =
                (user, account) -> new UserAccount(user.name, user.age, account.accountNumber);
        User user = new User(" sleepy joe", 81);
        Account account = new Account("Do not know. He sleeps 24/7");
        System.out.println(mergeObjects.apply(user, account));

        ToIntBiFunction<Integer, Integer> totalItemsInStock = (qtyPerItem, totalItems) -> qtyPerItem * totalItems;
        System.out.println("Total Items in Stock: " + totalItemsInStock.applyAsInt(10, 7));
        ToLongBiFunction<Double, Double> totalDistanceCovered = (speed, time) -> (long) (speed * time);
        System.out.println("Total Distance covered " + totalDistanceCovered.applyAsLong(39.0, 4600.9));
        ToDoubleBiFunction<Integer, Integer> averageScore = (score1, score2) -> (score1 + score2) / 2.0;
        System.out.println("Average Score: " + averageScore.applyAsDouble(34, 56));
    }
}

class User
{
    String name;
    int age;

    User(String name, int age)
    {
        this.name = name;
        this.age = age;
    }
}

class Account
{
    String accountNumber;

    Account(String accountNumber)
    {
        this.accountNumber = accountNumber;
    }
}

class UserAccount
{
    String name;
    int age;
    String accountNumber;

    UserAccount(String name, int age, String accountNumber)
    {
        this.name = name;
        this.age = age;
        this.accountNumber = accountNumber;
    }

    @Override
    public String toString()
    {
        return "UserAccount{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", accountNumber='" + accountNumber + '\'' +
                '}';
    }
}
