package org.functions.operator;

public class CustomerUtils
{

    // Mask part of the email address for privacy
    public static String maskEmail(String email)
    {
        int atIndex = email.indexOf("@");
        if (atIndex > 1)
        {
            return email.charAt(0) + "****" + email.substring(atIndex - 1);
        }
        return email;
    }

    // Normalize names to capitalize the first letter of the first and last names
    public static String capitalizeName(String name)
    {
        if (name == null || name.isEmpty())
        {
            return name;
        }
        return Character.toUpperCase(name.charAt(0)) + name.substring(1).toLowerCase();
    }

    // Set default membership status if not already set
    public static String setDefaultMembershipStatus(String membershipStatus)
    {
        return (membershipStatus == null || membershipStatus.isEmpty()) ? "Basic" : membershipStatus;
    }
}
