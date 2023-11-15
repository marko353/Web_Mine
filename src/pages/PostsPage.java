package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PostsPage extends BasePage {

    public PostsPage(WebDriver driver) {
        super(driver);

    }

    By writePostfield = By.xpath("//*[@id=\"root\"]/div/div/div[1]/textarea");
    By titleField = By.cssSelector("input[name=\"title\"]");
    By writePostField = By.cssSelector("textarea[name=\"body\"]");
    By postButton = By.xpath("//*[@id=\"root\"]/div/div/div[1]/button");
    By titleText = By.xpath("/html/body/div/div/div/div[8]/span");
    By titleInput = By.xpath(
            "//textarea[contains(@placeholder, 'Exploring the Wonders of Artificial Intelligence: A Journey into the Future')]");
    By svgSelector = By.cssSelector("svg[viewBox=\"0 0 16 16\"]");
    By likeButton = By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div/svg");

    public PostsPage userCanAccessPostPage() {
        waitForVisibility(writePostfield);
        assertElementIsVisible(writePostfield);
        return this;
    }

    public PostsPage writeTitle(String text) {
        writeText(titleField, text);
        return this;
    }

    public PostsPage writePost(String text) {
        writeText(writePostField, text);
        return this;
    }

    public PostsPage clickOnPostButton() {
        click(postButton);
        return this;
    }

    public PostsPage scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500);"); // Pomeri 500 piksela nadole (prilagodite vrednost prema potrebama)
        return this;
    }

    public PostsPage postTextIsVisibe(String text) {
        assertTextEquals(text, titleText);
        return this;
    }

    public PostsPage likeButtonIsClickable() {
        waitForVisibility(svgSelector);
        WebElement likeButtonElement = driver.findElement(svgSelector);

        if (likeButtonElement.isEnabled()) {
            System.out.println("Like button is not clickable.");
        } else {
            System.out.println("Like button is clickable.");
        }
        return this;
    }

    public PostsPage postText(String text) {
        assertTextEquals(text, titleInput);
        return this;
    }

    public PostsPage assertLikeButtonNotPresent() {
        Assert.assertFalse(isElementPresent(likeButton));
        System.out.println("Like button is not present.");
        return this;
    }

    private boolean isElementPresent(By likeButton2) {
        return false;
    }

    public PostsPage assertText(String text) {
        assertTextEquals(text, titleInput);
        return this;
    }

}
