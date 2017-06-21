import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.PrintWriter;
import java.util.List;

/**
 * Created by itayl on 21/06/2017.
 */
public class FlightsPage {
    WebDriver driver;
    public WebElement nextButton;
    public WebElement flightsTable;

    public FlightsPage(WebDriver driver_) {
        driver=driver_;
    }
    public void init()
    {
        flightsTable=driver.findElement(By.xpath("//*[@id='board1']"));
        nextButton=driver.findElement(By.id("ctl00_rptPaging_ctl06_aNext"));
    }

    public boolean isButtonAppear()
    {
        return nextButton.isDisplayed();
    }
    public void clickNextButton()
    {
        nextButton.click();
    }

    public void saveFlightsFromPageToFile(PrintWriter myFile)
    {
//        WebElement table=flightsTable;
        List<WebElement> rows=flightsTable.findElements(By.tagName("tr"));
        java.util.Iterator <WebElement> i=rows.iterator();
        while (i.hasNext())
        {
            WebElement row=i.next();
            myFile.println(row.getText());
        }
    }

}
