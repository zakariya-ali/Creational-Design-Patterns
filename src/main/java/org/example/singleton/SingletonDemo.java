package org.example.singleton;

/**
 * SINGLETON
 * Problem: some objects must exist exactly once (config, logger, connection pool).
 * Solution: private constructor + a static access method returning the single instance.
 * Uses the "holder" idiom: lazy and thread-safe without synchronized.
 */
class AppConfig {
    private String environment = "dev";

    private AppConfig() {
        System.out.println("AppConfig created (happens only once)");
    }

    // The JVM loads Holder only when getInstance() is first called -> lazy + thread-safe
    private static class Holder {
        private static final AppConfig INSTANCE = new AppConfig();
    }

    public static AppConfig getInstance() { return Holder.INSTANCE; }

    public String getEnvironment() { return environment; }
    public void setEnvironment(String environment) { this.environment = environment; }
}

public class SingletonDemo {
    public static void run() {
        System.out.println("=== Singleton ===");
        AppConfig a = AppConfig.getInstance();
        AppConfig b = AppConfig.getInstance();

        a.setEnvironment("prod");
        System.out.println("b sees environment = " + b.getEnvironment());
        System.out.println("Same instance? " + (a == b));
    }
}
