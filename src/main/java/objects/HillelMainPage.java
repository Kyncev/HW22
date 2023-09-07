package objects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ScreenS;

import java.util.ArrayList;
import java.util.List;

public class HillelMainPage {
    @FindBy(xpath = "//button[@data-dropdown-trigger=\"coursesMenu\"]")
    WebElement courseButton;
    @FindBy(xpath = "//div[@id=\"coursesMenuSearchField\"]//input[@class=\"search-field_input\"]")
    WebElement searchField;
    @FindBy(xpath = "//div[@id=\"coursesMenuDesktop\"]//div[@class=\"courses-nav \"]//ul[@class=\"course-list\"]//p[@class=\"course-label_name\"]")
    List<WebElement> lableNames;

    public boolean openCourseFrame() {
        courseButton.click();
        return searchField.isDisplayed();
    }

    WebDriver driver;

    public HillelMainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public List<String> getVariablesSearch(String searchVariable) throws InterruptedException {
        List<String> list = new ArrayList<>();
        ScreenS.getWebElementPNG(searchField, driver, "Search");
        searchField.clear();
        searchField.sendKeys(searchVariable);
        Thread.sleep(4000);
        for (WebElement l : lableNames) {
            list.add(l.getText());
        }
        return list;
    }
}