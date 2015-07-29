package LastFM_testNG;

import LastFM_testNG.database.hibernate.activity.BandsImpl;
import LastFM_testNG.database.hibernate.activity.SongsImpl;
import LastFM_testNG.database.hibernate.logic.Bands;
import LastFM_testNG.database.hibernate.logic.Songs;
import LastFM_testNG.pages.*;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

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
  public void addAllBandsToDatabase() {
    driver.get(baseUrl);
    loginPage = homePage.clickLoginLink();
    loginPage.setLogin("YurijSol");
    loginPage.setPassword("bfubhfwww");
    mainPage = loginPage.clickLoginButton();
    generalChartsPage = mainPage.clickLinkToCharts();
    List<String> allBandsNames = generalChartsPage.clickLinkToCharts().getAllBandsNames();
    for (String name: allBandsNames) {
      Bands bands = new Bands();
      bands.setNameBand(name);
      BandsImpl bands1 = new BandsImpl();
      bands1.addBand(bands);
    }
  }

  @Test
  public void addAllSongsToDatabase() {
    driver.get(baseUrl);
    loginPage = homePage.clickLoginLink();
    loginPage.setLogin("YurijSol");
    loginPage.setPassword("bfubhfwww");
    mainPage = loginPage.clickLoginButton();
    generalChartsPage = mainPage.clickLinkToCharts();
    List<Songs> allSongsObjects = generalChartsPage.clickLinkToChartsTracks().getAllSongs();
    for (Songs song: allSongsObjects) {
      SongsImpl songs = new SongsImpl();
      songs.addSong(song);
    }
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
