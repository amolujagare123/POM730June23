package UITestng.UITestUtil;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;


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

    public static String spellCheck(WebElement element)
    {
        String actual = "";
        try {
            actual = element.getText();
        }
        catch (Exception e)
        {

        }
        return actual;
    }

    public static String getAttributeValue(WebElement element,String attributeName)
    {
        String actual = "";
        try {
            actual = element.getAttribute(attributeName);
        }
        catch (Exception e)
        {

        }
        return actual;
    }

    public static String getStyleValue(WebElement element,String styleName)
    {
        String actual = "";
        try {
            actual = element.getCssValue(styleName);
        }
        catch (Exception e)
        {

        }
        return actual;
    }

    public static String getHexCodeColor(WebElement element,String styleName)
    {
        String rgbaColor = getStyleValue(element,styleName);
        return Color.fromString(rgbaColor).asHex().toUpperCase();
    }




}
