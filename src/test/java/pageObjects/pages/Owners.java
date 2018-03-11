package pageObjects.pages;

/**
 * Created by Marek on 11.03.2018.
 */
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class Owners {

    @FindBy(xpath = "//input[@id='firstName']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@id='lastName']")
    private WebElement lastName;

    @FindBy(xpath= "//input[@id='address']")
    private WebElement addressOwner;

    @FindBy(xpath= "//input[@id='city']")
    private WebElement cityOwner;

    @FindBy(xpath= "//input[@id='telephone']")
    private WebElement telephoneOwner;

    @FindBy(xpath = "//a[@href='/owners/new']")
    private WebElement buttonAddingOwner;

    @FindBy(xpath = "//button[@class='btn btn-default'][@type='submit']")
    private WebElement addOwnerSubmitted;
    public WebElement getNameOwner() {
        return nameOwner;
    }

    public WebElement getOwnerInformation() {
        return OwnerInformation;
    }

    @FindBy (xpath = "//h2[contains(text(),'Owner Information')]")
    private WebElement OwnerInformation;

    @FindBy(xpath = "//tbody/tr/td/b")
    private WebElement nameOwner;

    public void buttonToAddOwnerClick(){buttonAddingOwner.click();}
    public void addOwnerClick(){ addOwnerSubmitted.click(); }

    public void setDataForNewOwner(String name, String lastname, String address, String city, String telephone){
        firstName.sendKeys(name);
        lastName.sendKeys(lastname);
        addressOwner.sendKeys(address);
        cityOwner.sendKeys(city);
        telephoneOwner.sendKeys(telephone);

    }

}
