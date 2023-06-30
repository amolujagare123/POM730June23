package UITestng.UITestUtil;

import org.openqa.selenium.WebElement;


public class UITestMethods  {

    public static boolean visibilityCheck(WebElement element)
    {
        boolean actual = false;
        try {
            actual = element.isDisplayed();
        }
        catch (Exception e)
        {

        }
        return actual;
    }

    public static boolean enabilityCheck(WebElement element)
    {
        boolean actual = false;
        try {
            actual = element.isEnabled();
        }
        catch (Exception e)
        {

        }
        return actual;
    }

    public static boolean selectionCheck(WebElement element)
    {
        boolean actual = false;
        try {
            actual = element.isSelected();
        }
        catch (Exception e)
        {

        }
        return actual;
    }
}
