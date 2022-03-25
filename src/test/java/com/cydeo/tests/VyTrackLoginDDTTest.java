package com.cydeo.tests;

import com.cydeo.pages.VyTrackDashboardPage;
import com.cydeo.pages.VyTrackLoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class VyTrackLoginDDTTest {

    VyTrackLoginPage vyTrackLoginPage = new VyTrackLoginPage();
    VyTrackDashboardPage vyTrackDashboardPage = new VyTrackDashboardPage();
    String filePath = "SampleData.xlsx";
    XSSFWorkbook workbook;
    XSSFSheet sheet;

    @Before
    public void setUp(){
        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack.url"));
    }

    @After
    public void tearDown(){
        Driver.closeDriver();
    }

    @Test
    public void vytrack_login_DDT_test() throws IOException {

        FileInputStream fileInputStream = new FileInputStream(filePath);
        workbook = new XSSFWorkbook(fileInputStream);
        sheet = workbook.getSheet("VyTrackData");

        for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {
            String username = sheet.getRow(rowNum).getCell(0).toString();
            String password = sheet.getRow(rowNum).getCell(1).toString();
            String firstName = sheet.getRow(rowNum).getCell(2).toString();
            String lastName = sheet.getRow(rowNum).getCell(3).toString();

            vyTrackLoginPage.login(username,password);

            WebDriverWait wait = new WebDriverWait(Driver.getDriver(),30);
            WebElement loaderMask = Driver.getDriver().findElement(By.cssSelector("div[class='loader-mask']"));
            wait.until(ExpectedConditions.invisibilityOf(loaderMask));
            String actualFullNameText = vyTrackDashboardPage.fullName.getText();
            XSSFCell resultCell = sheet.getRow(rowNum).getCell(4);
            if(actualFullNameText.contains(firstName) && actualFullNameText.contains(lastName)){
                System.out.println("PASS");
                resultCell.setCellValue("PASS");
            }else{
                System.out.println("FAIL");
                resultCell.setCellValue("FAIL");
            }
            BrowserUtils.sleep(2);
            vyTrackDashboardPage.logout();

        }

        FileOutputStream outputStream = new FileOutputStream(filePath);
        workbook.write(outputStream);

        outputStream.close();
        workbook.close();
        fileInputStream.close();







    }





}
