import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

/**
 * Created by itayl on 21/06/2017.
 */

public class OnlineFlightsTest {
    private static WebDriver driver;
    private static String CHROME_EXECUTABLE_PATH = "C:\\Users\\itayl\\Documents\\devFiles\\chromedriver.exe";
    final static private Logger log=Logger.getLogger(OnlineFlightsTest.class.getSimpleName());
    //Set up chromedriver according to path
    public static void setUp() {System.setProperty("webdriver.chrome.driver", CHROME_EXECUTABLE_PATH);}

    public static void main(String[] args) throws IOException {

        //Initializing file
        PrintWriter myFile = null;

        driver = new ChromeDriver();
        //my page object
        FlightsPage flightsPage = new FlightsPage(driver);

        //i represent page index.
        int i;
        try {
            while (true) {
                i=1;
                driver.get("http://www.iaa.gov.il/he-IL/airports/BenGurion/Pages/OnlineFlights.aspx");
                try {
                    myFile = new PrintWriter("flights.txt");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                while (flightsPage.isButtonAppear()) {
                    log.info("Fetching page "+i);
                    flightsPage.saveFlightsFromPageToFile(myFile);
                    if (flightsPage.isButtonAppear()) {
                        flightsPage.clickNextButton();
                        i++;
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                }
                log.info("Fetching page "+i);
                flightsPage.saveFlightsFromPageToFile(myFile);
                log.info("Saving file with info from"+ i+ "pages");
                myFile.close();
                try {
                    //wait 5 minutes for refetch
                    Thread.sleep(60 * 1000 * 5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

