package LastFM_testNG;

import LastFM_testNG.database.hibernate.activity.BandsImpl;
import LastFM_testNG.database.hibernate.activity.HistoryImpl;
import LastFM_testNG.database.hibernate.activity.SongsImpl;
import LastFM_testNG.database.hibernate.logic.Bands;
import LastFM_testNG.database.hibernate.logic.History;
import LastFM_testNG.database.hibernate.logic.Songs;
import LastFM_testNG.pages.*;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SampleTestNgTest extends BaseAuthTests {

  private HomePage homePage;
  private LoginPage loginPage;
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
    public void calc() {
        System.out.println(mainPage.getTitle());
        driver.get("http://www.last.fm/ru/user/YurijSol/library");
        TracksPage tracksPage = page.createPage(TracksPage.class);
        tracksPage = tracksPage.clickSelectedDiagramm("2008");
        tracksPage.clickSelectedDiagramm("May 2008");
    }

  @Test
  public void addHistory() {
      driver.get(baseUrl);
      loginPage = homePage.clickLoginLink();
      loginPage.setLogin("YurijSol");
      loginPage.setPassword("bfubhfwww");
      mainPage = loginPage.clickLoginButton();
      generalChartsPage = mainPage.clickLinkToCharts();
      long count = generalChartsPage.getGeneralCountOfTracks();
      long pages = count/50 + 1;
      //tracksPage = generalChartsPage.clickLinkToTracks();
      driver.get("http://www.lastfm.ru/user/YurijSol/tracks?view=compact&page=" + pages);
      tracksPage = page.createPage(TracksPage.class);

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
      bands1.addObject(bands);
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
      long count = generalChartsPage.getGeneralCountOfTracks();
      long pages = count/50 + 1;
      //tracksPage = generalChartsPage.clickLinkToTracks();
      driver.get("http://www.lastfm.ru/user/YurijSol/tracks?view=compact&page=" + pages);
      tracksPage = page.createPage(TracksPage.class);
      List<History> historyList = tracksPage.clickSwitchToCompact().workWithTracks();
      for (History history: historyList) {
          HistoryImpl history1 = new HistoryImpl();
          history1.addHistory(history);
      }
      System.out.println();
  }

}
