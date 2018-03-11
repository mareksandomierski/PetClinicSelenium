package tests;

/**
 * Created by Marek on 11.03.2018.
 */
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.support.PageFactory;
import pageObjects.pages.Owners;
import pageObjects.pages.Waits;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(DataProviderRunner.class)
public class AddOwners extends DriverTest {

    private Owners owners;
    private Waits wait;

    @DataProvider
    public static Object[][] ownersData() {
        return new String[][] {
                new String[]{"Piotr", "Stefanowicz", "Kasztanowa 12", "Gdańsk", "501569485"},
                new String[]{"Stefan", "Zamrzycki", "Buraczana 1", "Sopot", "639852654"},
                new String[]{"Jacek", "Wiśniewski", "Wesoła 11", "Gdynia", "789456258"},
                new String[]{"Monika", "Piotrowska", "Spokojna 6", "Reda", "600256985"}
        };
    }

    @Before
    public void setUp(){

        CreateWebdriver();
        wait = new Waits();
        owners = PageFactory.initElements(driver, Owners.class);
    }

    @Test
    @UseDataProvider("ownersData")
    public void addeddOwnerstest(String Name, String lastName, String address, String city, String telephone){
        owners.buttonToAddOwnerClick();
        owners.setDataForNewOwner(Name, lastName, address,city,telephone);
        owners.addOwnerClick();
        wait.waitForElementToBeVisible(driver, owners.getOwnerInformation());
        assertThat(owners.getNameOwner().getText().contains(Name + " " + lastName));
    }

    @After
    public void tearDown( ){
        closeSession();
    }

}
