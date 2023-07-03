package UITestng;

import UITestng.UITestUtil.UITestMethods;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Login;
import util.OpenUrl;

import static UITestng.UITestUtil.UITestMethods.*;

public class LoginTest extends OpenUrl {
    public static Login login;
    @BeforeClass
    public void initLogin() {
        login = new Login(driver);
    }

    @Test
    public void txtUsernameVisibilityTest()
    {
        boolean expected = true;
        boolean actual = visibilityCheck(login.txtUsername);
       /* System.out.println("actual="+actual);
        System.out.println("expected="+expected);*/
        Assert.assertEquals(actual,expected,"username textbox is not present");
    }
    @Test
    public void txtPasswordVisibilityTest()
    {
        boolean expected = true;
        boolean actual = visibilityCheck(login.txtPassword);
       /* System.out.println("actual="+actual);
        System.out.println("expected="+expected);*/
        Assert.assertEquals(actual,expected,"password textbox is not present");
    }

    @Test
    public void btnLoginVisibilityTest()
    {
        boolean expected = true;
        boolean actual = visibilityCheck(login.btnLogin);
       /* System.out.println("actual="+actual);
        System.out.println("expected="+expected);*/
        Assert.assertEquals(actual,expected,"login button is not present");
    }

    @Test
    public void txtUsernameEnabilityTest()
    {
        boolean expected = true;
        boolean actual = enabilityCheck(login.txtUsername);
        Assert.assertEquals(actual,expected,"username textbox is not enabled");
    }

    @Test
    public void txtPasswordEnabilityTest()
    {
        boolean expected = true;
        boolean actual = enabilityCheck(login.txtPassword);
        Assert.assertEquals(actual,expected,"password textbox is not enabled");
    }

    @Test
    public void btnLoginEnabilityTest()
    {
        boolean expected = true;
        boolean actual = enabilityCheck(login.btnLogin);
        Assert.assertEquals(actual,expected,"btn login is not enabled");
    }

    @Test
    public void lblEmailSpellCheck()
    {
        String expected = "Email";
        String actual = spellCheck(login.lblEmail);
        Assert.assertEquals(actual,expected,"incorrect spelling");

    }
    @Test
    public void lblPasswordSpellCheck()
    {
        String expected = "Password";
        String actual = spellCheck(login.lblPassword);
        Assert.assertEquals(actual,expected,"incorrect spelling");

    }

    @Test
    public void watermarkEmailCheck()
    {
        String expected = "Email";
        String actual = getAttributeValue(login.txtUsername, "placeholder");
        Assert.assertEquals(actual,expected,"incorrect watermark");
    }

    @Test
    public void watermarkPasswordCheck()
    {
        String expected = "Password";
        String actual = getAttributeValue(login.txtPassword, "placeholder");
        Assert.assertEquals(actual,expected,"incorrect watermark");
    }

    @Test
    public void lblEmailFontSizeCheck()
    {
        String expected = "14px";
        String actual = getStyleValue(login.lblEmail, "font-size");
        System.out.println("expected="+expected+" | actual="+actual);
        Assert.assertEquals(actual,expected,"incorrect font size");
    }

    @Test
    public void lblEmailFontFamilyCheck()
    {
        String expected = "-apple-system, system-ui, BlinkMacSystemFont, \"Segoe UI\", Roboto, \"Helvetica Neue\", Arial, sans-serif";
        String actual = getStyleValue(login.lblEmail, "font-family");
        System.out.println("expected="+expected+" | actual="+actual);
        Assert.assertEquals(actual,expected,"incorrect font size");
    }

    @Test
    public void btnLoginColorCheck()
    {
        String expected = "#2C8EDD";
        String actual = getHexCodeColor(login.btnLogin, "background-color");
        System.out.println("expected="+expected+" | actual="+actual);
        Assert.assertEquals(actual,expected,"incorrect color");
    }
}
