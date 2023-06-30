package UITestng;

import UITestng.UITestUtil.UITestMethods;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Login;
import util.OpenUrl;

import static UITestng.UITestUtil.UITestMethods.enabilityCheck;
import static UITestng.UITestUtil.UITestMethods.visibilityCheck;

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
}
