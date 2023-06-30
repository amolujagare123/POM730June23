package pages;

import org.joda.time.DateTime;
import org.joda.time.Months;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddClient {
    @FindBy(xpath = "//input[@id='client_name']")
    WebElement clientName;
    @FindBy(xpath = "//input[@id='client_surname']")
    WebElement clientSurname;
    @FindBy(xpath = "//input[@id='client_address_1']")
    WebElement clientAddress1;
    @FindBy(xpath = "//input[@id='client_address_2']")
    WebElement clientAddress2;
    @FindBy(xpath = "//input[@id='client_city']")
    WebElement clientCity;
    @FindBy(xpath = "//input[@id='client_state']")
    WebElement clientState;
    @FindBy(xpath = "//input[@id='client_zip']")
    WebElement clientZip;
    @FindBy(xpath = "//input[@id='client_phone']")
    WebElement clientPhone;
    @FindBy(xpath = "//input[@id='client_fax']")
    WebElement clientFax;
    @FindBy(xpath = "//input[@id='client_mobile']")
    WebElement clientMobile;
    @FindBy(xpath = "//input[@id='client_email']")
    WebElement clientEmail;
    @FindBy(xpath = "//input[@id='client_vat_id']")
    WebElement clientVatId;
    @FindBy(xpath = "//input[@id='client_tax_code']")
    WebElement clientTaxCode;

    @FindBy(xpath = "//button[@id='btn-submit']")
    WebElement btnSave;

    public void clickSave()
    {
        btnSave.click();
    }
    @FindBy(xpath = "")
    WebElement save;

    @FindBy (id = "select2-client_language-container")
    WebElement containerLanguage;
    @FindBy(xpath = "//input[@role='searchbox']")
    WebElement searchBox;
    public void setLanguage(String language)
    {
        containerLanguage.click();
        searchBox.sendKeys(language);
        driver.findElement(By.xpath("//li[normalize-space()='"+language+"']")).click();
    }

    @FindBy (id = "select2-client_country-container")
    WebElement containerCountry;

    public void setCountry(String country)
    {
        containerCountry.click();
        searchBox.sendKeys(country);
        driver.findElement(By.xpath("//li[normalize-space()='"+country+"']")).click();
    }


    @FindBy (id = "select2-client_gender-container")
    WebElement containerGender;

    public void setGender(String gender)
    {
        containerGender.click();
        driver.findElement(By.xpath("//li[normalize-space()='"+gender+"']")).click();
    }

    @FindBy(xpath="//input[@id='client_birthdate']")
    WebElement birthdate;

    public void setDate1(String setDateStr) throws ParseException {
       // birthdate.sendKeys(setDateStr);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('value','"+setDateStr+"')",birthdate);

    }
    public void setDate(String setDateStr) throws ParseException {
        birthdate.click();

        Date setDate = new SimpleDateFormat("dd/MM/yyyy").parse(setDateStr);

        String currDateStr = driver.findElement(By.xpath("//th[@class='datepicker-switch']")).getText();
        Date currDate = new SimpleDateFormat("MMMM yyyy").parse(currDateStr);

        int monthDiff = Months.monthsBetween(new DateTime(currDate).withDayOfMonth(1)
                ,new DateTime(setDate).withDayOfMonth(1)).getMonths();
        System.out.println("monthDiff="+monthDiff);

        boolean flag = true;
        if(monthDiff<0)
        {
            flag = false;
            monthDiff = monthDiff * (-1);
        }

        for (int i=0;i<monthDiff;i++)
        {
            if (flag)
                driver.findElement(By.xpath("//th[@class='next']")).click();
            else
                driver.findElement(By.xpath("//th[@class='prev']")).click();
        }

        String dayStr = new SimpleDateFormat("dd").format(setDate);

        System.out.println("dayStr="+dayStr);
        int day = Integer.parseInt(dayStr);
        System.out.println("day="+day);
        driver.findElement(By.xpath("//td[@class='day'][normalize-space()='"+day+"']")).click();
    }

    public void setClientName(String name)
    {
        clientName.sendKeys(name);
    }

    public void setClientSurname(String surname) {
        clientSurname.sendKeys(surname);
    }

    public void setClientAddress1(String address) {
        clientAddress1.sendKeys(address);
    }

    public void setClientAddress2(String address) {
        clientAddress2.sendKeys(address);
    }

    public void setClientCity(String city) {
        clientCity.sendKeys(city);
    }

    public void setClientState(String state) {
        clientState.sendKeys(state);
    }

    public void setClientZip(String zip) {
        clientZip.sendKeys(zip);
    }

    public void setClientPhone(String phone) {
        clientPhone.sendKeys(phone);
    }

    public void setClientFax(String fax) {
        clientFax.sendKeys(fax);
    }

    public void setClientMobile(String mobile) {
        clientMobile.sendKeys(mobile);
    }

    public void setClientEmail(String email) {
        clientEmail.sendKeys(email);
    }

    public void setClientVatId(String vatId) {
        clientVatId.sendKeys(vatId);
    }

    public void setClientTaxCode(String taxCode) {
        clientTaxCode.sendKeys(taxCode);
    }

    WebDriver driver;

    public AddClient(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath="//input[@id='client_web']")
    WebElement webAddress;

    @FindBy(xpath="//input[@id='client_active']")
    public WebElement active;
    public void setWebAddress(String web) {
       webAddress.sendKeys(web);
    }

}
