package LastFM_testNG;

import LastFM_testNG.pages.HomePage;
import LastFM_testNG.pages.LoginPage;
import LastFM_testNG.pages.MainPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

/**
 * Created by solomin-y on 8/19/2015.
 */
public class BaseAuthTests extends TestNgTestBase  {

    private HomePage homePage;
    protected MainPage mainPage;

    @BeforeMethod
    public void auth() {
        driver.get(baseUrl);
        homePage = page.createPage(HomePage.class);
        LoginPage loginPage = homePage.clickLoginLink();
        loginPage.setLogin("YurijSol");
        loginPage.setPassword("bfubhfwww");
        mainPage = loginPage.clickLoginButton();

    }
}
