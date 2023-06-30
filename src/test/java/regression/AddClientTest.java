package regression;

import com.beust.ah.A;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AddClient;
import pages.Login;
import pages.Menu;
import util.DoLogin;

import java.text.ParseException;

public class AddClientTest extends DoLogin {

    @Test
    public void adddClientTest() throws ParseException {
        Menu menu = new Menu(driver);
        menu.clickAddClient();

        AddClient addClient = new AddClient(driver);

     /*   addClient.setLanguage("English");
        addClient.setCountry("India");
        addClient.setGender("Female");*/

       // addClient.setDate("05/11/1985");
     //  addClient.setDate1("05/11/2018");

        addClient.setClientName("John1");
        addClient.setClientSurname("Doe");
        addClient.setLanguage("English");
        addClient.setClientAddress1("123 Main Street");
        addClient.setClientAddress2("Apt 4B");
        addClient.setClientCity("New York");
        addClient.setClientState("NY");
        addClient.setClientZip("12345");
        addClient.setCountry("India");
        addClient.setGender("Female");
        addClient.setDate1("05/11/2018");
        addClient.setClientPhone("555-123-4567");
        addClient.setClientFax("555-987-6543");
        addClient.setClientMobile("555-555-5555");
        addClient.setClientEmail("john.doe@example.com");
        addClient.setClientVatId("ABC123");
        addClient.setClientTaxCode("XYZ789");
        addClient.clickSave();
    }
}
