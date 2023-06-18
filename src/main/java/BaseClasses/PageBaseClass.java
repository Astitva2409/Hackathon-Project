package BaseClasses;

import PageClasses.LandingPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import utils.DateUtils;
import utils.ExtentReportManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

public class PageBaseClass {
    public static WebDriver driver = null;
    public ExtentReports report = ExtentReportManager.getReportInstance();
    public ExtentTest logger;
    public String[][] data;

    public void invokeBrowser() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//drivers//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public LandingPage openApplication() {
        driver.get("https://www.coursera.org/");
        return PageFactory.initElements(driver, LandingPage.class);

    }

    public String[][] readExcelData(String fileName) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(fileName);
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = xssfWorkbook.getSheet("Test_Data");
        Row row = sheet.getRow(0);
        Cell cell;
        data = new String[1][12];
        for (int i = 0; i < 12; i++) {
            cell = row.getCell(i);
            switch (cell.getCellType()) {
                case STRING:
                    data[0][i] = cell.getStringCellValue();
                    break;

                case NUMERIC:
                    data[0][i] = String.valueOf(cell.getNumericCellValue());
                    break;
            }
        }
        return data;
    }

    public void setFirstName(WebElement firstName, String data) {
        firstName.sendKeys(data);
    }

    public void setLastName(WebElement lastName, String data) {
        lastName.sendKeys(data);
    }

    public void setJobTitle(WebElement jobTitle, String data) {
        jobTitle.sendKeys(data);
    }

    public void setPrimaryDiscipline(WebElement discipline, String data) {
        Select select = new Select(discipline);
        select.selectByVisibleText(data);
    }

    public void setEmail(WebElement workEmail, String data) {
        workEmail.sendKeys(data);
    }

    public void setPhone(WebElement phone, String data) {
        phone.sendKeys(data);
    }

    public void setInstitutionName(WebElement institutionName, String data) {
        institutionName.sendKeys(data);
    }

    public void setInstitutionType(WebElement institutionType, String data) {
        Select select = new Select(institutionType);
        select.selectByVisibleText(data);
    }

    public void setCountry(WebElement country, String data) {
        Select select = new Select(country);
        select.selectByVisibleText(data);
    }

    public void setState(WebElement state, String data) {
        Select select = new Select(state);
        select.selectByVisibleText(data);
    }

    public void setDescription(WebElement description, String data) {
        Select select = new Select(description);
        select.selectByVisibleText(data);
    }

    public void setBrief(WebElement brief, String data) {
        brief.sendKeys(data);
    }

    public void clickSubmitBtn(WebElement submitBtn) {
        submitBtn.click();
    }

    public void takeScreenShot() {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File srcfile = screenshot.getScreenshotAs(OutputType.FILE);
        String fileName = DateUtils.getTime();
        String destPath = System.getProperty("user.dir") + "//screenshots//" + fileName + ".png";
        try {
            FileUtils.copyFile(srcfile, new File(destPath));
            System.out.println("Saved successfully");
        } catch (Exception e) {
            System.out.println("Failed to save ss");
        }
    }

    public void quitBrowser() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }

    @AfterMethod
    public void flush() {
        report.flush();
    }
}
