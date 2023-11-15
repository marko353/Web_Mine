package tests;

import org.junit.Test;
import pages.LoginPage;
import pages.PostsPage;

public class PostsTest extends BaseTest {

    @Test

    public void verifyThatPostPageIsVisible() {
        LoginPage loginPage = new LoginPage(driver);
        PostsPage postsPage = new PostsPage(driver);

        String username = "kminchelle";
        String password = "0lelplR";

        loginPage.openBaseURL();
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickSignInButton();
        postsPage.userCanAccessPostPage();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test

    public void verifyThatLikeButtonIsClickable() {
        LoginPage loginPage = new LoginPage(driver);
        PostsPage postsPage = new PostsPage(driver);

        String username = "kminchelle";
        String password = "0lelplR";

        loginPage.openBaseURL();
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickSignInButton();
        postsPage.likeButtonIsClickable();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test

    public void verifyThatPostTitleHasBeenAdded() {
        LoginPage loginPage = new LoginPage(driver);
        PostsPage postsPage = new PostsPage(driver);

        String username = "kminchelle";
        String password = "0lelplR";
        String postTitle = "Exploring the Wonders of Artificial Intelligence: A Journey into the Future";
        String post = "Dive into the fascinating world of Artificial Intelligence (AI) as we explore its ever-growing presence in our daily lives. From smart homes to virtual assistants, AI is reshaping the way we live, work, and interact with technology.";

        loginPage.openBaseURL();
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickSignInButton();
        postsPage.writeTitle(postTitle);
        postsPage.writePost(post);
        postsPage.clickOnPostButton();
        postsPage.scrollDown();
        postsPage.postTextIsVisibe(postTitle);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void verifyLikeButtonNotVisibleOnNewPost() {
        LoginPage loginPage = new LoginPage(driver);
        PostsPage postsPage = new PostsPage(driver);

        String username = "kminchelle";
        String password = "0lelplR";
        String postTitle = "Exploring the Wonders of Artificial Intelligence: A Journey into the Future";
        String post = "Dive into the fascinating world of Artificial Intelligence (AI) as we explore its ever-growing presence in our daily lives. From smart homes to virtual assistants, AI is reshaping the way we live, work, and interact with technology.";

        loginPage.openBaseURL();
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickSignInButton();
        postsPage.writeTitle(postTitle);
        postsPage.writePost(post);
        postsPage.clickOnPostButton();
        postsPage.scrollDown();
        postsPage.assertLikeButtonNotPresent();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
 
}
