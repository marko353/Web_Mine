package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.netty.handler.timeout.TimeoutException;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    By userName = By.cssSelector("input[name=\"username\"]");
    By passwordField = By.cssSelector("input[name=\"password\"]");
    By signInButton = By.xpath("//*[@id=\"root\"]/div/div/button");
    By buttonPost = By.xpath("/html/body/div/div/div/div[1]/button");

    public LoginPage enterUsername(String text) {
        writeText(userName, text);
        return this;
    }

    public LoginPage enterPassword(String text) {
        writeText(passwordField, text);
        return this;
    }

    public LoginPage clickSignInButton() {
        click(signInButton);
        return this;
    }

    public LoginPage clickOnUsernameField() {
        click(userName);
        return this;
    }

    public LoginPage verifyThatUserSeesPostPage() {
        try {
            WebElement postButton = wait.until(ExpectedConditions.visibilityOfElementLocated(buttonPost));

            if (postButton.isDisplayed()) {
                System.out.println("Button is visible.");
            } else {
                System.out.println("Button is not visible.");
            }
        } catch (TimeoutException e) {
            System.out.println("Timeout: Button is not visible.");
        }

        return this;
    }

    public LoginPage verifyUrlNotChanged(String originalUrl) {
        try {
            wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(originalUrl)));

            System.out.println("URL has not changed.");
        } catch (TimeoutException e) {
            System.out.println("Timeout: URL has changed.");
        }

        return this;
    }

}
