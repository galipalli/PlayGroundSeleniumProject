package Utilities;

import Base.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class TestUtil extends TestBase {

    public static String screenshotPath;
    public static String screenshotName;




    public static void captureScreenshot(WebDriver driver) throws IOException {
       File scrFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
       Date d= new Date();
       screenshotName = d.toString().replace(":","_").replace(" ", "_")+".jpg";

       FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"\\src\\test\\java\\Screenshot\\"+screenshotName));
    }

    @DataProvider
    public Object[][] getUtilData() {
        String excelPath = System.getProperty("user.dir")+"\\src\\test\\java\\excel\\testdata.xlsx";
        ExcelUtilis excel = new ExcelUtilis(excelPath, "OpenAccountTest");
        int rowCount = excel.getRowCount();
        int colCount = excel.getColCount();
        Object data[][] = new Object[rowCount - 1][colCount];
        for (int i=1; i<rowCount; i++) {
            for (int j=0; j<colCount; j++) {
                String cellData = excel.getCellDataString(i, j);
                data[i-1][j] = cellData;

            }
        }

        return data;

    }
}
