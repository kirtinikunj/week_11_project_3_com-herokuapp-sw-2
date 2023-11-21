package test_suite;

import browser_factory.Base_Test;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Write down the following test into ‘LoginTest’ class
 * 1. userSholdLoginSuccessfullyWithValidCredentials
 * * Enter “tomsmith” username
 * * Enter “SuperSecretPassword!” password
 * * Click on ‘LOGIN’ button
 * * Verify the text “Secure Area”
 * <p>
 * <p>
 * 2. verifyTheUsernameErrorMessage
 * * Enter “tomsmith1” username
 * * Enter “SuperSecretPassword!” password
 * * Click on ‘LOGIN’ button
 * * Verify the error message “Your username
 * is invalid!”
 * <p>
 * <p>
 * 3. verifyThePasswordErrorMessage
 * * Enter “tomsmith” username
 * * Enter “SuperSecretPassword” password
 * * Click on ‘LOGIN’ button
 * * Verify the error message “Your password
 * is invalid!”
 */
public class Login_Test extends Base_Test {

    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials() {

        //Enter “tomsmith” username
        driver.findElement(By.id("username")).sendKeys("tomsmith");

        //Enter “SuperSecretPassword!” password
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");

        // Click on ‘LOGIN’ button
        driver.findElement(By.className("fa-sign-in")).click();

        // Verify the text “Secure Area”
        String expectedText = "Secure Area";

        WebElement actualTextElement = driver.findElement(By.xpath("//h2"));
        String actualText = actualTextElement.getText();

        Assert.assertEquals(expectedText, actualText);
        System.out.println("Method 1");
    }

    @Test
    public void verifyTheUsernameErrorMessage() {

        //Enter “tomsmith1” username
        driver.findElement(By.id("username")).sendKeys("tomsmith1");

        // Enter “SuperSecretPassword!” password
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");

        //Click on ‘LOGIN’ button
        driver.findElement(By.className("fa-sign-in")).click();

        //Verify the error message “Your username is invalid!”
        String expectedErrorMessage = " Your username is invalid!";

        String actualErrorMessage = driver.findElement(By.xpath("//div[@id='flash']")).getText();

        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
        System.out.println("Method 2");
    }

    @Test
    public void verifyThePasswordErrorMessage() {

        //Enter “tomsmith” username
        driver.findElement(By.id("username")).sendKeys("tomsmith");

        //Enter “SuperSecretPassword” password
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword");

        //Click on ‘LOGIN’ button
        driver.findElement(By.className("fa-sign-in")).click();

        //Verify the error message “Your password is invalid!”
        String expectedErrorMessage = "Your password is invalid!";
        String actualErrorMessage = driver.findElement(By.xpath("//div[@id='flash']")).getText();

        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
        System.out.println("Method 3");
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
