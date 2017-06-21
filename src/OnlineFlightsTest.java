import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by itayl on 21/06/2017.
 */

public class OnlineFlightsTest {
    private static WebDriver driver;
//    private FlightsPage flightsPage=new FlightsPage(driver);
    private static String CHROME_EXECUTABLE_PATH="C:\\Users\\itayl\\Documents\\devFiles\\chromedriver.exe";

    public static void setUp()
    {
        System.setProperty("webdriver.chrome.driver", CHROME_EXECUTABLE_PATH);
    }

    public static void main(String []args) throws IOException
    {

        PrintWriter myFile=null;
        try {
            myFile=new PrintWriter("flights.txt");

        } catch (IOException e) {
            e.printStackTrace();
        }
        driver = new ChromeDriver();
        driver.get("http://www.iaa.gov.il/he-IL/airports/BenGurion/Pages/OnlineFlights.aspx");
        FlightsPage flightsPage=new FlightsPage(driver);


        flightsPage.init();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flightsPage.clickNextButton();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flightsPage.clickNextButton();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flightsPage.clickNextButton();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flightsPage.clickNextButton();

//                flightsPage.saveFlightsFromPageToFile(myFile);
    }
}
