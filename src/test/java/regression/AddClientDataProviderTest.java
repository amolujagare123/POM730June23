package regression;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
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
    public void adddClientTest(
          String name  ,String surname  ,String language  ,String add1  ,String add2  ,
          String city  ,String state  ,String zip  ,String country  ,String gender  ,
          String birthdate  ,String phone  ,String fax  ,String mobile  ,String email  ,
          String web  ,String vat  ,String tax, String expected,String xpathActual
    ) throws ParseException {
        Menu menu = new Menu(driver);
        menu.clickAddClient();

        AddClient addClient = new AddClient(driver);

        addClient.setClientName(name);
        addClient.setClientSurname(surname);
        addClient.setLanguage(language);
        addClient.setClientAddress1(add1);
        addClient.setClientAddress2(add2);
        addClient.setClientCity(city);
        addClient.setClientState(state);
        addClient.setClientZip(zip);
        addClient.setCountry(country);
        addClient.setGender(gender);
        addClient.setDate1(birthdate);
        addClient.setClientPhone(phone);
        addClient.setClientFax(fax);
        addClient.setClientMobile(mobile);
        addClient.setClientEmail(email);
        addClient.setClientVatId(vat);
        addClient.setClientTaxCode(tax);
        addClient.clickSave();


        String actual ="";
        try {
            actual = driver.findElement(By.xpath(xpathActual)).getText();
        }
        catch (Exception e)
        {

        }

        System.out.println("actual="+actual);
        System.out.println("expected="+expected);

        Assert.assertEquals(actual,expected,"wrong result");
    }

    @DataProvider
    Object[][] getData() throws IOException {
        return getMyData("Data/Data.xlsx","Sheet1");
    }
}
