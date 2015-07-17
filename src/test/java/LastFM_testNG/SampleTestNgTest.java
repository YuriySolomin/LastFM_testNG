package LastFM_testNG;

import LastFM_testNG.pages.*;
import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SampleTestNgTest extends TestNgTestBase {

  private HomePage homePage;
  private LoginPage loginPage;
  private MainPage mainPage;
  private GeneralChartsPage generalChartsPage;
  private TracksPage tracksPage;

  @BeforeMethod
  public void initPageObjects() {
    homePage = page.createPage(HomePage.class);
  }

  @Test
  public void testHomePageHasAHeader() {
    driver.get(baseUrl);
    Assert.assertFalse("".equals(homePage.header.getText()));
  }

  @Test
  public void testLastFMLoginPage() {
    driver.get(baseUrl);
    loginPage = homePage.clickLoginLink();
    loginPage.setLogin("YurijSol");
    loginPage.setPassword("bfubhfwww");
    mainPage = loginPage.clickLoginButton();
    generalChartsPage = mainPage.clickLinkToCharts();
    System.out.println(generalChartsPage.getGeneralCountOfTracks());
    tracksPage = generalChartsPage.clickLinkToTracks();
    tracksPage.clickSwitchToCompact().workWithTracks();
    System.out.println();
  }
}
