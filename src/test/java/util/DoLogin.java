package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Login;

import java.io.IOException;

import static util.ConfigReader.getPassword;
import static util.ConfigReader.getUsername;

public class DoLogin extends OpenUrl {

    @BeforeClass
    public void doLogin() throws IOException {
        Login login = new Login(driver);
        login.doLogin(getUsername(),getPassword());
    }
}
