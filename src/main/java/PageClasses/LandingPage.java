package PageClasses;

import BaseClasses.PageBaseClass;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends PageBaseClass {

    @FindBy(xpath = "//a[@data-track-component='navigation_meta_nav_Business']")
    public WebElement enterpriseBtn;
    @FindBy(id = "enterprise-link")
    public WebElement enterpriseBtn2;

    public LandingPage(WebDriver driver) {
        this.driver = driver;

    }

    public CoursePage enterCourseName(String xpath, String data) {
        WebElement searchBtn = driver.findElement(By.xpath(xpath));
        searchBtn.sendKeys(data + Keys.RETURN);
        return PageFactory.initElements(driver, CoursePage.class);
    }

    public EnterprisePage clickOnForBusiness() {
        try {
            enterpriseBtn2.isDisplayed();
            enterpriseBtn2.click();
        } catch (NoSuchElementException e) {
            enterpriseBtn.click();
        }
        return PageFactory.initElements(driver, EnterprisePage.class);
    }
}
