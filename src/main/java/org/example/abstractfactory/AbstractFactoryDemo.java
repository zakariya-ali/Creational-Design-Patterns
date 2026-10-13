package org.example.abstractfactory;

/**
 * ABSTRACT FACTORY
 * Problem: we need *families* of related objects that must be used together
 * (e.g. Windows button + Windows checkbox, never Windows button + Mac checkbox).
 * Solution: one factory interface with a create method per product; each concrete
 * factory produces a consistent family.
 */
interface Button { void render(); }
interface Checkbox { void render(); }

class WindowsButton implements Button {
    public void render() { System.out.println("Rendering Windows button"); }
}
class WindowsCheckbox implements Checkbox {
    public void render() { System.out.println("Rendering Windows checkbox"); }
}
class MacButton implements Button {
    public void render() { System.out.println("Rendering Mac button"); }
}
class MacCheckbox implements Checkbox {
    public void render() { System.out.println("Rendering Mac checkbox"); }
}

interface GuiFactory {
    Button createButton();
    Checkbox createCheckbox();
}

class WindowsFactory implements GuiFactory {
    public Button createButton() { return new WindowsButton(); }
    public Checkbox createCheckbox() { return new WindowsCheckbox(); }
}

class MacFactory implements GuiFactory {
    public Button createButton() { return new MacButton(); }
    public Checkbox createCheckbox() { return new MacCheckbox(); }
}

// Client code depends only on the abstract factory and abstract products
class Application {
    private final Button button;
    private final Checkbox checkbox;

    Application(GuiFactory factory) {
        this.button = factory.createButton();
        this.checkbox = factory.createCheckbox();
    }

    void render() {
        button.render();
        checkbox.render();
    }
}

public class AbstractFactoryDemo {
    public static void run() {
        System.out.println("=== Abstract Factory ===");
        String os = "mac"; // could come from config or System.getProperty("os.name")
        GuiFactory factory = os.equals("mac") ? new MacFactory() : new WindowsFactory();
        new Application(factory).render();
    }
}
