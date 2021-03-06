package LastFM_testNG;

import java.io.IOException;

import LastFM_testNG.pages.BasePage;
import LastFM_testNG.pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Capabilities;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import ru.stqa.selenium.factory.WebDriverFactory;
import ru.stqa.selenium.factory.WebDriverFactoryMode;

import LastFM_testNG.util.PropertyLoader;

/**
 * Base class for TestNG-based test classes
 */
public class TestNgTestBase {

  protected static String gridHubUrl;
  protected static String baseUrl;
  protected static Capabilities capabilities;
  protected BasePage page;

  protected WebDriver driver;


  @BeforeSuite
  public void initTestSuite() throws IOException {
    baseUrl = PropertyLoader.loadProperty("site.url");
    gridHubUrl = PropertyLoader.loadProperty("grid.url");
    if ("".equals(gridHubUrl)) {
      gridHubUrl = null;
    }
    capabilities = PropertyLoader.loadCapabilities();
    WebDriverFactory.setMode(WebDriverFactoryMode.THREADLOCAL_SINGLETON);
  }

  @BeforeMethod
  public void initWebDriver() {
    driver = WebDriverFactory.getDriver(gridHubUrl, capabilities);
    page = new BasePage(driver);
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() {
    WebDriverFactory.dismissAll();
  }
}
