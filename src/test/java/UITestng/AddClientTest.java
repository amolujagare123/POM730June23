package UITestng;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AddClient;
import pages.Login;
import pages.Menu;
import util.DoLogin;

import static UITestng.UITestUtil.UITestMethods.selectionCheck;

public class AddClientTest extends DoLogin {

    public static AddClient addClient;
    @BeforeClass
    public void initAddClient() {
        addClient = new AddClient(driver);
        Menu menu = new Menu(driver);
        menu.clickAddClient();
    }

    @Test
    public void activeCheckBoxSelectionTest()
    {
        boolean expected = true;
        boolean actual = selectionCheck(addClient.active);
        Assert.assertEquals(actual,expected,"password textbox is not present");
    }

}
