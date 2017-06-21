import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by itayl on 21/06/2017.
 */
abstract class AbsPageObject {

    WebDriver driver;
    long WAIT_FOR_PAGE_TIMEOUT = 5000;

    public AbsPageObject(WebDriver driver_) {
        driver = driver_;
    }
    public void init()
    {
        PageFactory.initElements(driver, this);
    }
}
