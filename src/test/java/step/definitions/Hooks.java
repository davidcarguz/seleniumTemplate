package step.definitions;

import core.DriverManager;
import io.cucumber.java8.En;

public class Hooks implements En {

    /**
     * Cucumber hooks implementation.
     */
    public Hooks() {
        DriverManager dm = new DriverManager();
        Before(dm::initiateDriver);
        After(dm::terminateDriver);
    }
}
