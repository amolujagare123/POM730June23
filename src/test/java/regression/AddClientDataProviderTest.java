package regression;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AddClient;
import pages.Login;
import pages.Menu;

import java.io.IOException;
import java.text.ParseException;

import static DataProvider.util.GetData.getMyData;

public class AddClientDataProviderTest {
    WebDriver driver;
    @BeforeClass
    public void doLogin()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost/ip");

        Login login = new Login(driver);
        login.doLogin("amolujagare@gmail.com","admin123");
    }

    @Test(dataProvider = "getData")
    public void adddClientTest() throws ParseException {
        Menu menu = new Menu(driver);
        menu.clickAddClient();

        AddClient addClient = new AddClient(driver);


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
        addClient.setClientPhone("555-123-4567");
        addClient.setClientFax("555-987-6543");
        addClient.setClientMobile("555-555-5555");
        addClient.setClientEmail("john.doe@example.com");
        addClient.setWebAddress("example.com");
        addClient.setClientVatId("ABC123");
        addClient.setClientTaxCode("XYZ789");
        addClient.clickSave();
    }

    @DataProvider
    Object[][] getData() throws IOException {
        return getMyData("Data/Data.xlsx","Sheet1");
    }
}
