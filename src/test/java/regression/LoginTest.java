package regression;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.Login;
import util.DoLogin;
import util.OpenUrl;

public class LoginTest extends OpenUrl {

    @Test
    public void loginTest()
    {

        Login login = new Login(driver);
      /*  login.setTxtUsername("amolujagare@gmail.com");
        login.setTxtPassword("admin123");
        login.clickLogin();*/

        login.doLogin("amolujagare@gmail.com","admin123");
    }
}
