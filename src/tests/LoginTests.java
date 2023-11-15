package tests;

import org.junit.Test;
import pages.LoginPage;

public class LoginTests extends BaseTest {

    @Test
    public void verfySuccessfullyLogin() {
        LoginPage loginPage = new LoginPage(driver);

        String username = "kminchelle";
        String password = "0lelplR";
       

        loginPage.openBaseURL();
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickSignInButton();
        loginPage.verifyThatUserSeesPostPage();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void unSuccessfullyLogin() {
        LoginPage loginPage = new LoginPage(driver);

        String username = "Test123";
        String password = "Test123!";
        String originalUrl = "react-blog-code-test-vladan.vercel.app/auth/login";

        loginPage.openBaseURL();
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickSignInButton();
        loginPage.verifyUrlNotChanged(originalUrl);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
  

}