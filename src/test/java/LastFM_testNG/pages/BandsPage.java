package LastFM_testNG.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: solomin-y
 * Date: 7/17/15
 * Time: 12:33 PM

 */
public class BandsPage extends BasePage {

    @FindBy(css = "tbody tr td.subjectCell a")
    public List<WebElement> listOfBands;

    public BandsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public List<String> getAllBandsNames() {
        List<String> result = new ArrayList<String>();
        for (WebElement element: listOfBands) {
            result.add(element.getText().trim());
        }
        return result;
    }

}
