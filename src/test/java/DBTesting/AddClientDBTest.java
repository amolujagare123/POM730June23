package DBTesting;

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
import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;

import static DataProvider.util.GetData.getMyData;
import static util.Conversion.*;

public class AddClientDBTest {
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
          String web  ,String vat  ,String tax
    ) throws ParseException, ClassNotFoundException, SQLException {
        Menu menu = new Menu(driver);
        menu.clickAddClient();

        ArrayList<String> expected = new ArrayList<>();
        expected.add(name);
        expected.add(surname);
        expected.add(language.toLowerCase());
        expected.add(add1);
        expected.add(add2);
        expected.add(city);
        expected.add(state);
        expected.add(zip);
        expected.add(country);
        expected.add(gender);
        expected.add(birthdate);
        expected.add(phone);
        expected.add(fax);
        expected.add(mobile);
        expected.add(email);
        expected.add(web);
        expected.add(vat);
        expected.add(tax);


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
        addClient.setWebAddress(web);
        addClient.setClientVatId(vat);
        addClient.setClientTaxCode(tax);
        addClient.clickSave();

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ip"
        ,"root","root");
        Statement st = con.createStatement();
        String sql = "SELECT * FROM ip_clients where client_name='"+name+"'";
        ResultSet rs = st.executeQuery(sql);

        ArrayList<String> actual = new ArrayList<>();

        while (rs.next())
        {
            actual.add(rs.getString("client_name"));
            actual.add(rs.getString("client_surname"));
            actual.add(rs.getString("client_language"));
            actual.add(rs.getString("client_address_1"));
            actual.add(rs.getString("client_address_2"));
            actual.add(rs.getString("client_city"));
            actual.add(rs.getString("client_state"));
            actual.add(rs.getString("client_zip"));

            String shortCountry = rs.getString("client_country");
            String fullCountry = convertCountry(shortCountry);
            actual.add(fullCountry);

          //  actual.add(rs.getString("client_country"));

           // actual.add(rs.getString("client_gender"));


            actual.add(getGender(rs.getString("client_gender")));

            actual.add(getDate(rs.getString("client_birthdate")));
            actual.add(rs.getString("client_phone"));
            actual.add(rs.getString("client_fax"));
            actual.add(rs.getString("client_mobile"));
            actual.add(rs.getString("client_email"));
            actual.add(rs.getString("client_web"));
            actual.add(rs.getString("client_vat_id"));
            actual.add(rs.getString("client_tax_code"));
        }

        st.close();
        con.close();

        System.out.println("actual="+actual);
        System.out.println("expected="+expected);


        Assert.assertEquals(actual,expected,"record does not match");


    }

    @DataProvider
    Object[][] getData() throws IOException {
        return getMyData("Data/Data.xlsx","db testing");
    }
}
