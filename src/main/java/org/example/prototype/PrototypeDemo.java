package org.example.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * PROTOTYPE
 * Problem: creating an object from scratch is expensive or complex, and we often
 * want "one just like that, with small changes".
 * Solution: objects copy themselves via a copy() method; we clone a prototype
 * instead of building a new one. Note the DEEP copy of the mutable list.
 */
interface Prototype<T> {
    T copy();
}

class Document implements Prototype<Document> {
    private String title;
    private final List<String> pages;

    Document(String title, List<String> pages) {
        this.title = title;
        this.pages = pages;
    }

    @Override
    public Document copy() {
        // deep copy: new list, so changes to the clone don't affect the original
        return new Document(title, new ArrayList<>(pages));
    }

    void setTitle(String title) { this.title = title; }
    void addPage(String page) { pages.add(page); }

    @Override
    public String toString() { return title + " " + pages; }
}

public class PrototypeDemo {
    public static void run() {
        System.out.println("=== Prototype ===");
        Document template = new Document("Invoice Template", new ArrayList<>(List.of("Header", "Footer")));

        Document invoice = template.copy();
        invoice.setTitle("Invoice #42");
        invoice.addPage("Line items");

        System.out.println("Original: " + template);
        System.out.println("Clone:    " + invoice);
    }
}
