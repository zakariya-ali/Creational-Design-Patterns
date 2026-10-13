package org.example.builder;

/**
 * BUILDER
 * Problem: an object with many (often optional) fields leads to huge constructors
 * like new Pizza("large", true, false, true, ...) which are unreadable.
 * Solution: a separate Builder sets fields step by step with named methods,
 * then build() returns the finished (immutable) object.
 */
class Pizza {
    private final String size;      // required
    private final boolean cheese;   // optional
    private final boolean pepperoni;
    private final boolean mushrooms;

    private Pizza(Builder builder) {
        this.size = builder.size;
        this.cheese = builder.cheese;
        this.pepperoni = builder.pepperoni;
        this.mushrooms = builder.mushrooms;
    }

    @Override
    public String toString() {
        return "Pizza{size=" + size + ", cheese=" + cheese
                + ", pepperoni=" + pepperoni + ", mushrooms=" + mushrooms + "}";
    }

    static class Builder {
        private final String size;
        private boolean cheese;
        private boolean pepperoni;
        private boolean mushrooms;

        Builder(String size) { this.size = size; }

        Builder cheese() { this.cheese = true; return this; }
        Builder pepperoni() { this.pepperoni = true; return this; }
        Builder mushrooms() { this.mushrooms = true; return this; }

        Pizza build() { return new Pizza(this); }
    }
}

public class BuilderDemo {
    public static void run() {
        System.out.println("=== Builder ===");
        Pizza pizza = new Pizza.Builder("Large")
                .cheese()
                .pepperoni()
                .build();
        System.out.println(pizza);
    }
}
