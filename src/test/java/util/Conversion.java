package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Conversion {

    public static String convertCountry(String shortCountry) // DB
    {
        String fullFormCountry="";

        switch (shortCountry)
        {
            case "IN" : fullFormCountry = "India"; break;
            case "HK" : fullFormCountry = "Hong Kong SAR China"; break;
            case "HU" : fullFormCountry = "Hungary"; break;
            case "IS" : fullFormCountry = "Iceland"; break;
            case "ID" : fullFormCountry = "Indonesia"; break;
        }

        return fullFormCountry;
    }

    public static String getGender(String genderID)
    {
        String gender = "";

        switch (genderID)
        {
            case "0" : gender="Male";break;
            case "1" : gender="Female";break;
            case "2" : gender="Other";break;
        }

        return gender;
    }

    /*  Expected :12/09/1990 --> dd/MM/yyyy
        Actual   :1990-09-12 --> yyyy/MM/dd
*/

    public static String getDate(String dbDateStr) throws ParseException //yyyy-MM-dd
    {
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dbDateStr);

        return new SimpleDateFormat("dd/MM/yyyy").format(date);
    }
}
