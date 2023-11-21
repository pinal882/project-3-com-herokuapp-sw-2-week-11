package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    static String baseUrl ="http://the-internet.herokuapp.com/login";

    @Before
    public void setup(){
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Enter 'tomsmith' username
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        //Enter 'supersecretPassword' password
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        //Click on login Button
        driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();
// Verify the "Secure Area"
        String expectedText = "You logged into a secure area!";
        WebElement actualTextElement = driver.findElement(By.xpath("//div[@class='flash success']"));
        String actualText = actualTextElement.getText().substring(0,30);
        Assert.assertEquals(expectedText,actualText);


    }
    @Test
    public void verifyTheUsernameErrorMessage(){
        //Enter 'tomsmith1' username
        driver.findElement(By.id("username")).sendKeys("tomsmith1");
        //Enter “SuperSecretPassword!” password
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        //Click on login button
        driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();
        //verify the error message “Your username is invalid!”
       String expectedText = "Your username is invalid!";
       WebElement actualTextElement = driver.findElement(By.xpath("//div[@class='flash error']"));
        String actualText = actualTextElement.getText().substring(0,25);
       Assert.assertEquals(expectedText,actualText);



    }
@Test
        public void verifyThePasswordErrorMessage(){
        //Enter 'tomsmith' username
    driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");
    //Enter 'SuperSecretPassword' password
    driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword");
    //Click on login button
    driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();
    //verify error message 'your password is invalid!'
    String expectedText = "Your password is invalid!";
    WebElement actualTextElement = driver.findElement(By.xpath("//div[@id='flash']"));
           String actualText = actualTextElement.getText().substring(0,25);
    Assert.assertEquals(expectedText,actualText);

        }
        @After
    public void tearDown(){
       closeBrowser();
        }
    }

