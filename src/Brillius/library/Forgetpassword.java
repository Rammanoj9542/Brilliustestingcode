package Brillius.library;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Forgetpassword 
{

	private WebDriver driver;

    // Constants
    private static final int MAX_ATTEMPTS = 3;
    private static final int LOCKOUT_TIME_SECONDS = 10; // 10 seconds for demonstration purposes

    @Test
    public void testForgotPasswordWithLockout() {
        // Replace with the actual URL of your "forgot password" page
        String passwordResetUrl = "https://app.brillius.ai/passwordreset";

        // Replace with the actual username you want to test
        String usernameToReset = "Akhilbrillius";

        for (int attempt = 1; attempt <= MAX_ATTEMPTS; attempt++) {
            // Navigate to the forgot password page
            driver.get(passwordResetUrl);

            // Locate and interact with the username input field
            WebElement usernameInput = new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.presenceOfElementLocated(By.name("username")));
            usernameInput.sendKeys(usernameToReset);

            // Submit the form
            usernameInput.sendKeys(Keys.RETURN);

            // Wait for an appropriate amount of time, assuming that the page displays a relevant message
            WebElement errorMessage = new WebDriverWait(driver, 5)
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='error-message']")));

            // Validate the error message
            Assert.assertTrue(errorMessage.getText().contains("Invalid username"),
                    "Error message does not match expected message for attempt " + attempt);

            if (attempt == MAX_ATTEMPTS) {
                // Simulate a lockout scenario
                try {
                    Thread.sleep(LOCKOUT_TIME_SECONDS * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        // Attempt one more time after the lockout period
        driver.get(passwordResetUrl);
        WebElement usernameInput = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.name("username")));
        usernameInput.sendKeys(usernameToReset);
        usernameInput.sendKeys(Keys.RETURN);

        // Wait for an appropriate amount of time, assuming that the page displays a relevant message
        WebElement errorMessage = new WebDriverWait(driver, 5)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='error-message']")));

        // Validate the lockout message
        Assert.assertTrue(errorMessage.getText().contains("Try again after " + LOCKOUT_TIME_SECONDS + " seconds"),
                "Lockout message does not match expected message after lockout period");

        // Additional assertions and test steps can be added as needed
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
	
	
	
	
	
	
}
