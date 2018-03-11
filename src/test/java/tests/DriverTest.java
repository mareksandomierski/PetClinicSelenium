package tests;

/**
 * Created by Marek on 11.03.2018.
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverTest {

    static final String URL = "http://localhost:8080/owners/find";
    WebDriver driver;

    public void CreateWebdriver (){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Marek\\IdeaProjects\\PetClinicSelenium\\src\\test\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(URL);

    }

    public void closeSession(){
        driver.close();
    }

}
