package org.functions.supplier;

import java.util.function.Supplier;

public class Common
{
    // Helper method to create a cached supplier
    public static <T> Supplier<T> createCachedSupplier(Supplier<T> originalSupplier)
    {
        return new Supplier<T>()
        {
            private T value;

            @Override
            public T get()
            {
                if (value == null)
                {
                    value = originalSupplier.get();
                }
                return value;
            }
        };
    }

    // Helper method to create a dynamic supplier
    public static <T> Supplier<T> createDynamicSupplier(Supplier<T> supplier1, Supplier<T> supplier2)
    {
        return new Supplier<T>()
        {
            private boolean toggle = true;

            @Override
            public T get()
            {
                toggle = !toggle;
                return toggle ? supplier1.get() : supplier2.get();
            }
        };
    }
}
