package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import manager.DriverManager;

public class RunnerHooks {

    @Before
    public void setupDriver() {
        DriverManager.getDriver();
    }

    @After
    public void quitDriver() {
        DriverManager.quitDriver();
    }

}
