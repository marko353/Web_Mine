package pages;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;
    public String baseURL = "https://react-blog-code-test-vladan.vercel.app/auth/login";

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void openBaseURL() {
        driver.get(baseURL);
    }

    public void waitForVisibility(By elementBy) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementBy));
    }

    public void click(By elementBy) {
        waitForVisibility(elementBy);
        driver.findElement(elementBy).click();
    }

    public void writeText(By elementBy, String text) {
        waitForVisibility(elementBy);
        driver.findElement(elementBy).clear();
        driver.findElement(elementBy).sendKeys(text);
    }

    public void assertTextEquals(String expected, By elementBy) {
        waitForVisibility(elementBy);
        WebElement element = driver.findElement(elementBy);
        String actual = element.getText();
        Assert.assertEquals(expected, actual);
    }

    public int countItems(By elementBy) {
        waitForVisibility(elementBy);
        return driver.findElements(elementBy).size();
    }
    public void assertElementIsVisible(By elementBy) {
        WebElement element = driver.findElement(elementBy);
        wait.until(ExpectedConditions.visibilityOf(element));
        System.out.println("Element is present on the page.");
        Assert.assertTrue("Element is not visible", element.isDisplayed());
    }
 
    
}
